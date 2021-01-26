package co.zoopla.pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class IndexPage {

	WebDriver driver;

	public IndexPage(WebDriver ldriver) {

		this.driver = ldriver;
		PageFactory.initElements(ldriver, this);
		
	}

	@FindBy(xpath = "//div[@class='ui-cookie-consent-choose__buttons']/button[2]")
	WebElement acceptCookieButton;
	@FindBy(id = "search-input-location")
	WebElement searchInput;
	@FindBy(id = "search-submit")
	WebElement searchButton;
	//@FindBy(xpath = "//span[@class='ui-form__select-wrap']/select")
	//WebElement minPrice;
	//Select lessPrice = new Select(minPrice);
	@FindBy(id = "forsale_price_min")
	WebElement minPrice;

	//public Select getSelectOptions() {
	//  return new Select(dropdownList);
	//}
	
	public Select getSelectOptions(WebElement we) {
		  return new Select(we);
		}
	//@FindBy(id = "forsale_price_min")
	//WebElement minPrice;
	//Select lessPrice = new Select(minPrice);
	@FindBy(id = "forsale_price_max")
	WebElement maxPrice;
	//Select morePrice = new Select(maxPrice);
	@FindBy(id = "property_type")
	WebElement propertyType;
	//Select pType = new Select(propertyType);
	@FindBy(id = "beds_min")
	WebElement bedroom;
	//Select nBedroom = new Select(bedroom);
	@FindBy(xpath = "//span[@class=\"search-input-location-placeholder\"]")
	WebElement reminderMessage;

	public void acceptCookie() {

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {

		}


		acceptCookieButton.click();
	}

	public void inputSearchCity(String searchCity) {

		try {

			Thread.sleep(5000);
		} catch (InterruptedException e) {

		}

		searchInput.sendKeys(searchCity);

	}
	
	public void clickSearchbutton() {
		
		searchButton.click();
	}

	
	public String selectPrice(int i) {
		List<WebElement> minOptions = getSelectOptions(minPrice).getOptions();
		if (i >= 0 && i < minOptions.size()) {
			
			getSelectOptions(minPrice).selectByIndex(i);
			
			 return minOptions.get(i).getText();
		}
		return null;
		
		
	}


	public String selectMaxPrice(int i) {
		List<WebElement> maxOptions = getSelectOptions(maxPrice).getOptions();
		if (i >= 0 && i < maxOptions.size()) {

			getSelectOptions(maxPrice).selectByIndex(i);
			
			return maxOptions.get(i).getText();
		}
		return null;
	}

	public String selectPropertyType(int i) {
		List<WebElement> propertyTypeOptions = getSelectOptions(propertyType).getOptions();
		if (i >= 0 && i < propertyTypeOptions.size()) {

			getSelectOptions(propertyType).selectByIndex(i);
			
			return propertyTypeOptions.get(i).getText();
		}
		return null;
	}

	public String selectBedroomN(int i) {
		List<WebElement> bedroomOptions = getSelectOptions(bedroom).getOptions();
		if (i >= 0 && i < bedroomOptions.size()) {

			getSelectOptions(bedroom).selectByIndex(i);
			
			return bedroomOptions.get(i).getText();
		}
		return null;
	}
	
	public String getReminderMessage() {
		return reminderMessage.getText();
	}

}