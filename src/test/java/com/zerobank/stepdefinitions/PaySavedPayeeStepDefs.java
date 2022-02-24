package com.zerobank.stepdefinitions;

import com.zerobank.pages.PaySavedPayeePage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.logging.Log;
import org.junit.Assert;

public class PaySavedPayeeStepDefs {

    PaySavedPayeePage savedPayeePage = new PaySavedPayeePage();

    @Given("Account Activity page has {string} as title")
    public void account_Account_Activity_page_has_as_title(String expectedTitle) {
        savedPayeePage.navigateToTabModule("Pay Bills", "Pay Saved Payee");
        BrowserUtils.waitFor(1);
        Assert.assertEquals(expectedTitle, Driver.get().getTitle());
    }

    @When("user completes a successful pay operation")
    public void user_completes_a_successful_pay_operation() {
        BrowserUtils.waitFor(1);
        savedPayeePage.fillPaymentDetails("Apple", "Checking", "100", "2022-06-06", "Saving money");

    }

    @Then("A successful message should be displayed should be displayed")
    public void a_successful_message_should_be_displayed_should_be_displayed() {
        String expectedMessage ="The payment was successfully submitted.";
        String actualMessage = savedPayeePage.successfulMessage.getText();

        Assert.assertEquals(expectedMessage,actualMessage);
    }

    @When("user tries to make a payment without entering amount or date")
    public void user_tries_to_make_a_payment_without_entering_amount_or_date() {
        BrowserUtils.waitFor(1);
        savedPayeePage.fillPaymentDetails("Apple", "Checking", "100", "null", "Saving money");
    }

    @Then("An error message should be displayed")
    public void an_error_message_should_be_displayed() {
        String expectedErrorMessage = "Please fill out this field.";
        String actualErrorMessage = savedPayeePage.date.getAttribute("validationMessage");
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
    }


}
