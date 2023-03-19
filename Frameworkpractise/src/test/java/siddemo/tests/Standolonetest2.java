package siddemo.tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pajeobject.ItemsinCartPage;
import Pajeobject.LandingPage;
import Pajeobject.PlaceOrderPage;
import Pajeobject.Productcatalouge;
import Pajeobject.Thankyoupage;
import Pajeobject.abstractclass.Abstractclass;
import io.github.bonigarcia.wdm.WebDriverManager;
import siddemo.testcomponents.BasePage;

public class Standolonetest2 extends BasePage {
	
	String productname = "ADIDAS ORIGINAL";
	
   @Test(dataProvider="getdata")
	public void SubmitOrder(HashMap <String,String> input) throws Exception
	{
		
		Productcatalouge pdc=LandingPage.LoginPage(input.get("useremail"), input.get("userpassword"));
		List<WebElement> productlist = pdc.prodlist();
		pdc.AddToCart(productname);
		ItemsinCartPage Itemsincartpage = pdc.gotocartpage();
		Boolean match = Itemsincartpage.CartItems(productname);
		Assert.assertTrue(match);
		PlaceOrderPage placeorderpage =Itemsincartpage.checckoutbutton();
		placeorderpage.countrytextarea("ind");
		placeorderpage.selectcountry();
		Thankyoupage ty = placeorderpage.placeorderbtn();
		String msg=ty.thankyoumsg();
		Assert.assertEquals(msg, "THANKYOU FOR THE ORDER.");
	    }
   
   
   @DataProvider
   public Object[][] getdata() throws IOException {
	   
	  List<HashMap<String,String>> data= convertdata(System.getProperty("user.dir")+"//src//test//java//siddemo//data//purchaseorder.json");
	   return new Object[][]  {{data.get(0)}};
	   
	   
	   
   }
   
   
  /* @DataProvider
   
   public  Object[][] getData() {
	   
	   return new Object [] []  {{"sid@gmail.com" , "Siddhesh@1998","ADIDAS ORIGINAL" }, {"sid@gmail.com" , "Siddhesh@1998", "IPHONE 13 PRO"}};
	   */
   
 /* @DataProvider
   public Object[][] getdata() {
	   
	   HashMap <String,String> map = new HashMap<String,String>();
	   map.put("useremail", "sid@gmail.com");
	   map.put("userpassword", "Siddhesh@1998");
	   map.put("productname", "ADIDAS ORIGINAL");
	   
	   HashMap <String,String>map1 = new HashMap<String,String>();
	   map1.put("useremail", "sid@gmail.com");
	   map1.put("userpassword", "Siddhesh@1998");
	   map1.put("productname", "IPHONE 13 PRO");
	   
	   return new Object [] []  {{map},{map1}};
	   
	   
   }
   
*/
   
   
   
}
