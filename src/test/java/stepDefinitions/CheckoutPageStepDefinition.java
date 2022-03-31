package stepDefinitions;


import org.junit.Assert;

import io.cucumber.java.en.Then;
import pageObjects.CheckoutPage;
import utils.TestContextSetup;


public class CheckoutPageStepDefinition {

	TestContextSetup testContextSetup;
	public CheckoutPage checkoutPage;
	
	public CheckoutPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.checkoutPage = testContextSetup.pageObjectManager.getCheckoutPage();
	}
	
	@Then("^User proceeds to checkout and validate the (.+) items in checkout page$")
	public void user_proceeds_to_checkout_and_validate_the_items_in_checkout_page(String name) throws Exception {
		checkoutPage.CheckOutItems();
		Thread.sleep(3000);
	}
	
	@Then("Verify user has ability to enter promo code and place the order")
	public void verify_user_has_ability_to_enter_promo_code_and_place_the_order() {
		
		Assert.assertTrue(checkoutPage.verifyPromoBtn());
		Assert.assertTrue(checkoutPage.verifyPlaceOrder());
	}

	
}
