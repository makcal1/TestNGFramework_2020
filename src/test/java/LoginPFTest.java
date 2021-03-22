import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.orange.base.BasePage;
import com.orange.pages.LoginPagePPF;

public class LoginPFTest {

WebDriver driver;
Properties properties;
BasePage basePage;
LoginPagePPF loginPagePPF;


@BeforeTest
public void setUp() {
basePage = new BasePage();
properties = basePage.initialize_properties();
driver= basePage.initialize_driver();
loginPagePPF = new LoginPagePPF(driver);
	
	
}
@Test
public void loginTest() {
loginPagePPF.doLogin(properties.getProperty("username"), properties.getProperty("password"));	
	
}
@AfterTest
public void tearDown() {
	
driver.quit();
	
}
	
}
