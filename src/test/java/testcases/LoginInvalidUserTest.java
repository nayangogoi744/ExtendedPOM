package testcases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.Base;
import com.pages.HomePageEvents;
import com.pages.signup.SignUpSignInPageEvents;

public class LoginInvalidUserTest extends Base {

	@Test(dataProvider = "myprovider")
	public void loginwithInvalidCredentials(String invalidEmail, String invalidPassword) throws InterruptedException {
		HomePageEvents hm = new HomePageEvents(getDriver());
		//hm.verifyTitle();
		soft.get().assertEquals("Automation Exercise", getDriver().getTitle());
		SignUpSignInPageEvents signuplogin = hm.clickSignUpLoginLink();
		//signuplogin.verifyLoginTextPresent();
		soft.get().assertEquals("ALogin to your account",signuplogin.verifyloginText.getText());
		signuplogin.login(invalidEmail, invalidPassword);
		//signuplogin.verifyLoginError();
		soft.get().assertEquals("Your email or password is incorrect!",signuplogin.verifyloginText.getText());
		soft.get().assertAll();
	}

	@DataProvider(name = "myprovider")
	public Object[][] getData() throws IOException {
		Object[][] obj = excel.getExcelData("signinInvalid");
		return obj;
	}
}
