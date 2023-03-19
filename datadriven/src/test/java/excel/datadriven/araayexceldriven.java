package excel.datadriven;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class araayexceldriven {

	public ArrayList<String> getData(String testcasename) throws IOException

	{

		ArrayList<String> a = new ArrayList<String>();

		FileInputStream fis = new FileInputStream("C:\\Users\\Siddesh\\Documents\\dashboardlogin.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		int sheets = workbook.getNumberOfSheets();

		for (int i = 0; i < sheets; i++)

		{

			if (workbook.getSheetName(i).equalsIgnoreCase("Sheet1"))

			{

// Here we are validating if the first sheet name is "testdata"-> then proceed for the below operations

				XSSFSheet sheet = workbook.getSheetAt(i);

				Iterator<Row> rows = sheet.iterator();

// Sheet has number of rows

				Row firstrow = rows.next(); // Here we have iterated through the first row only

				Iterator<Cell> ce = firstrow.cellIterator();

				int k = 0;

				int column = 0;

				while (ce.hasNext())

				{

					Cell value = ce.next();

					if (value.getStringCellValue().equalsIgnoreCase("Testcases"))

					{

// This will check if the cell of the first row have have "Testcases" in any cell

						column = k;

//This will store the column index we it found the value- "Testcases"

					}

					k++;

				}

				System.out.println(column);

// Here we are displaying the column index where it found Testcases

// Now we will iterate through all rows

				while (rows.hasNext())

				{

					Row r = rows.next();

					if (r.getCell(column).getStringCellValue().equalsIgnoreCase(testcasename))

					{

						Iterator<Cell> cv = r.cellIterator();

						while (cv.hasNext())

						{

// System.out.println(cv.next().getStringCellValue()); // Instead of printing data here we will store in the array list

//This will print all the data values of that row

//If this we pass on this data - which is not a appropriate method. So we will pass the data in a arraylist form

//a.add(cv.next().getStringCellValue());

// here we are adding the complete data to the array list

							Cell c = cv.next();

							if (c.getCellType() == CellType.STRING)

							{// c.getCellTypeEnum()==CellType.STRING

								a.add(c.getStringCellValue());

// Here we can't use .next() because when it found null value  in excel in it will throw error

							}

							else if (c.getCellType() == CellType.NUMERIC)

							{

								System.out.println(c.getNumericCellValue());

							}

							else

							{

								a.add(NumberToTextConverter.toText(c.getNumericCellValue()));

							}

						}

					}

				}

			}

		}

		return a;

	}

	public static void main(String[] args) throws IOException {

		araayexceldriven d = new araayexceldriven();

		ArrayList data = d.getData("Testcases");

//ArrayList is generic it captures string as well as integer values

		System.out.println(data.get(0));

		System.out.println(data.get(1));

		System.out.println(data.get(2));

		System.out.println(data.get(3));

		System.out.println(data.get(4));

	}

}