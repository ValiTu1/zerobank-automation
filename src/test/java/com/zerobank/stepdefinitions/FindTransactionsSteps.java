package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import sun.rmi.runtime.Log;

import java.util.List;

public class FindTransactionsSteps {

    LoginPage loginPage = new LoginPage();
    AccountActivityPage activityPage = new AccountActivityPage();

    List<String> dates = BrowserUtils.getElementsText(activityPage.visibleDateTransactions);
    List<String> descriptions;
    List<String> deposits;
    List<String> withdrawals;


    @Given("the user accesses the Find Transactions tab")
    public void the_user_accesses_the_Find_Transactions_tab() {
        activityPage.navigateToTabModule("Account Activity", "Find Transactions");
    }

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String startingDate, String endingDate) {
        BrowserUtils.waitFor(1);

        activityPage.sendKeys(activityPage.fromDate, startingDate);
        activityPage.sendKeys(activityPage.toDate, endingDate);
    }

    @When("clicks search")
    public void clicks_search() {
        BrowserUtils.waitForVisibility(activityPage.searchBtn, 3);
        activityPage.searchBtn.click();
    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String fromDate, String toDate) {
        BrowserUtils.waitFor(2);

        for(String each: dates){
            Assert.assertTrue(each.compareTo(fromDate) >=0 && each.compareTo(toDate) <=0);
        }
    }

    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {

        if(dates.size()>0){
            String mostRecentDate = dates.get(0);
            for(int i=0;i<dates.size();i++){
                Assert.assertTrue(mostRecentDate.compareTo(dates.get(i))>=0);
                mostRecentDate = dates.get(i);
            }
        }
    }

    @And("the results table should only not contain transactions dated {string}")
    public void theResultsTableShouldOnlyNotContainTransactionsDated(String dateToCompare) {
        for(String each: dates){
            Assert.assertTrue(each.compareTo(dateToCompare) !=0 );
        }
    }

    @When("the user enters description {string}")
    public void theUserEntersDescription(String descriptionValue) {
        BrowserUtils.waitFor(1);
        activityPage.sendKeys(activityPage.description, descriptionValue.toUpperCase());
    }

    @Then("results table should only show descriptions containing {string}")
    public void resultsTableShouldOnlyShowDescriptionsContaining(String descriptionValue) {

        BrowserUtils.waitFor(1);
        descriptions = BrowserUtils.getElementsText(activityPage.visibleDescriptionTransactions);
        for (String description : descriptions) {
            Assert.assertTrue(description.contains(descriptionValue));
        }
    }

    @But("results table should not show descriptions containing {string}")
    public void resultsTableShouldNotShowDescriptionsContaining(String descriptionValue) {

        BrowserUtils.waitFor(1);
        descriptions = BrowserUtils.getElementsText(activityPage.visibleDescriptionTransactions);
        for (String description : descriptions) {
            Assert.assertFalse(!description.contains(descriptionValue));
        }
    }

    @Then("results table should show at least one result under Deposit")
    public void resultsTableShouldShowAtLeastOneResultUnderDeposit() {
        BrowserUtils.waitFor(1);
        deposits = BrowserUtils.getElementsText(activityPage.visibleDepositTransactions);
        Assert.assertTrue(deposits.size()>0);
    }

    @Then("results table should show at least one result under Withdrawal")
    public void resultsTableShouldShowAtLeastOneResultUnderWithdrawal() {

        withdrawals = BrowserUtils.getElementsText(activityPage.visibleWithdrawalTransactions);
        Assert.assertTrue(withdrawals.size()>0);
    }

    @When("user selects type {string}")
    public void userSelectsType(String typeOption) {
        BrowserUtils.waitFor(1);
        Select select = new Select(activityPage.typeSelection);
        select.selectByValue(typeOption.toUpperCase());
        activityPage.searchBtn.click();
    }

    @But("results table should show no result under Withdrawal")
    public void resultsTableShouldShowNoResultUnderWithdrawal() {

        BrowserUtils.waitFor(1);
        withdrawals = BrowserUtils.getElementsText(activityPage.visibleWithdrawalTransactions);
        if(withdrawals.size()>0){
            for(String withdrawal: withdrawals){
                Assert.assertTrue(withdrawal.trim().isEmpty());
            }
        }

    }

    @But("results table should show no result under Deposit")
    public void resultsTableShouldShowNoResultUnderDeposit() {
        BrowserUtils.waitFor(1);
        deposits = BrowserUtils.getElementsText(activityPage.visibleDepositTransactions);

        if(deposits.size()>0){
            for(String deposit: deposits){
                Assert.assertTrue(deposit.trim().isEmpty());
            }
        }
    }
}
