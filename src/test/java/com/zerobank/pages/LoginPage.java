package com.zerobank.pages;

import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{

    @FindBy(css = "input[id=user_login]")
    public WebElement username;

    @FindBy(css = "input[id=user_password]")
    public WebElement password;

    @FindBy(css = "input[name='submit']")
    public WebElement loginSubmitBtn;

    @FindBy(xpath = "//div[contains(text(),'Login and/or password')]")
    public WebElement errorMessage;

    public void login(){
        username.sendKeys(ConfigurationReader.get("username"));
        password.sendKeys(ConfigurationReader.get("password"));
    }



}
