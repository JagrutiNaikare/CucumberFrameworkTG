package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
	public WebDriver driver;

	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	By search = By.xpath("//input[@type='search']");
	By productName = By.cssSelector("h4.product-name");
	By offerLink = By.cssSelector(".cart-header-navlink[href='#/offers']");
	By productCount = By.cssSelector("a.increment");
	By addToCart = By.xpath("//div[@class='product-action']//button");

	public void searchItem(String searchName) {
		driver.findElement(search).sendKeys(searchName);
	}

	public String getProductName() {
		return driver.findElement(productName).getText();
	}
	
	public void getOfferPage() {
		driver.findElement(offerLink).click();
	}

	public void incrementQuantity(int quantity) {
		int i = 1;
		while(i < quantity) {
			clickProductCount(); 
			i++;
		}
	}
	public void clickProductCount() {
		driver.findElement(productCount).click();
	}
	
	public void clickAddToCard() {
		driver.findElement(addToCart).click();
	}


}
