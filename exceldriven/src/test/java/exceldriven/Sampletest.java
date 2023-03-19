package exceldriven;

import java.io.IOException;
import java.util.ArrayList;

public class Sampletest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		exceldriven d = new exceldriven();
		ArrayList data=d.getdata("Delete Profile");
		
		System.out.println(data.get(0));
		System.out.println(data.get(1));
		System.out.println(data.get(2));
		System.out.println(data.get(3));
		
		
		

	}

}
