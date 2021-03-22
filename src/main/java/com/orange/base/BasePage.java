package com.orange.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.orange.util.Constants;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
 
	// Fields, driver, properties
	
		//WebDriver driver;
		Properties properties;
		OptionsManager optionsManager;
		
		public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
		public static synchronized WebDriver getDriver(){
			return driver.get();
		}
		
		// initialize driver
		
		public WebDriver initialize_driver(){
			
			properties = initialize_properties();
			optionsManager = new OptionsManager(properties);
			String browser = properties.getProperty("browser");
			if (browser.equals("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver.set(new ChromeDriver(optionsManager.getChromeOptions()));
			} 
			else if(browser.equals("firefox")){
				WebDriverManager.firefoxdriver().setup();
				driver.set(new FirefoxDriver(optionsManager.getFireFoxOptions()));
			}
			else {
				System.out.println("Undefined Browser");
			}
			
			// List all options here
			getDriver().manage().deleteAllCookies();
			getDriver().manage().timeouts().pageLoadTimeout(Constants.DEFAULT_TIMEOUT, TimeUnit.SECONDS);
			getDriver().manage().timeouts().implicitlyWait(Constants.DEFAULT_TIMEOUT, TimeUnit.SECONDS);
			getDriver().get(properties.getProperty("url"));
			return getDriver();
		}
		
		
		// initializing properties
		public Properties initialize_properties(){
			properties = new Properties();
			try {
				FileInputStream inputStream = new FileInputStream("C:\\Users\\muham\\eclipse-workspace\\TestNGFramework_2020\\src\\main\\java\\com\\orange\\config\\config.properties");
				properties.load(inputStream);
			} catch (IOException e) {
				System.out.println("Problem on config");
			}
			return properties;
		}
		
		
		


}
