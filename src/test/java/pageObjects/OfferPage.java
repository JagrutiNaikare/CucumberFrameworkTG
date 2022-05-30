package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OfferPage {
	public WebDriver driver;

	public OfferPage(WebDriver driver) {
		this.driver = driver;
	}

	By search = By.xpath("//input[@id='search-field']");
	By productName = By.cssSelector("tr td:nth-child(1)");

	public void searchItem(String searchName) {
		driver.findElement(search).sendKeys(searchName);
	}

	public String getProductName() {
		return driver.findElement(productName).getText();
	}

}
