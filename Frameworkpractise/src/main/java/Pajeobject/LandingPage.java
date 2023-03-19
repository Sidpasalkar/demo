package Pajeobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Pajeobject.abstractclass.Abstractclass;

public class LandingPage extends Abstractclass {

	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "userEmail")
	WebElement useremail;

	@FindBy(id = "userPassword")
	WebElement userpassword;

	@FindBy(id = "login")
	WebElement loginbtn;

	public Productcatalouge LoginPage(String email, String password) {

		useremail.sendKeys(email);
		userpassword.sendKeys(password);
		loginbtn.click();
		Productcatalouge pdc = new Productcatalouge(driver);
		return pdc;
	}

	public void goTo() {

		driver.get("https://rahulshettyacademy.com/client/");

	}

}
