package co.zoopla.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;

import junit.framework.Assert;

public class TestOk {

	    
	  public static void main(String[] args) {
		  WebDriver driver;
	        driver = new ChromeDriver();
	        System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
	        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get("https://www.zoopla.co.uk");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().deleteAllCookies();
			driver.findElement(By.xpath("//div[@class='ui-cookie-consent-choose__buttons']/button[2]")).click();
			WebElement minPrice= driver.findElement(By.id("forsale_price_min"));
			Select sOptions=new Select(minPrice);
			sOptions.selectByVisibleText("£10,000"); 

			System.out.println("aaaaa");
			driver.close();
	}
}
