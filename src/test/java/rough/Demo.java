package rough;

import static org.testng.Assert.assertEquals;

public class Demo {
	public static void main(String[] args) {
		String str= "nayan";
		String str1="Logged in as nayan";
		assertEquals("Logged in as "+str+"", str1);
	}
}
