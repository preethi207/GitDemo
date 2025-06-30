package rahulshettyacademy.pageobjects;

import java.util.Collection;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage {
	
	 WebDriver driver;
	 
	 @FindBy (css=".totalRow button")
	 WebElement checkoutEle;
	 
	 @FindBy (css="tr td:nth-child(3)")
	 private List<WebElement> productNames;
	 
	  public OrderPage(WebDriver driver) {
		super();
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	public Boolean verifyOrderDisplay(String productName) {
		Boolean match = productNames.stream().anyMatch(cartitem->cartitem.getText().equalsIgnoreCase(productName));
	    return match;
	}
}
