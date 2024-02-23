package testcases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.Base;
import com.pages.HomePageEvents;
import com.pages.signup.SignUpSignInPageEvents;

public class LoginInvalidUserTest extends Base{

		@Test(dataProvider = "myprovider")
		public void loginwithInvalidCredentials(String invalidEmail, String invalidPassword) throws InterruptedException {
			HomePageEvents hm = new HomePageEvents(getDriver());
			hm.verifyTitle();
			SignUpSignInPageEvents signuplogin = hm.clickSignUpLoginLink();
			signuplogin.verifyLoginTextPresent();
			signuplogin.login(invalidEmail,invalidPassword);
			signuplogin.verifyLoginError();
		}
	
	
	  @DataProvider(name="myprovider") 
	  public Object[][] getData() throws IOException {
		  Object[][] obj = excel.getExcelData("signinInvalid");
		  return obj;
		  }
}
