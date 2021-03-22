package com.orange.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.orange.base.BasePage;
import com.orange.util.ElementUtil;
import com.orange.util.JavaScriptUtil;

public class LoginPage extends BasePage {
	// fields : driver,locators
		WebDriver driver;
		ElementUtil elementUtil;
		By Username = By.id("txtUsername");
		By Password = By.id("txtPassword");
		By loginBtn = By.id("btnLogin");
		
		// Constructor
		public LoginPage(WebDriver driver) {
			this.driver = driver;
			
			
			
			elementUtil = new ElementUtil(driver);
		}
		
		// Page Actions
		public String getPageTitle(){
			String title = driver.getTitle();
			return title;
		}
		
		public HomePage doLogin(String  username, String password){
			driver.findElement(this.Username).sendKeys(username);
			driver.findElement(this.Password).sendKeys(password);
			driver.findElement(loginBtn).click();
			return new HomePage(driver);
		}
		
}
