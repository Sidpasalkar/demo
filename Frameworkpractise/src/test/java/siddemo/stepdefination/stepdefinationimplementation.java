package siddemo.stepdefination;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Pajeobject.ItemsinCartPage;
import Pajeobject.PlaceOrderPage;
import Pajeobject.Productcatalouge;
import Pajeobject.Thankyoupage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import siddemo.testcomponents.BasePage;

public class stepdefinationimplementation extends BasePage {

	public Pajeobject.LandingPage landingpage;
	public Productcatalouge pdc;
	public Thankyoupage ty;

	@Given("Landing on Ecommerce page.")
	public void Landing_on_Ecommerce_page() throws Exception {

		landingpage = Launchpage();
	}

	@Given("^Username (.+) and password (.+)$")
	public void Username_and_password(String username, String password) {
		pdc = LandingPage.LoginPage(username, password);

	}

	@When("^Adding a product (.+)$")
	public void Adding_a_product(String productname) {

		List<WebElement> productlist = pdc.prodlist();
		pdc.AddToCart(productname);

	}

	@And("^Checkout (.+) and submit the order$")
	public void Checkout_and_submit_the_order(String productname) throws InterruptedException {
		ItemsinCartPage Itemsincartpage = pdc.gotocartpage();
		Boolean match = Itemsincartpage.CartItems(productname);
		Assert.assertTrue(match);
		PlaceOrderPage placeorderpage = Itemsincartpage.checckoutbutton();
		placeorderpage.countrytextarea("ind");
		placeorderpage.selectcountry();
		ty = placeorderpage.placeorderbtn();
	}

	@Then("{string} message is displayed or not")
	public void message_is_displayed_or_not(String string) {

		String msg = ty.thankyoumsg();
		Assert.assertTrue(msg.equalsIgnoreCase(string));
		driver.close();

	}

}
