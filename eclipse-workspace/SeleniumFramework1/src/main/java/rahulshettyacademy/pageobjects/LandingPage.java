package rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.Abstractcomponents.AbstractComponents;

@SuppressWarnings("unused")
public class LandingPage extends AbstractComponents {

	WebDriver driver;
	
	//this method will execute first (constructor)
	public  LandingPage(WebDriver driver) {
		//initialization
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);	
		
	}
	
	//Page Factory
	// driver.findElement(By.id("userEmail")).sendKeys("preity207@gmail.com");
	  @FindBy(id="userEmail")
	  WebElement userEmail;
	  
	  @FindBy(id="userPassword")
	  WebElement passwordele;
	 
	 @FindBy(id="login")
	 WebElement submit;
	 
	 @FindBy(css="[class*='flyInOut']")
	//div[@aria-label='Incorrect email or password.']
	 WebElement errorMessage;
	 
	 public ProductCatalogPage loginApplication(String email, String password) {
		 userEmail.sendKeys(email);
		 passwordele.sendKeys(password);
		 submit.click();
		 ProductCatalogPage productcatalogpage = new ProductCatalogPage(driver);
		 return productcatalogpage;
	 }
	 
	 
	 public void goTo() {
		driver.get("https://rahulshettyacademy.com/client/");	
		}
	 
	 public String getErrorMessage() {
		 waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
	 }
}
