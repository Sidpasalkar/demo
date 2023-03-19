package Pajeobject.abstractclass;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pajeobject.ItemsinCartPage;
import Pajeobject.Productcatalouge;

public class Abstractclass {
	
    WebDriver driver;
	public Abstractclass(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//button[@routerlink='/dashboard/cart']")
	WebElement Cartbtn;

	
	
	public void ElementToAppear(By findBy) {	
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(8));
	wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void ElementToDisapper(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(8));
	  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
	}
	
	
	public ItemsinCartPage gotocartpage()
	{
		Cartbtn.click();
		ItemsinCartPage Itemsincartpage = new ItemsinCartPage(driver);
		return Itemsincartpage;
	}
	
	
}



