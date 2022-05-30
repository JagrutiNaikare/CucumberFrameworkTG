package stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import utils.TestCaseUtils;

public class LandingPageStepDefination {
	TestCaseUtils testCaseUtils;
	LandingPage landingPage;

	public LandingPageStepDefination(TestCaseUtils testCaseUtils) {
		this.testCaseUtils = testCaseUtils;
		this.landingPage = testCaseUtils.pageObjectManager.getLandingPage();
	}

	@Given("User is on GreenCart Landing pages")
	public void user_is_on_green_cart_landing_page() {
		
	}

	@When("^user searched with Shortname (.+) and extracted actual name of product$")
	public void user_searched_with_shortname_and_extracted_actual_name_of_product(String searchName)
			throws InterruptedException {
		LandingPage landingPage = testCaseUtils.pageObjectManager.getLandingPage();
		landingPage.searchItem(searchName);
		Thread.sleep(3000);
		testCaseUtils.landingPageProductName = landingPage.getProductName().split("-")[0].trim();

//		testCaseUtils.landingPageProductName = testCaseUtils.driver.findElement(By.cssSelector("h4.product-name")).getText().split("-")[0].trim();
		System.out.println("******* " + testCaseUtils.landingPageProductName);

	}
	
	@When("^Added \"([^\"]*)\" items of the selected product to cart$")
	public void added_something_items_of_the_selected_product_to_cart(String productQuantity) throws Throwable {
		landingPage.incrementQuantity(Integer.parseInt(productQuantity));
		landingPage.clickAddToCard();
	}

}
