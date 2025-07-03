package rahulshettyacademy.stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckOutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.ProductCatalogPage;

public class StepDefinitionImpl extends BaseTest{

	public LandingPage landingpage;
	public ProductCatalogPage productcatalogPage;
	public ConfirmationPage confirmationPage;
	  
	 @Given("I landed on Ecommerce page")
	 public void I_landed_on_Ecommerce_page() throws IOException {
		 landingpage= launchApplication();
			/* driver.get("https://rahulshettyacademy.com/client/"); */
	 }
	 
	 @Given("^I logged in with username (.+) and password (.+)$")
     public void I_logged_in_with_username_and_password (String username,String password) {
		  productcatalogPage = landingPage.loginApplication(username,password);			
	 }
	
	 @When("I add product (.+) in cart$")
	 public void I_add_product_productName_in_cart(String productName) throws InterruptedException {
		 List<WebElement> products = productcatalogPage.getProductList();
			productcatalogPage.addProductToCart(productName);
	 }
	 
	 @When("^checkout (.+) and submit the order$")//if data is coming from examples section we use ^ starts and end with $
	 public void  checkout_productName_and_submit_the_order(String productName) {
		    CartPage cartPage = productcatalogPage.goToCartPage();
			
			Boolean match = cartPage.verifyProductDisplay(productName);
			Assert.assertTrue(match);
			CheckOutPage checkoutpage = cartPage.goToCheckout();
			checkoutpage.selectCountry("India");
		    confirmationPage = checkoutpage.submitOrder();	
	 }
	 
	 @Then("{string} message is displayed on confirmationpage")//if its coming from static message then use curly braces
	 public void message_is_displayed_on_confirmationpage(String string) {	
			String confirmMessage = confirmationPage.getConfMessage();
			  Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));	
			  driver.close();
	 }
	 
	 @Then("{string} message is dislayed")
	 public void  message_is_dislayed(String msg) {
		 Assert.assertEquals(msg, landingPage.getErrorMessage());  
		 driver.close();
	 }
}
