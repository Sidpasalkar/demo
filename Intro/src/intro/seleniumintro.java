package intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class seleniumintro {

	public static void main(String[] args) throws Exception {
		//Invoking Browser
		System.setProperty("webdriver.crome.driver", "C:\\Users\\Siddesh\\Downloads.chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://pdadmin.devpaydocker.cloud/login");
		driver.manage().window().maximize();
		//System.out.println(driver.getTitle());
		//System.out.println(driver.getCurrentUrl());
		Thread.sleep(5000);
		System.out.println(driver.findElement(By.xpath("//span[contains(text(),'Sign in to your PayDocker operator account')]")).getText());
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("siddhesh.pasalkar@bakuun.com");
		driver.findElement(By.cssSelector("input[id='password']")).sendKeys("Siddhesh@1998");
		//driver.findElement(By.xpath("//span[contains(text(),'Continue')]")).click();
		//driver.findElement(By.xpath("//*[name()='path' and contains(@d,'M8 11a5.69')]")).click();
		
	}

}
