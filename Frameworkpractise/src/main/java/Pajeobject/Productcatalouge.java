package Pajeobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Pajeobject.abstractclass.Abstractclass;

public class Productcatalouge extends Abstractclass {

	WebDriver driver;

	public Productcatalouge(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = ".mb-3")
	List<WebElement> productlist;

	@FindBy(css = ".ng-animating")
	WebElement loader;

	By prodby = By.cssSelector(".mb-3");
	By addtocart = By.cssSelector(".card-body button:last-of-type");
	By toastwait = By.cssSelector("#toast-container");

	public List<WebElement> prodlist() {
		ElementToAppear(prodby);
		return productlist;
	}

	public WebElement getproductByname(String productname) {
		WebElement prod = productlist.stream()
				.filter(s -> s.findElement(By.cssSelector("b")).getText().equals(productname)).findFirst().orElse(null);
		return prod;
	}

	public void AddToCart(String productname) {
		WebElement prod = getproductByname(productname);
		prod.findElement(addtocart).click();
		ElementToAppear(toastwait);
		ElementToDisapper(loader);
	}

}
