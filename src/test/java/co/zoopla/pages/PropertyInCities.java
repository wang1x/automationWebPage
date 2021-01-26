package co.zoopla.pages;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.codec.binary.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PropertyInCities {

	WebDriver driver;



	public PropertyInCities(WebDriver ldriver) {

		this.driver = ldriver;
		PageFactory.initElements(ldriver, this);

	}

	@FindBy(xpath="//*[@id=\"__next\"]/div[3]/div/div/p")
	WebElement searchedCity;
	@FindBy(xpath="//*[@id=\"__next\"]/div[3]/div/div/p/span")
	WebElement searchedArea;
	@FindBy(xpath="//*[@id=\"__next\"]/div[3]/div/div/p/span[2]")
	WebElement searchedBedNumber;
	@FindBy(xpath="//*[@id=\"__next\"]/div[3]/div/div/p/span[3]")
	WebElement searchedPriceRange;
	@FindBy(xpath="//*[@id=\"__next\"]/div[3]/div/div/p/span[4]")
	WebElement searchedPropertyType;




	@FindBy(css =".css-18tfumg-Text.eczcs4p0")
	List<WebElement> propertyPrices;

	public String searchedCity() {
		return searchedCity.getAttribute("innerHTML");
	}

	public String[] selectOption(String str) {
		
		String delimiterPattern ="<span class=\".*?\"></span>";
		return str.split(delimiterPattern);
		
	}
	
	
	public String searchedArea() {
		return searchedArea.getText();
	}

	public String searchedBedNumber() {
		return searchedBedNumber.getText();
	}

	public String searchedPriceR() {

		return searchedPriceRange.getText();
	}


	public String searchedPropertyT() {

		return searchedPropertyType.getText();
	}







	public List<String> listPricesofProperties() {

		List<String> lPricesofProperties = new ArrayList<String>();

		for (WebElement e : propertyPrices) {

			lPricesofProperties.add(e.getText());
		}

		System.out.println(lPricesofProperties);
		return lPricesofProperties;

	}

	/***
	 * public double numberofPrice(String price) {
	 * 
	 * Pattern p = Pattern.compile("\\£(\\d+)"); Matcher m = p.matcher(price);
	 * 
	 * if (m.find()) { return Double.parseDouble(m.group(1)); }else {
	 * 
	 * return 0; }
	 * 
	 ***/



	public void ascendingPropertiesPrices(List<Double> lPrices) {
		List<Double> pWithoutDSign = new ArrayList<Double>();
		for (int i = 0; i < lPrices.size(); i++) {
			pWithoutDSign.add(lPrices.get(i));
		}
		Collections.sort(pWithoutDSign);
		System.out.println("xxxxx" + pWithoutDSign);
	}

	public List<Double> priceWithoutDollarSign(List<String> lPricesofP) {
		List<Double> pFormat = new ArrayList<Double>();
		double numberPrice = 0.0;
		for(int i=0; i<lPricesofP.size();i++) {
			String numberPrices= lPricesofP.get(i).replaceAll("£|,","");
			numberPrice = Double.parseDouble(numberPrices);
			pFormat.add(numberPrice);
		}

		return pFormat;


	}

}
