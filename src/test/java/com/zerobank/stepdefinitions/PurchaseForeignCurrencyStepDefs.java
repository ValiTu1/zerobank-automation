package com.zerobank.stepdefinitions;

import com.zerobank.pages.PurchaseForeignCurrencyPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class PurchaseForeignCurrencyStepDefs {


    PurchaseForeignCurrencyPage currencyPage = new PurchaseForeignCurrencyPage();

    public static WebDriverWait wait = new WebDriverWait(Driver.get(), 5);


    public static Select select;

    @Given("the user accesses the Purchase foreign currency cash tab")
    public void the_user_accesses_the_Purchase_foreign_currency_cash_tab() {
        BrowserUtils.waitFor(2);

        currencyPage.navigateToTabModule("Pay Bills", "Purchase Foreign Currency");
    }

    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> currencyList) {
        BrowserUtils.waitFor(1);

        select = new Select(currencyPage.currencyDropdown);
        for(String currency: currencyList){
            select.selectByVisibleText(currency);
            BrowserUtils.waitFor(1);
            Assert.assertTrue(select.getFirstSelectedOption().getText().equals(currency));
        }

    }

    @When("user tries to calculate cost without selecting a currency")
    public void userTriesToCalculateCostWithoutSelectingACurrency() {

        wait.until(ExpectedConditions.elementToBeClickable(currencyPage.calculateCostsBtn));
        currencyPage.amount.sendKeys("1");
        currencyPage.calculateCostsBtn.click();

    }

    @Then("error message should be displayed")
    public void errorMessageShouldBeDisplayed() {
    BrowserUtils.waitFor(1);
    wait.until(ExpectedConditions.alertIsPresent());
    String expectedErrorMessage = "Please, ensure that you have filled all the required fields with valid values.";
    Alert alert = Driver.get().switchTo().alert();
        Assert.assertEquals(expectedErrorMessage, alert.getText());
    }

    @When("user tries to calculate cost without entering a value")
    public void userTriesToCalculateCostWithoutEnteringAValue() {
        wait.until(ExpectedConditions.elementToBeClickable(currencyPage.calculateCostsBtn));
        select = new Select(currencyPage.currencyDropdown);
        select.selectByIndex(1);
        currencyPage.calculateCostsBtn.click();
    }
}
