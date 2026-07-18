package pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//input[@id='username']") WebElement username;
    @FindBy(xpath = "//input[@id='password']") WebElement password;
    @FindBy(xpath = "//input[@id='Login']") WebElement loginButton;
    @FindBy(xpath = "//input[@id='rememberUn']") WebElement rememberMe;
    @FindBy(xpath = "//div[@id='error']") WebElement error;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    public void doLogin(String user, String pass) {
        try {
            wait.until(ExpectedConditions.visibilityOf(username)).sendKeys(user);
            password.sendKeys(pass);
            loginButton.click();
        } catch (Exception e) {
            throw new RuntimeException("Login failed: " + e.getMessage());
        }
    }

    public void doLoginWithRememberMe(String user, String pass) {
        try {
            wait.until(ExpectedConditions.visibilityOf(username)).sendKeys(user);
            password.sendKeys(pass);
            if (!rememberMe.isSelected()) rememberMe.click();
            loginButton.click();
        } catch (Exception e) {
            throw new RuntimeException("Login with remember me failed: " + e.getMessage());
        }
    }

    public String getErrorMessage() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(error)).getText();
        } catch (Exception e) {
            return "";
        }
    }

    public boolean isErrorDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(error)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
