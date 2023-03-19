package intro;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Practisewait {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.crome.driver", "C:\\Users\\Siddesh\\Downloads.chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("Siddhesh");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("learning");
		driver.findElement(By.xpath("(//span[@class='checkmark'])[2]")).click();
		driver.findElement(By.xpath("//button[@id='okayBtn']")).click();
		Select drpdwn = new Select(null);
		
	
	}

}
