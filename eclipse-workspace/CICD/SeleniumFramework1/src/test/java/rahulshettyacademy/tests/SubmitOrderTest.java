package rahulshettyacademy.tests;



import static org.testng.Assert.assertTrue;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckOutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.OrderPage;
import rahulshettyacademy.pageobjects.ProductCatalogPage;

public class SubmitOrderTest extends BaseTest {

	String productName = "ZARA COAT 3";

	@Test(dataProvider="getData",groups= "Purchase")
	public void submitOrder(HashMap<String, String> input) throws InterruptedException, IOException {
		ProductCatalogPage productcatalogPage = landingPage.loginApplication(input.get("email"), input.get("password"));
		List<WebElement> products = productcatalogPage.getProductList();
		productcatalogPage.addProductToCart(input.get("product"));
		CartPage cartPage = productcatalogPage.goToCartPage();
		
		Boolean match = cartPage.verifyProductDisplay(input.get("product"));
		Assert.assertTrue(match);
		CheckOutPage checkoutpage = cartPage.goToCheckout();
		checkoutpage.selectCountry("India");
		//checkoutpage.submitOrder();
		ConfirmationPage confirmationpage = checkoutpage.submitOrder();
		String confirmMessage = confirmationpage.getConfMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("Thankyou for the order."));
	}

	@Test(dependsOnMethods = { "submitOrder" })
	public void orderHistoryTest() {
		ProductCatalogPage productcatalogPage = landingPage.loginApplication("preity207@gmail.com", "Welcome1");
		OrderPage ordersPage = productcatalogPage.gotToOrdersPage();
		Assert.assertTrue(ordersPage.verifyOrderDisplay(productName));
	}

	
	  public String getScreenshot(String testCaseName) throws IOException{
	  TakesScreenshot ts = (TakesScreenshot)driver; File source=
	  ts.getScreenshotAs(OutputType.FILE); File file= new
	  File(System.getProperty("user.dir")+"//reports//"+testCaseName +".png");
	  FileUtils.copyFile(source,file); return testCaseName; }
	 
	// ExtentReports

	@DataProvider
	public Object[][] getData() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//rahulshettyacademy//data//PurchaseOrder.json");
		return new Object[][] { { data.get(0) }, { data.get(1) } };

	}

	/*
	 * HashMap<String,String> map = new HashMap<String,String>();
	 * 
	 * map.put("email", "preity207@gmail.com"); map.put("password", "Welcome1");
	 * map.put("product", "ZARA COAT 3");
	 * 
	 * HashMap<String,String> map1 = new HashMap<String,String>(); map1.put("email",
	 * "arnav22@gmail.com"); map1.put("password", "Apples@1"); map1.put("product",
	 * "ADIDAS ORIGINAL");
	 */
}
