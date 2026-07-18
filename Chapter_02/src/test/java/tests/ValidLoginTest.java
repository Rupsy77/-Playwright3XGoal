package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidLoginTest extends BaseTest {

    @Test(priority = 1)
    public void testLoginWithValidCredentials() {
        try {
            loginPage.doLogin("testuser@example.com", "ValidPass123");
            Assert.assertFalse(loginPage.isErrorDisplayed(), "No error expected on valid login attempt");
        } catch (AssertionError e) {
            throw new AssertionError("Valid login test failed: " + e.getMessage());
        }
    }

    @Test(priority = 2)
    public void testLoginWithRememberMeChecked() {
        try {
            loginPage.doLoginWithRememberMe("testuser@example.com", "ValidPass123");
            Assert.assertFalse(loginPage.isErrorDisplayed(), "No error expected when logging in with remember me");
        } catch (AssertionError e) {
            throw new AssertionError("Remember me login test failed: " + e.getMessage());
        }
    }

    @Test(priority = 3)
    public void testPageTitleContainsSalesforce() {
        try {
            Assert.assertTrue(driver.getTitle().toLowerCase().contains("salesforce"),
                    "Page title must contain Salesforce");
        } catch (AssertionError e) {
            throw new AssertionError("Page title validation failed: " + e.getMessage());
        }
    }

    @Test(priority = 4)
    public void testUrlContainsLoginSalesforce() {
        try {
            Assert.assertTrue(driver.getCurrentUrl().contains("login.salesforce.com"),
                    "URL must point to login.salesforce.com");
        } catch (AssertionError e) {
            throw new AssertionError("URL validation failed: " + e.getMessage());
        }
    }
}
