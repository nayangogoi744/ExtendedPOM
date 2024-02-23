package rough;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.Base;

import utilities.ExcelReader;

public class Demo{

public static ExcelReader excel = new ExcelReader("\\src\\test\\resources\\com\\excel\\testdatasheet.xlsx");
@Test(dataProvider = "dp")
public void test(String firstname,String lastname,String email,String title,String password,String day,String month,String year,String company,String firstaddress,String secondaddress,String country,String state,String city,String zipcode,String mobile) {
	System.out.println(day);
	System.out.println(year);
	System.out.println(zipcode);
	System.out.println(mobile);
}

@DataProvider(name="dp")
public Object[][] userData() throws IOException{ 
	  Object[][] arrayObject = ExcelReader.getExcelData("signup"); 
	  return arrayObject; 
}

}
