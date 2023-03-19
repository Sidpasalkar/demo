package intro;

public class Brushjava3 {

	public class CoreJavaBrushUp3 {

		public  void main(String[] args) {

// TODO Auto-generated method stub

//string is an object //String literal

// String s1 = "Rahul Shetty Academy";

			String s5 = "hello";

//new

			String s2 = new String("Welcome");

			String s3 = new String("Welcome");

			String s = "Rahul Shetty Academy";

			String[] splittedString = s.split("Shetty");

			System.out.println(splittedString[0]);

			System.out.println(splittedString[1]);

			System.out.println(splittedString[1].trim());

			for (int i = s.length() - 1; i >= 0; i--)

			{

				System.out.println(s.charAt(i));

			}

		}

	}

//************************************Methods Code *****************************************

	public class MethodsDemo {

		public  void main(String[] args) {

// TODO Auto-generated method stub

			MethodsDemo d = new MethodsDemo();

			String name = d.getData();

			System.out.println(name);

			MethodsDemo2 d1 = new MethodsDemo2();

			d1.getData2();

		}
		public  class MethodsDemo2{
			
			public String getData2()

			{

				System.out.println("hello world");

				return "rahul shetty";

			}
		}

		public String getData()

		{

			System.out.println("hello world");

			return "rahul shetty";

		}

		

	}

}
