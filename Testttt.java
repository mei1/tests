package test;

import org.junit.Test;

public class Testttt extends Tets {
	
	public void add (String a, String b) {
		System.out.println("add string - " + a + "," + b);
	}
	
	public void add (int a, int b) {
		System.out.println("add int - " + (a - b));
	}
	
	public void add (int a, String b) {
		System.out.println("add string - " + a + "," + b);
	}
	
	@Test
	public void test() {
		super.add("1", "2");
		add("1", "2");
		super.add(1, 2);
		add(1, 2);
		add(1, "5");
		
		BMW myCar = new BMW();
		Mazda stupidCar = new Mazda();
	}

}
