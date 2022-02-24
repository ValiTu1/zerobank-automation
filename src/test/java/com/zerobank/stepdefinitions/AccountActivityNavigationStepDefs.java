package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountActivityNavigationStepDefs {

    LoginPage loginPage = new LoginPage();
    AccountSummaryPage summaryPage = new AccountSummaryPage();
    AccountActivityPage activityPage = new AccountActivityPage();


    @Given("the user is logged in")
    public void the_user_is_logged_in() {
        loginPage.signinBtn.click();
        loginPage.login();
        loginPage.loginSubmitBtn.click();
    }

    @Then("the Account Activity page should be displayed")
    public void the_Account_Activity_page_should_be_displayed() {
        String expectedTitle = "Zero - Account Activity";
        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
    }

    @When("the user clicks on {string} link on the Account Summary page")
    public void theUserClicksOnLinkOnTheAccountSummaryPage(String accountType) {
        summaryPage.selectAccountType(accountType);
    }

    @And("Account drop down should have {string} selected")
    public void accountDropDownShouldHaveSelected(String defaultOption) {
        Select select = new Select(activityPage.accountsDropdown);
        String expectedDefaultOption = defaultOption;
        String actualDefaultOption = select.getFirstSelectedOption().getText();

        Assert.assertEquals(expectedDefaultOption,actualDefaultOption);
    }

    @When("the user moves to Account Activity page")
    public void theUserMovesToAccountActivityPage() {
        BrowserUtils.waitFor(2);
        activityPage.navigateToTabModule("Account Activity", "Show Transactions");
        Assert.assertTrue(Driver.get().getTitle().contains("Zero - Account Activity"));

    }

    @Then("account dropdown should have {string} as default option and the following options")
    public void accountDropdownShouldHaveAsDefaultOptionAndTheFollowingOptions(String defaultOption, List<String> expectedDropdownOptions) {
        BrowserUtils.waitFor(1);

        Select select = new Select(activityPage.accountsDropdown);
        Assert.assertTrue(select.getFirstSelectedOption().getText().equals(defaultOption));

        List<String> actualDropdownOptions = BrowserUtils.getElementsText(select.getOptions());
        for (String each: expectedDropdownOptions){
            Assert.assertTrue(actualDropdownOptions.contains(each));
        }
    }

    @And("transaction table should have the following column names")
    public void transactionTableShouldHaveTheFollowingColumnNames(List<String> expectedColumnNames) {

        List<String> actualColumnNames = BrowserUtils.getElementsText(activityPage.tableColumnNames);

        Assert.assertEquals(expectedColumnNames,actualColumnNames);

    }
}
