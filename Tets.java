package test;

import org.junit.Test;

public class Tets {
	
	
	public void add (String a, String b) {
		System.out.println("add string - " + a + b);
	}
	
	public void add (int a, int b) {
		System.out.println("add int - " + (a + b));
	}
	
	
	@Test
	public void test() {
		add("1", "2");
	}
}
