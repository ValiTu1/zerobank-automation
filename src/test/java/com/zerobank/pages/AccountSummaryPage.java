package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AccountSummaryPage extends DashBoardPage{

    @FindBy(xpath = "(//*[.='Savings'])[1]")
    public WebElement savingsLink;

    @FindBy(className = "board-header")
    public List<WebElement> accTypes;

    @FindBy(xpath = "//div[@class='board'][3]//th")
    public List<WebElement> creditAccColumns;

    public void selectAccountType(String accountType){
        actions.moveToElement(Driver.get().findElement(By.xpath("//a[.='"+accountType+"']"))).perform();
        Driver.get().findElement(By.xpath("//a[.='"+accountType+"']")).click();
    }
}
