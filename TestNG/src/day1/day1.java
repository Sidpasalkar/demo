package day1;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class day1 {

	@Test
	public void demo1() {
    System.out.println("hello");
	}

	@Test
	public void demo2() {
		System.out.println("hi");
	}
   
		@BeforeTest
		public void day3() {
			System.out.println("first");
			
		}
		
		@AfterTest
		public void day9()
		{
			System.out.println("last");
		}
	}

