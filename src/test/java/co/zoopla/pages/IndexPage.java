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
	WebElement dropdownList;

	public Select getSelectOptions() {
	  return new Select(dropdownList);
	}
	//@FindBy(id = "forsale_price_min")
	//WebElement minPrice;
	//Select lessPrice = new Select(minPrice);
	//@FindBy(id = "forsale_price_max")
	//WebElement maxPrice;
	//Select morePrice = new Select(maxPrice);
	//@FindBy(id = "property_type")
	//WebElement propertyType;
	//Select pType = new Select(propertyType);
	//@FindBy(id = "beds_min")
	//WebElement bedroom;
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

	
	public void selectMinPrice(int i) {
		List<WebElement> minOPtions = getSelectOptions().getOptions();
		if (i >= 0 && i < minOPtions.size()) {

			getSelectOptions().selectByIndex(i);
		}
	}

/*
	public void selectMaxPrice(int i) {
		List<WebElement> maxOPtions = morePrice.getOptions();
		if (i >= 0 && i < maxOPtions.size()) {

			morePrice.selectByIndex(i);
		}
	}

	public void selectPropertyType(int i) {
		List<WebElement> pOptions = pType.getOptions();
		if (i >= 0 && i < pOptions.size()) {

			pType.selectByIndex(i);
		}
	}

	public void selectBedroomN(int i) {
		List<WebElement> bOPtions = nBedroom.getOptions();
		if (i >= 0 && i < bOPtions.size()) {

			nBedroom.selectByIndex(i);
		}
	}
	*/
	public String getReminderMessage() {
		return reminderMessage.getText();
	}

}