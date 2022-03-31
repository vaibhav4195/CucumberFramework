package stepDefinitions;

import org.junit.Assert;

import io.cucumber.java.en.Then;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import utils.TestContextSetup;


public class OfferPageStepDefinition {
	public String offerPageproductName;
	TestContextSetup testContextSetup;
	
	public OfferPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}
	
	public void switchToOffersPage() {

		LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
		landingPage.selectTopDealsPage();
		testContextSetup.genericUtils.SwitchWindowToChild();	
	}
	
	@Then("^User searched for (.+) shortname in offers Page$")
	public void user_searched_for_shortname_in_offers_page(String shortName) throws Throwable{
		
		switchToOffersPage();
		System.out.println("Switched To Offer Page");
		OffersPage offersPage = testContextSetup.pageObjectManager.getOffersPage();
//		OffersPage offersPage = new OffersPage(testContextSetup.driver);
		offersPage.searchItem(shortName);
//		testContextSetup.driver.findElement(By.id("search-field")).sendKeys(shortName);
		Thread.sleep(3000);
		offerPageproductName = offersPage.getProductName();
	}
	
	@Then("Validate product name in offers page matches with Landing Page")
	public void validate_product_name_in_Offers_page() throws Throwable{
		System.out.println("Validating names in Offer Page and Landing Page ");
		Assert.assertEquals(offerPageproductName, testContextSetup.landingPageProductName);	
	}
}
