import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.orange.base.BasePage;
import com.orange.pages.HomePage;
import com.orange.pages.LoginPage;
import com.orange.util.ExcelUtil;

public class ExcelTestxyz {

	WebDriver driver;
	BasePage basePage;
	Properties properties;
	LoginPage loginPage;
	HomePage homePage;
    ExcelTestxyz excel;

@BeforeTest
public void setUp() {
	

basePage = new BasePage();
properties = basePage.initialize_properties();
driver = basePage.initialize_driver();
loginPage = new LoginPage(driver);



}

//@DataProvider
//public Object[][] getContactData(){
//	Object [][] data = ExcelUtil.getTestData("Users");
//	return data;
//}


@Test(dataProvider = "getContactData")
public void hadiartik() {

	System.out.println("Islem tamam");
	
	
}
@AfterTest
public void tearUp() {
	
driver.close();	
}

}