package excel.datadriven;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class exceldatadriven {

	DataFormatter formatter = new DataFormatter();

	@Test(dataProvider = "getdata")
	public void login(String username, String password) {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Siddesh\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://dashboard.devpaydocker.cloud/");
		System.out.println(username + password);

	}

	@DataProvider
	public Object[][] getdata() throws IOException {

		FileInputStream fis = new FileInputStream("C:\\Users\\Siddesh\\Documents\\dashboardlogin.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		int rowcount = sheet.getPhysicalNumberOfRows();
		XSSFRow row = sheet.getRow(0);
		int cellcount = row.getLastCellNum();
		Object obj[][] = new Object[rowcount - 1][cellcount];

		for (int i = 0; i < rowcount - 1; i++) {
			row = sheet.getRow(i + 1);
			for (int j = 0; j < cellcount - 1; j++) {

				XSSFCell cell = row.getCell(j);
				obj[i][j] = formatter.formatCellValue(cell);

			}

		}

		return obj;

	}

}
