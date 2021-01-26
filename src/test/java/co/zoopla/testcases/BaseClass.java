package co.zoopla.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import co.zoopla.utility.BrowserFactory;

public class BaseClass {
	
	WebDriver driver;
	
	
	protected WebDriver firefox() {
		System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
        return new FirefoxDriver();
    }

    protected WebDriver chrome() {
    	System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
        return new ChromeDriver();
    }
    
    protected WebDriver IE() {
    	System.setProperty("webdriver.chrome.driver","./Drivers/IEDriverServer.exe");
        return new ChromeDriver();
    }
    
    
}
    
	/*
	@BeforeClass
	@Parameters({"browser"})
	public void setup(String browserName) {
		if(browserName.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}else if(browserName.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.chrome.driver", "./Drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}else {
			System.out.println("We do not support this browser");
		}
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.zoopla.co.uk");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		
	}
	
	@AfterClass
	public void teardown() {
		
		driver.quit();
		 
	}
*/
