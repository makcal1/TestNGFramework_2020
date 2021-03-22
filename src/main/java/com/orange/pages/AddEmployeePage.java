package com.orange.pages;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.orange.base.BasePage;
import com.orange.util.Constants;
import com.orange.util.ElementUtil;

public class AddEmployeePage extends BasePage {

	
	// fields, locators, driver, elementUtil
	WebDriver driver;
	ElementUtil elementUtil;
	// firstName,lastName,btnSave
	// header xpath : //h1[contains(text(),'Add Employee')]
	// //b[contains(text(),'PIM')]
	// menu_pim_addEmployee
	
	By header = By.xpath("//h1[contains(text(),'Add Employee')]");
	By clickPIM = By.xpath("//b[contains(text(),'PIM')]");
	
	By pimBtn = By.id("menu_pim_viewPimModule");
			By addEmployee = By.id("menu_pim_addEmployee");
			By firstName = By.id("firstName");
			By lastName = By.id("lastName");
			By btnSave = By.id("btnSave");
			By employeeList=By.id("menu_pim_viewEmployeeList");
			By searchbutton = By.id("searchBtn");
			By namE=By.id("empsearch_employee_name_empName");
			By verifyText=By.xpath("//*[@id='resultTable']/tbody/tr");
	
	
	// constructor
	public AddEmployeePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	
	// methods
	
	public String getAddEmployeePageHeader(){
		return driver.findElement(header).getText();
	}
	
	public void goToAddEmployee(){
		elementUtil.waitForElementPresentBy(pimBtn);
		driver.findElement(pimBtn).click();
		elementUtil.waitForElementPresentBy(addEmployee);
		driver.findElement(addEmployee).click();
	}
	
	public void addEmployee(String firstname, String lastname){
elementUtil.waitForElementPresentBy(firstName);
		driver.findElement(this.firstName).sendKeys(firstname);
	elementUtil.waitForElementPresentBy(lastName);
		driver.findElement(this.lastName).sendKeys(lastname);
	elementUtil.waitForElementPresentBy(btnSave);
		driver.findElement(btnSave).click();
		
	}public void goAndSearchEmployee(String employeeName) {
		elementUtil.waitForElementPresentBy(pimBtn);
		driver.findElement(pimBtn).click();
		elementUtil.waitForElementPresentBy(employeeList);
		elementUtil.doClick(employeeList);
		elementUtil.doSendKeys(namE, employeeName);
		elementUtil.waitForElementPresentBy(searchbutton);
		
		elementUtil.doClick(searchbutton);
		

		
		
}public boolean assertVerification() {
	WebElement text=driver.findElement(verifyText);
	System.out.println(text.getText());
	boolean x = !text.getText().contains("No Records Found");
	return x;

}
	

}
