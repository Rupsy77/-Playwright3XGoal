package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InvalidLoginTest extends BaseTest {

    @Test(priority = 1)
    public void testLoginWithInvalidCredentials() {
        try {
            loginPage.doLogin("wrong@email.com", "incorrectPass");
            Assert.assertTrue(loginPage.isErrorDisplayed(), "Error expected for invalid credentials");
            Assert.assertFalse(loginPage.getErrorMessage().isEmpty(), "Error message must not be empty");
        } catch (AssertionError e) {
            throw new AssertionError("Invalid credentials test failed: " + e.getMessage());
        }
    }

    @Test(priority = 2)
    public void testLoginWithEmptyFields() {
        try {
            loginPage.doLogin("", "");
            Assert.assertTrue(loginPage.isErrorDisplayed(), "Error expected when both fields are empty");
        } catch (AssertionError e) {
            throw new AssertionError("Empty fields test failed: " + e.getMessage());
        }
    }

    @Test(priority = 3)
    public void testLoginWithEmptyUsername() {
        try {
            loginPage.doLogin("", "somePassword");
            Assert.assertTrue(loginPage.isErrorDisplayed(), "Error expected when username is empty");
        } catch (AssertionError e) {
            throw new AssertionError("Empty username test failed: " + e.getMessage());
        }
    }

    @Test(priority = 4)
    public void testLoginWithEmptyPassword() {
        try {
            loginPage.doLogin("user@example.com", "");
            Assert.assertTrue(loginPage.isErrorDisplayed(), "Error expected when password is empty");
        } catch (AssertionError e) {
            throw new AssertionError("Empty password test failed: " + e.getMessage());
        }
    }

    @Test(priority = 5)
    public void testLoginWithMalformedEmail() {
        try {
            loginPage.doLogin("not-an-email", "password123");
            Assert.assertTrue(loginPage.isErrorDisplayed(), "Error expected for malformed email input");
        } catch (AssertionError e) {
            throw new AssertionError("Malformed email test failed: " + e.getMessage());
        }
    }
}
