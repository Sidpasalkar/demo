package siddemo.testcomponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Pajeobject.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage<lp> {

	public WebDriver driver;
	public LandingPage LandingPage;

	public WebDriver initialiazedriver() throws IOException {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "//src//main//java//siddemo//resources//GlobalFile.properties");
		prop.load(fis);

		String browsername = System.getProperty("browser") != null ? System.getProperty("browser")
				: prop.getProperty("browser");
		// String browsername = prop.getProperty("browser");

		if (browsername.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		}

		else if (browsername.equalsIgnoreCase("firefox")) {

			System.setProperty("Webdriver.gecko.driver", "C:\\Users\\Siddesh\\Downloads\\geckodriver");
			driver = new FirefoxDriver();
		}

		else if (browsername.equalsIgnoreCase("edge")) {

		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}

	public List<HashMap<String, String>> convertdata(String filePath) throws IOException {
		// read json to string
		String jsonContent = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);

		// convert string to Hashmap-->Jackson DataBind(Repository)

		ObjectMapper ObjectMapper = new ObjectMapper();
		List<HashMap<String, String>> data = ObjectMapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return data;
	}

	public String getss(String testCaseName, WebDriver driver) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";

	}

	@BeforeMethod
	public LandingPage Launchpage() throws Exception {

		driver = initialiazedriver();
		LandingPage = new LandingPage(driver);
		LandingPage.goTo();
		return LandingPage;
	}

	@AfterMethod
	public void teardown() {
		driver.close();
	}

}
