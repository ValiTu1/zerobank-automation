package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountActivityPage extends DashBoardPage{

    @FindBy(xpath = "//input[@id='aa_description']")
    public WebElement description;

    @FindBy(xpath = "//input[@id='aa_fromDate']")
    public WebElement fromDate;

    @FindBy(xpath = "//input[@id='aa_toDate']")
    public WebElement toDate;

    @FindBy(tagName = "button")
    public WebElement searchBtn;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//td[1]")
    public List<WebElement> visibleDateTransactions;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//td[2]")
    public List<WebElement> visibleDescriptionTransactions;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//td[3]")
    public List<WebElement> visibleDepositTransactions;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//td[4]")
    public List<WebElement> visibleWithdrawalTransactions;

    @FindBy(id = "aa_type")
    public WebElement typeSelection;

    @FindBy(xpath = "//select[@id='aa_accountId']")
    public WebElement accountsDropdown;

    @FindBy(xpath = "//th")
    public List<WebElement> tableColumnNames;



    public void selectSubTab(String subtabName){
        Driver.get().findElement(By.xpath("//a[.='"+subtabName+"']")).click();
    }



    public void sendKeys(WebElement element, String keys){
        element.clear();
        element.sendKeys(keys);
    }

}
