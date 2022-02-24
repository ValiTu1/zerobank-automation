package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PurchaseForeignCurrencyPage extends DashBoardPage{

    @FindBy(id="pc_currency")
    public WebElement currencyDropdown;

    @FindBy(id="pc_amount")
    public WebElement amount;

    @FindBy(id = "pc_calculate_costs")
    public WebElement calculateCostsBtn;

    @FindBy(id = "purchase_cash")
    public WebElement purchaseBtn;


}
