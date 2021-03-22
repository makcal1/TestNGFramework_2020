package com.orange.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.orange.base.BasePage;
import com.orange.util.ElementUtilPF;

public class LoginPagePPF extends BasePage {

WebDriver driver;
ElementUtilPF elementUtilPF;

//Page Factory Concept = @FindBy


@FindBy(how = How.ID, using = "txtUsername")
@CacheLookup
WebElement username;
	
@FindBy(how  =How.ID,using = "txtPassword")	
@CacheLookup
WebElement password;

@FindBy(how  =How.ID,using = "btnLogin")	
@CacheLookup
WebElement loginButton;

public LoginPagePPF(WebDriver driver) {
	
this.driver = driver;
PageFactory.initElements(driver, this);
elementUtilPF = new ElementUtilPF(driver);
	
	
}
public void doLogin(String username, String pwd) {
elementUtilPF.waitforElementPresent(loginButton);	
loginButton.sendKeys(username);
password.sendKeys(pwd);
loginButton.click();
	


}

}
