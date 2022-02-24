package com.zerobank.stepdefinitions;

import com.zerobank.pages.AddNewPayeePage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.Map;

public class AddNewPayeeStepDefs {

    AddNewPayeePage payBillsPage = new AddNewPayeePage();

    @Given("Add New Payee tab")
    public void add_New_Payee_tab() {
        payBillsPage.navigateToTabModule("Pay Bills", "Add New Payee");
    }

    @Given("creates new payee using following information")
    public void creates_new_payee_using_following_information(Map<String, String> payeeInfo) {
        BrowserUtils.waitFor(1);
        payBillsPage.fillForm(payeeInfo.get("Payee Name"), payeeInfo.get("Payee Address"), payeeInfo.get("Account"), payeeInfo.get("Payee details"));
    }

    @Then("message {string} should be displayed")
    public void messageShouldBeDisplayed(String expectedConfirmationMessage) {
        String actualConfirmationMessage = payBillsPage.confirmationMessage.getText();
        Assert.assertEquals(expectedConfirmationMessage, actualConfirmationMessage);
    }
}
