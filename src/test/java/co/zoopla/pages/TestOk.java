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

	    
	  public static void main(String[] args) throws InterruptedException {
		  
		String text ="london<span class=\"css-vapfke e11daq930\"></span>This area only<span class=\"css-vapfke-Divider e11daq930\"></span>Any beds<span class=\"css-vapfke-Divider e11daq930\"></span>£2<span class=\"css-vapfke-Divider e11daq930\"></span>Show all";
		
		//  String delimiter ="<span class=\"css-vapfke-Divider e11daq930\"></span>";
		
		 String delimiter ="<span class=\".*?\"></span>";
		  
		  String words[] = text.split(delimiter);
		  
		  for(String w: words){
			  
			  System.out.println(w);
		  }
		  
		  
		  
		  WebDriver driver;
	        driver = new ChromeDriver();
	        System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
	        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get("https://www.zoopla.co.uk");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().deleteAllCookies();
			
			WebElement searchCity = driver.findElement(By.id("search-input-location"));
			searchCity.sendKeys("london");
			driver.findElement(By.xpath("//div[@class='ui-cookie-consent-choose__buttons']/button[2]")).click();
			WebElement minPrice= driver.findElement(By.id("forsale_price_min"));
			Select sOptions=new Select(minPrice);
			sOptions.selectByVisibleText("£10,000"); 
			WebElement searchButton = driver.findElement(By.id("search-submit"));
            searchButton.click();
	//		WebElement searchedCity=driver.findElement(By.xpath("//*[@id='__next']/div[3]/div/div/p"));
       //     WebElement searchedCity=driver.findElement(By.xpath("/html/body/div[4]/div[3]/div/div/p"));
            WebElement searchedCity=driver.findElement(By.cssSelector(".css-b2nlk9-Text.eczcs4p0"));
            
            Thread.sleep(5000);
           // String city = searchedCity.toString();
			String city1 = searchedCity.getAttribute("innerHTML");
			System.out.println(city1);
			System.out.println("ggggg");
			//*[@id="__next"]/div[3]/div/div/p/text()[1]
			driver.quit();
	}
}
