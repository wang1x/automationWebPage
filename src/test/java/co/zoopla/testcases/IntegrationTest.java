
package co.zoopla.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameters;

import co.zoopla.pages.IndexPage;
import co.zoopla.pages.PropertyInCities;
import co.zoopla.utility.BrowserFactory;

public class IntegrationTest extends BaseClass{
	 //private static IndexPage indexPage;
	// private static PropertyInCities propertyInCities;
	 
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
	
	 //Type "London" in search box
	 @Test(priority=2)
	 public void startSearch() {
		IndexPage indexPage= PageFactory.initElements(driver, IndexPage.class);
		 indexPage.acceptCookie();	
		 indexPage.inputSearchCity("London");
		 
		 indexPage.selectMinPrice(1);
		// indexPage.selectMaxPrice(4);
		// indexPage.selectPropertyType(2);
		// indexPage.selectBedroomN(1);
		 indexPage.clickSearchbutton();
		 
	 }
	 
     @Test(priority=3)
	 public void londonPropertiesListPrices() {
    	 PropertyInCities propertyInCities = PageFactory.initElements(driver, PropertyInCities.class);
	 		 propertyInCities.ascendingPropertiesPrices(propertyInCities.priceWithoutDollarSign(propertyInCities.listPricesofProperties()));
	 		 
	 	 }
	 
}
