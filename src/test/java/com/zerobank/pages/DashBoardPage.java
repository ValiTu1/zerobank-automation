package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class DashBoardPage {

    public DashBoardPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    WebDriverWait wait = new WebDriverWait(Driver.get(), 10);
    Actions actions = new Actions(Driver.get());


    public void navigateToTabModule(String tab, String module){
        Driver.get().findElement(By.xpath("//a[text()='"+tab+"']")).click();
        Driver.get().findElement(By.xpath("//a[.='"+module+"']")).click();
    }

    public void selectTab(String tabName){
        Driver.get().findElement(By.xpath("//a[text()='"+tabName+"']")).click();
    }

    public void selectSubTab(String subtabName){
        Driver.get().findElement(By.xpath("//a[.='"+subtabName+"']")).click();
    }

}
