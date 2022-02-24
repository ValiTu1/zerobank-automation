package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddNewPayeePage extends DashBoardPage{

    @FindBy(id = "np_new_payee_name")
    public WebElement payeeName;

    @FindBy(id = "np_new_payee_address")
    public WebElement payeeAddress;

    @FindBy(id="np_new_payee_account")
    public WebElement accountType;

    @FindBy(id = "np_new_payee_details")
    public WebElement payeeDetails;

    @FindBy(id="add_new_payee")
    public WebElement addBtn;

    @FindBy(id="alert_content")
    public WebElement confirmationMessage;

    public void fillForm(String name, String address, String account, String details){
        payeeName.sendKeys(name);
        payeeAddress.sendKeys(address);
        accountType.sendKeys(account);
        payeeDetails.sendKeys(details);
        addBtn.click();
    }


}
