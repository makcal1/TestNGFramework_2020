import static org.testng.Assert.assertEquals;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.orange.base.BasePage;
import com.orange.pages.HomePage;
import com.orange.pages.LoginPage;
import com.orange.pages.AddEmployeePage;
import com.orange.util.Constants;
import com.orange.util.ElementUtil;
import com.orange.util.ExcelUtil;

@Listeners(com.orange.listeners.ExtentReportListener.class)
public class AddEmployeePageTest {
	WebDriver driver;
	BasePage basePage;
	Properties properties;
	LoginPage loginPage;
    HomePage homepage;
    AddEmployeePage addEmployee;
	//@beforeMethod Setup , @aftermethod teardown, @test dologintest()...
	//Preconditions on @beforemethod

	@BeforeMethod
	public void setUp(){
	basePage = new BasePage();
	properties = basePage.initialize_properties();
	driver = basePage.initialize_driver();
	loginPage = new LoginPage(driver);	
	homepage = loginPage.doLogin(properties.getProperty("username"),properties.getProperty("password"));
		
		addEmployee = new AddEmployeePage(driver);
		addEmployee.goToAddEmployee();
	}
		@DataProvider
		public Object [][] getEmployess(){
			
			Object [][] data= ExcelUtil.getTestData("Sayfa1");
			
			
			
	return data;
			
		}	@Test(priority = 1)
		public void employeeVerification1() {
		addEmployee.goAndSearchEmployee("Bureyde");	
		
		boolean condition =addEmployee.assertVerification();
		Assert.assertEquals(condition, true);
		
		
		}	@Test(priority = 2)
		public void employeeVerification2() {
			addEmployee.goAndSearchEmployee("Hasibe Aslann");
			boolean condition =addEmployee.assertVerification();
			Assert.assertEquals(condition, false);
			
			
		}@Test(priority = 3)
		public void employeeVerification3() {
			addEmployee.goAndSearchEmployee("Esra Atakk");
			boolean condition =addEmployee.assertVerification();
			Assert.assertEquals(condition, true);
			
			System.out.println("Test haf passed" + true);
			
		}@Test(priority = 4)
		public void employeeVerification4() {
			addEmployee.goAndSearchEmployee("Deniz Gozell");
			boolean condition =addEmployee.assertVerification();
			Assert.assertEquals(condition, true);
			
		}
	
		
//       @Test
//		public void testUrl(){
//			
//		System.out.println(driver.getCurrentUrl());
//				
////	
//		}	
//
//@Test(dataProvider = "getEmployess")
//		public void addEmployee(String firstname, String lastname) {

//addEmployee.addEmployee(firstname, lastname);
		
		@AfterMethod
		public void tearDown() {
			driver.close();
		}
	
}
