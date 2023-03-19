package Pajeobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Pajeobject.abstractclass.Abstractclass;

public class ItemsinCartPage extends Abstractclass {

	WebDriver driver;

	public ItemsinCartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = ".cartSection h3")
	List<WebElement> itemlist;

	@FindBy(css = ".totalRow button")
	WebElement checkoutbtn;
	
	
	public Boolean CartItems(String productname) {

		Boolean match = itemlist.stream().anyMatch(s -> s.getText().equalsIgnoreCase(productname));
		return match;
	}

	public PlaceOrderPage checckoutbutton() {
		checkoutbtn.click();
		PlaceOrderPage placeorderpage = new PlaceOrderPage(driver);
		return placeorderpage;
		
		
	}

}
