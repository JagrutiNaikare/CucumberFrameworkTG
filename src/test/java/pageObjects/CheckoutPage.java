package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
	public WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
	}

	By checkOut = By.xpath("//button[contains(text(), 'PROCEED TO CHECKOUT')]");
	By placeOrder = By.xpath("//button[contains(text(), 'Place Order')]");
	By cart = By.cssSelector("img[alt='Cart']");
	By promoBtn = By.cssSelector(".promoBtn");
	By productName = By.xpath("//p[@class='product-name']");

	public void checkOut(String searchName) {
		driver.findElement(cart).click();
		driver.findElement(checkOut).click();
	}

	public boolean verifyPromoBtn() {
		return driver.findElement(promoBtn).isDisplayed();
	}

	public void applyPromo() {
		driver.findElement(promoBtn).click();
	}

	public boolean placeOrder() {
		return driver.findElement(placeOrder).isDisplayed();
	}
	
	public String getProductName() {
		return driver.findElement(productName).getText();
	}

}
