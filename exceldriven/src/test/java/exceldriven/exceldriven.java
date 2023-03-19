package exceldriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.formula.functions.Rows;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;




public class exceldriven {

	public ArrayList<String> getdata(String testcasename) throws IOException {
		
		ArrayList<String> a = new ArrayList<String>();

		FileInputStream fis = new FileInputStream("C://Users//Siddesh//Documents//Demodata.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		int sheets = wb.getNumberOfSheets();
		for (int i = 0; i < sheets; i++) {

			if (wb.getSheetName(i).equalsIgnoreCase("test")) {
				XSSFSheet sheet = wb.getSheetAt(i);

				Iterator<Row> rows = sheet.iterator();
				Row firstrow = rows.next();

				Iterator<Cell> cell = firstrow.cellIterator();
				int k = 0;
				int column = 0;
				while (cell.hasNext()) {

					Cell value = cell.next();
					if (value.getStringCellValue().equalsIgnoreCase("Test Cases")) {

						column = k;

					}
					k++;

				}
				System.out.println(column);

				while (rows.hasNext())
				{
					Row r = rows.next();
					if (r.getCell(column).getStringCellValue().equalsIgnoreCase(testcasename)) {

						Iterator<Cell> cv = r.cellIterator();
						while (cv.hasNext())
						{
							
							Cell c=cv.next();
							if(c.getCellTypeEnum()==CellType.STRING) {
								
								a.add(c.getStringCellValue());
							}
							 
							else {
								
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
		// file input stream argument
		
		
}
}