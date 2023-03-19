package siddemo.tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Standolonetest {

	public static void main(String[] args) throws InterruptedException {
		
        String productname= "ADIDAS ORIGINAL";
        
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
 		driver.get("https://rahulshettyacademy.com/client/");
		driver.findElement(By.id("userEmail")).sendKeys("sid@gmail.com");
	    driver.findElement(By.id("userPassword")).sendKeys("Siddhesh@1998");
		driver.findElement(By.id("login")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(8));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		
		List<WebElement> productlist =driver.findElements(By.cssSelector(".mb-3"));
		
		WebElement prod =productlist.stream().filter(s->
		s.findElement(By.cssSelector("b")).getText().equals(productname)).findFirst().orElse(null);
		
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		//Thread.sleep(5000);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
		
		driver.findElement(By.cssSelector("[routerlink*=\"cart\"]")).click();
		
		List<WebElement> itemlist =driver.findElements(By.cssSelector(".cartSection h3"));
		Boolean match = itemlist.stream().anyMatch(s->
		s.getText().equalsIgnoreCase(productname));
		Assert.assertTrue(match);
		driver.findElement(By.cssSelector(".totalRow button")).click();
		Thread.sleep(5000);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		
		driver.findElement(By.cssSelector(".form-group input")).sendKeys("Ind");
		driver.findElement(By.cssSelector(".ta-results button:nth-child(3)")).click();
		
		//Thread.sleep(8000);
		driver.findElement(By.cssSelector(".action__submit")).click();
		
		String msg=driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertEquals(msg, "THANKYOdsfdfU FOR THE ORDER.");
		
	}

}
