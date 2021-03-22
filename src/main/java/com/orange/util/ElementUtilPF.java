package com.orange.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.orange.base.BasePage;

public class ElementUtilPF extends BasePage {

WebDriver driver;
public ElementUtilPF(WebDriver driver) {
	
	
this.driver = driver;	
	
}
	
public void waitforElementPresent(WebElement element) {
	
	
WebDriverWait wait = new WebDriverWait(driver, 20);
wait.until(ExpectedConditions.visibilityOf(element));
	
	
	
	
}
	
	
	
	
	
	
}
