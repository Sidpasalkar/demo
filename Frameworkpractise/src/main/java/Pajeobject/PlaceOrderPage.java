package Pajeobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Pajeobject.abstractclass.Abstractclass;

public class PlaceOrderPage extends Abstractclass {

	WebDriver driver;

	public PlaceOrderPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	
     @FindBy(css=".form-group input")
     WebElement countrytextarea;
     
     @FindBy(css=".ng-star-inserted:nth-child(3)")
     WebElement selectcountry;
     
     @FindBy(css=".action__submit")
     WebElement placeorderbtn;
     
     
     
     public void countrytextarea(String countryname) throws InterruptedException {
    	 Thread.sleep(5000);
    	 
    	 countrytextarea.sendKeys(countryname);
     }
    
     public void selectcountry() throws InterruptedException {
    	 Thread.sleep(5000);
    	 selectcountry.click();
     }
     
     public Thankyoupage placeorderbtn() throws InterruptedException {
    	 JavascriptExecutor js = (JavascriptExecutor) driver;
         js.executeScript("javascript:window.scrollBy(1078, 650)"); 
         
         Actions act = new Actions(driver);
         act.moveToElement(placeorderbtn);
         placeorderbtn.click();
    	 Thankyoupage ty = new Thankyoupage (driver);
    	 return ty;
    	 
    	 
		 
    	 
     }
     
}
