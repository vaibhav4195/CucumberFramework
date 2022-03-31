package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
	public WebDriver driver;
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
	}

	By cartBag = By.cssSelector("[alt='Cart']");
	By checkOutButton = By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");
	By promoButton = By.cssSelector(".promoBtn");
	By placeOrderButton = By.xpath("//button[contains(text(),'Place Order')]");
	
	public void CheckOutItems() {
		driver.findElement(cartBag).click();
		driver.findElement(checkOutButton).click();
	}
	
	public Boolean verifyPromoBtn() {
		return driver.findElement(promoButton).isDisplayed();
	}
	
	public Boolean verifyPlaceOrder() {
		return driver.findElement(placeOrderButton).isDisplayed();
	}
}
