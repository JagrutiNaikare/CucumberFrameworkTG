package stepDefinations;

import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.Then;
import pageObjects.LandingPage;
import pageObjects.OfferPage;
import utils.TestCaseUtils;

public class OfferPageStepDefination {
	String offerPageProductName;
	TestCaseUtils testCaseUtils;

	public OfferPageStepDefination(TestCaseUtils testCaseUtils) {
		this.testCaseUtils = testCaseUtils;
	}

	@Then("^user searched for (.+) shortnamae in offers page$")
	public void user_searched_for_shortnamae_in_offers_page(String nameOfProduct) throws InterruptedException {
		OfferPage offerPage = testCaseUtils.pageObjectManager.getOfferPage();
		switchToOfferPage();
		offerPage.searchItem(nameOfProduct);
		Thread.sleep(5000);
		offerPageProductName = offerPage.getProductName().trim();
		System.out.println("******* " + offerPageProductName);

	}

	public void switchToOfferPage() {
		LandingPage landingPage = testCaseUtils.pageObjectManager.getLandingPage();
		landingPage.getOfferPage();
		testCaseUtils.genericUtils.SwitchWindowChild();
	}

	@Then("validate product name in offers page matches with Landing Page")
	public void validate_product_name_in_offers_page_matches_with_landing_page() {
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(offerPageProductName, testCaseUtils.landingPageProductName);
		softAssert.assertAll();
	}
}
