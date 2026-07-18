package base;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;

public class BaseTest {
    protected WebDriver driver;
    protected LoginPage loginPage;

    @BeforeTest
    public void setup() {
        try {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized", "--disable-notifications");
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            loginPage = new LoginPage(driver);
            driver.get("https://login.salesforce.com/?locale=in");
        } catch (Exception e) {
            throw new RuntimeException("Setup failed: " + e.getMessage());
        }
    }

    @AfterTest
    public void teardown() {
        if (driver != null) driver.quit();
    }
}
