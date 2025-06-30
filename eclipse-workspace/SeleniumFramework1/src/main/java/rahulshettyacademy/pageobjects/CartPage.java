package rahulshettyacademy.pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulshettyacademy.Abstractcomponents.AbstractComponents;

public class CartPage extends AbstractComponents {
	
	
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this );
	}

	WebDriver driver;
	
	@FindBy(css=".totalRow button")
	WebElement checkoutele;
	
	@FindBy(css=".cartSection h3")
	List<WebElement> cartProducts;
	  
    public Boolean verifyProductDisplay(String productName) {
    	Boolean match =  cartProducts.stream().anyMatch(cartitem->cartitem.getText().equalsIgnoreCase(productName));
        return match;
    }
	
    
    public CheckOutPage goToCheckout() {
    	checkoutele.click();	
    	return new CheckOutPage(driver);
    }
	
	

}
