package rahulshettyacademy.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckOutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.ProductCatalogPage;

public class ErrorValidationsTest extends BaseTest{

	@Test(groups= {"ErrorHandling"} ,retryAnalyzer=rahulshettyacademy.TestComponents.Retry.class)
	public void LoginErrorValidations() throws InterruptedException, IOException {
	landingPage.loginApplication("preity207@gmail.com", "Wel1");//giving wrong pwd
    Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());    
	}
	
	@Test
	public void ProductsErrorValidations() throws InterruptedException {
		String productName = "ZARA COAT 3";
		ProductCatalogPage productcatalogPage= landingPage.loginApplication("preity207@gmail.com", "Welcome1");
		List<WebElement> products = productcatalogPage.getProductList();
		productcatalogPage.addProductToCart(productName);
		CartPage cartPage = productcatalogPage.goToCartPage(); 
		Boolean match = cartPage.verifyProductDisplay("ZARA COAT 33");
		Assert.assertFalse(match);
	}
	
	
	
	}


