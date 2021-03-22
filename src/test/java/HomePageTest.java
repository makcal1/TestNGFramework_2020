import java.util.Properties;

import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.orange.base.BasePage;
import com.orange.pages.HomePage;
import com.orange.pages.LoginPage;
import com.orange.util.Constants;
import com.orange.util.ElementUtil;
@Listeners(com.orange.listeners.ExtentReportListener.class)
public class HomePageTest {
	Logger logger = Logger.getLogger(HomePageTest.class);
	WebDriver driver;
	BasePage basePage;
	Properties properties;
	LoginPage loginPage;
	HomePage homePage;
	
	@BeforeMethod
	public void setup(){
		basePage = new BasePage();
		logger.info("Browser is launching...");
		properties = basePage.initialize_properties();
		driver = basePage.initialize_driver();
		loginPage = new LoginPage(driver);
		//homePage = loginPage.doLogin("Admin","admin123");
		
		homePage = loginPage.doLogin(properties.getProperty("username"),
				properties.getProperty("password"));
	}
	
	@Test
	public void verifyHomePageTitle(){
		BasicConfigurator.configure();  
		logger.info("Verifying home page title starting...");
		String actualTitle = homePage.getHomePageTitle();
		Assert.assertEquals(actualTitle, "OrangeHRM");
		logger.info("Verifying home page title ending...");
	}
	
	@Test
	public void verifyHeader(){
		logger.info("Verifying home page header starting...");
		Assert.assertEquals(homePage.getPageHeader(), "Dashboard");
		logger.info("Verifying home page header ending...");
	}
	
	@Test
	public void verifyAccountName(){
		String accountName = homePage.getLoggedInUserAccountName();
		System.out.println(accountName);
		Assert.assertTrue(accountName.contains("Welcome"));
		
	}
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
