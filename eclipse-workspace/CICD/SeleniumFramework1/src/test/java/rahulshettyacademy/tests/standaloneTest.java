package rahulshettyacademy.tests;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class standaloneTest {

	public static void main(String[] args) {
		
	WebDriverManager.chromedriver().setup();
	
	WebDriver driver= new ChromeDriver();
	
	driver.manage().window().maximize();
			
	//Implicitly wait
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	driver.get("https://rahulshettyacademy.com/client/");
	 
	 driver.findElement(By.id("userEmail")).sendKeys("preity207@gmail.com");
	 driver.findElement(By.id("userPassword")).sendKeys("Welcome1");
	 
	 driver.findElement(By.cssSelector("#login")).click();
	 
	 String productName = "ZARA COAT 3";
	 List<WebElement> items= driver.findElements(By.cssSelector(".mb-3"));
	 
/*	 for(WebElement product :items) {
		String b = product.getText();		
		//System.out.println(product.getText());
		if(b.contains("ZARA COAT 3")) {
			System.out.println("ZARA COAT 3");
			break;
		}*/
		
	 //Using Stream
	 WebElement i=items.stream().filter(item->
	   item.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
	  i.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
	  
	  //#ng container
	  
	  wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
	  driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		
		List<WebElement> cartitems= driver.findElements(By.cssSelector(".cartSection h3"));
		
		
		boolean b= cartitems.stream().anyMatch(cartitem->cartitem.getText().equalsIgnoreCase(productName));
	    Assert.assertTrue(b); 
	
	    driver.findElement(By.cssSelector(".totalRow button")).click();
	    
	    Actions a = new Actions(driver);
	    a.sendKeys(driver.findElement(By.cssSelector("input[placeholder='Select Country']")), "India").build().perform();
	
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
	    
	    driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)"));
	    driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
	    
	    driver.findElement(By.cssSelector(".action__submit")).click();
	    
	    String confmsg= driver.findElement(By.cssSelector(".hero-primary")).getText();
	    
	    Assert.assertTrue(confmsg.equalsIgnoreCase("Thankyou for the order."));
	    
	    System.out.println(confmsg);
	    //Assert.assertEquals(confmsg, "Thankyou for the order.");
	    
	    driver.close();
	    
	}
	

	}


