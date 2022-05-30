package stepDefinations;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import pageObjects.CheckoutPage;
import utils.TestCaseUtils;

public class CheckoutPageStepDefination {
	TestCaseUtils testCaseUtils;
	CheckoutPage checkoutPage;

	public CheckoutPageStepDefination(TestCaseUtils testCaseUtils) {
		this.testCaseUtils = testCaseUtils;
		checkoutPage = testCaseUtils.pageObjectManager.getCheckoutPage();
	}

	@Then("^user proceeds to Checkout and Validate the (.+) items in checkout page$")
	public void user_proceeds_to_checkout_and_validate_the_items_in_checkout_page(String productName) throws Throwable {
		checkoutPage.checkOut(productName);
		String checkoutProductName = checkoutPage.getProductName().split("-")[0].trim();
		System.out.println(checkoutProductName + " :::: "+testCaseUtils.landingPageProductName);
		Assert.assertEquals(checkoutProductName, testCaseUtils.landingPageProductName);
	}

	@Then("^verify user has ability to enter promocode and place the order$")
	public void verify_user_has_ability_to_enter_promocode_and_place_the_order() throws Throwable {
		Assert.assertTrue(checkoutPage.verifyPromoBtn());
		Assert.assertTrue(checkoutPage.placeOrder());
	}
}
