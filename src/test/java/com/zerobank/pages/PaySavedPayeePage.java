package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class PaySavedPayeePage extends DashBoardPage{

    @FindBy(id = "sp_payee")
    public WebElement payeeDropdown;

    @FindBy(id = "sp_account")
    public WebElement accountDropdown;

    @FindBy(id = "sp_amount")
    public WebElement amount;

    @FindBy(id = "sp_date")
    public WebElement date;

    @FindBy(id = "sp_description")
    public WebElement description;

    @FindBy(id = "pay_saved_payees")
    public WebElement payBtn;

    @FindBy(css = "div>span")
    public WebElement successfulMessage;



    public void fillPaymentDetails( String payee,String account, String amountValue, String dateValue, String descriptionValue){
        /*payeeDropdown.selectByVisibleText(payee);
        accountDropdown.selectByVisibleText(account);*/
        Select selectPayeeDowpdown = new Select(payeeDropdown);
        selectPayeeDowpdown.selectByVisibleText(payee);
        Select selectAccount = new Select(accountDropdown);
        selectAccount.selectByVisibleText(account);
        amount.sendKeys(amountValue);
        date.sendKeys(dateValue);
        description.sendKeys(descriptionValue);
        payBtn.click();
        BrowserUtils.waitFor(2);
    }


}
