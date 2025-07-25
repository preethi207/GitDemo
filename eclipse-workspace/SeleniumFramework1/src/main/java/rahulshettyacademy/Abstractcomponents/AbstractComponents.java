package rahulshettyacademy.Abstractcomponents;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.OrderPage;
//import rahulshettyacademy.pageobjects.OrderPage;

public class AbstractComponents {
	
	 WebDriver driver = null;
	 
	 @FindBy(css="[routerlink*='cart']")
	 WebElement cartHeader;
	 
	 @FindBy(css="[routerlink*='myorders']")
	 WebElement orderHeader;
	 
	public AbstractComponents(WebDriver driver) {
	this.driver= driver;
	}

	public void waitForElementToAppear(By errorMessage) {
	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		  wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
		  
	}
	
	public void waitForWebElementToAppear(WebElement findBy) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		  wait.until(ExpectedConditions.visibilityOf(findBy));
		  
	}
	public void waitForElementToDisappear(WebElement ele) throws InterruptedException {
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOf(ele));
				  
	}
	
	
	public CartPage goToCartPage() {
		cartHeader.click();
		CartPage cartpage= new CartPage(driver);
		return cartpage;
		
	}
	
	public OrderPage gotToOrdersPage() {
		orderHeader.click();
		OrderPage orderspage = new OrderPage(driver);
		return orderspage;
		
	}

	
	 

}
