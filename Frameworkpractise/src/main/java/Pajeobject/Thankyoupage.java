package Pajeobject;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Pajeobject.abstractclass.Abstractclass;

public class Thankyoupage extends Abstractclass {

	WebDriver driver;

	public Thankyoupage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
   @FindBy(css=".hero-primary")
   WebElement msg;
   
   public String thankyoumsg() {
	  
	 return msg.getText();
	   
	   
   }


}
   
   
   
  
	

