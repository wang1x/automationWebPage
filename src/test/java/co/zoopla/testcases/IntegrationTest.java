
package co.zoopla.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import co.zoopla.pages.IndexPage;
import co.zoopla.pages.PropertyInCities;
import co.zoopla.utility.BrowserFactory;

public class IntegrationTest extends BaseClass{
	//private static IndexPage indexPage;
	// private static PropertyInCities propertyInCities;
	IndexPage indexPage;
	PropertyInCities propertyInCities;
	
	public IntegrationTest() {
		super();
		
	}
	
	@BeforeTest
	@Parameters("browser")

	public void setup(String browser) throws Exception {

		if (browser.equalsIgnoreCase("firefox")) {
			driver = firefox();

		}
		// Check if parameter passed as 'chrome'
		else if (browser.equalsIgnoreCase("chrome")) {
			driver = chrome();
		}
		// Check if parameter passed as 'Edge'
		else if (browser.equalsIgnoreCase("IE")) {
			driver = IE();
		} else {
			// If no browser passed throw exception
			throw new Exception("Browser is not correct");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("https://www.zoopla.co.uk");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		indexPage = new IndexPage(driver);
	    propertyInCities = new PropertyInCities(driver);
		

	}

	//Type nothing in search box
	/**
	 @Test(priority=1)
	 public void startSearchWithoutType() {
		 indexPage = new IndexPage(this.driver);
		 indexPage.acceptCookie();	
		 indexPage.inputSearchCity("");
		 AssertJUnit.assertEquals("Please enter a location",indexPage.getReminderMessage());

	 }
	 **/
	//	IndexPage indexPage= PageFactory.initElements(driver, IndexPage.class);
	//	PropertyInCities propertyInCities = PageFactory.initElements(dr8iver, PropertyInCities.class);
	
	//Type "London" in search box
	
	@Test(priority=2)
	public void startSearch() {
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		indexPage.acceptCookie();	
		indexPage.inputSearchCity("London");

		indexPage.selectPrice(1);
		indexPage.selectMaxPrice(4);
		indexPage.selectPropertyType(2);
		indexPage.selectBedroomN(1);
		indexPage.clickSearchbutton();
		
		String[] selectSearchRules=propertyInCities.selectOption(propertyInCities.searchedCity());

		AssertJUnit.assertEquals("London",selectSearchRules[0]);
		AssertJUnit.assertEquals(indexPage.selectPropertyType(2),selectSearchRules[4]);
		AssertJUnit.assertEquals(indexPage.selectBedroomN(1),selectSearchRules[2]);


	}

	@Test(priority=3)
	public void londonPropertiesListPrices() {

		propertyInCities.ascendingPropertiesPrices(propertyInCities.priceWithoutDollarSign(propertyInCities.listPricesofProperties()));

	}
	
	@AfterClass
	public void teardown() {
		
		driver.quit();
		 
	}

}
