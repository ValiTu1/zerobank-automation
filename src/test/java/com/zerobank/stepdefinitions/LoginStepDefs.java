package com.zerobank.stepdefinitions;

import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefs {

    LoginPage loginPage = new LoginPage();

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));
        loginPage.signinBtn.click();
    }


    @Then("Account summary page should be displayed")
    public void account_summary_page_should_be_displayed() {
        BrowserUtils.waitForPageToLoad(5);
        String expectedPageTitle = "Zero - Account Summary";
        String actualPageTitle = Driver.get().getTitle();

        Assert.assertEquals(expectedPageTitle,actualPageTitle);
    }

    @Then("{string} should be displayed")
    public void should_be_displayed(String expectedError) {
        BrowserUtils.waitForVisibility(loginPage.errorMessage, 5);
        String actualError = loginPage.errorMessage.getText();
        Assert.assertEquals(expectedError, actualError);

    }


    @When("User enters valid {string} and {string} credentials")
    public void userEntersValidUsernameAndPasswordCredentials(String usernameValue, String passwordValue) {

             BrowserUtils.waitFor(2);
            loginPage.login();
            loginPage.loginSubmitBtn.click();
            Driver.get().get("http://zero.webappsecurity.com/bank/account-summary.html");
    }

    @When("User enters {string} or {string} credentials")
    public void userEntersInvalidAndOrCredentials(String usernameValue, String passwordValue) {
            loginPage.username.sendKeys(usernameValue);
            loginPage.password.sendKeys(passwordValue);
            loginPage.loginSubmitBtn.click();
    }

    @Then("{string} page should be displayed")
    public void pageShouldBeDisplayed(String expectedTab) {
        BrowserUtils.waitFor(1);
        Assert.assertTrue(Driver.get().getTitle().contains(expectedTab));
    }
}
