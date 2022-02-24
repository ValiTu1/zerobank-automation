package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class AccountSummaryNavigationStepDefs {

    LoginPage loginPage = new LoginPage();
    AccountSummaryPage summaryPage = new AccountSummaryPage();

    @Given("the user is on Account Summary page")
    public void the_user_is_on_Account_Summary_page() {
        loginPage.signinBtn.click();
        loginPage.login();
        loginPage.loginSubmitBtn.click();
        BrowserUtils.waitForPageToLoad(5);
        String expectedPageTitle = "Zero - Account Summary";
        String actualPageTitle = Driver.get().getTitle();
        Assert.assertEquals(expectedPageTitle, actualPageTitle);
    }

    @Given("Account summary has the following account types")
    public void account_summary_has_the_following_account_types(List<String> expectedAccountTypes) {

        BrowserUtils.waitFor(1);
        List<String> actualAccountTypes = BrowserUtils.getElementsText(summaryPage.accTypes);
        Assert.assertEquals(expectedAccountTypes, actualAccountTypes);
    }

    @Then("Credit Accounts table must have the following columns")
    public void credit_Accounts_table_must_have_the_following_columns(List<String> expectedCreditAccounts) {
        BrowserUtils.waitFor(1);
        List<String> actualCreditAccounts = BrowserUtils.getElementsText(summaryPage.creditAccColumns);
        Assert.assertEquals(expectedCreditAccounts, actualCreditAccounts);
     }
}
