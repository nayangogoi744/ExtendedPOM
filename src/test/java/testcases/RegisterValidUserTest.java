package testcases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.Base;
import com.pages.HomePageEvents;
import com.pages.signup.AccountCreatedPageEvents;
import com.pages.signup.AccountInformationPageEvents;
import com.pages.signup.DeleteAccountPageEvents;
import com.pages.signup.SignUpSignInPageEvents;

import utilities.ExcelReader;

public class RegisterValidUserTest extends Base {

	@Test(priority = 1, dataProvider = "myprovider")
	public void performSignUp(String firstname, String lastname, String email, String title, String password,
			String day, String month, String year, String company, String firstaddress, String secondaddress,
			String country, String state, String city, String zipcode, String mobile) throws InterruptedException {
		HomePageEvents hm = new HomePageEvents(getDriver());
		//hm.verifyTitle();
		soft.get().assertEquals("Automation Exercise", getDriver().getTitle());
		SignUpSignInPageEvents signuplogin = hm.clickSignUpLoginLink();
		//signuplogin.verifySignUpTextPresent();
		soft.get().assertEquals("New User Signup!" , signuplogin.verifyusrSignUpText.getText());
		AccountInformationPageEvents accinfo = signuplogin.signUp(firstname, email);
		//accinfo.verifyTextPresent();
		soft.get().assertEquals("ENTER ACCOUNT INFORMATION",accinfo.verifyText.getText() );
		AccountCreatedPageEvents acccreated = accinfo.enterAccountInfo(title, password, day, month, year, firstname,
				lastname, company, firstaddress, secondaddress, country, state, city, zipcode, mobile);
		//acccreated.verifyAccountCreated();
		soft.get().assertEquals("ACCOUNT CREATED!", acccreated.verifyTxt.getText());
		hm = acccreated.clickContinue();
		//hm.verifyUserNamePresent(firstname);
		soft.get().assertEquals("Logged in as "+firstname+"", hm.navbarUserText.getText());
		soft.get().assertAll();
		

	}

	@Test(enabled = true, priority = 2, dataProvider = "myprovider")
	public void loginWithValidCredentials(String firstname, String lastname, String email, String title,
			String password, String day, String month, String year, String company, String firstaddress,
			String secondaddress, String country, String state, String city, String zipcode, String mobile)
			throws InterruptedException {
		HomePageEvents hm = new HomePageEvents(getDriver());
		SignUpSignInPageEvents signuplogin = hm.clickSignUpLoginLink();
		//signuplogin.verifyLoginTextPresent();
		soft.get().assertEquals("Login to your account",signuplogin.verifyloginText.getText());
		hm = signuplogin.login(email, password);
		//hm.verifyUserNamePresent(firstname);
		soft.get().assertEquals("Logged in as "+firstname+"",hm.navbarUserText.getText());
		// DeleteAccountPageEvents deleteacc = hm.deleteAccount();
		// deleteacc.verifyTextPresent();
		// hm = deleteacc.clickContinue();
		soft.get().assertAll();

	}

	@Test(enabled = true, priority = 3, dataProvider = "myprovider")
	public void logoutTest(String firstname, String lastname, String email, String title, String password, String day,
			String month, String year, String company, String firstaddress, String secondaddress, String country,
			String state, String city, String zipcode, String mobile) throws InterruptedException {
		HomePageEvents hm = new HomePageEvents(getDriver());
		SignUpSignInPageEvents signuplogin = hm.clickSignUpLoginLink();
		//signuplogin.verifyLoginTextPresent();
		soft.get().assertEquals("Login to your account",signuplogin.verifyloginText.getText());
		hm = signuplogin.login(email, password);
		//hm.verifyUserNamePresent(firstname);
		soft.get().assertEquals("Logged in as "+firstname+"",hm.navbarUserText.getText());
		SignUpSignInPageEvents su = hm.clickLogOutLink();
		//su.verifyLoginTextPresent();
		soft.get().assertEquals("ALogin to your account",signuplogin.verifyloginText.getText());
		soft.get().assertAll();
	}

	@Test(enabled = true, priority = 4, dataProvider = "myprovider")
	public void performSignUpWithExistingEmail(String firstname, String lastname, String email, String title,
			String password, String day, String month, String year, String company, String firstaddress,
			String secondaddress, String country, String state, String city, String zipcode, String mobile)
			throws InterruptedException {
		HomePageEvents hm = new HomePageEvents(getDriver());
		//hm.verifyTitle();
		soft.get().assertEquals("Automation Exercise", getDriver().getTitle());
		SignUpSignInPageEvents signuplogin = hm.clickSignUpLoginLink();
		//signuplogin.verifySignUpTextPresent();
		soft.get().assertEquals("New User Signup!" , signuplogin.verifyusrSignUpText.getText());
		signuplogin.signUp(firstname, email);
		//signuplogin.verifySignUpError();
		soft.get().assertEquals("HoEmail Address already exist",signuplogin.signupError.getText());
		soft.get().assertAll();
	}

	@DataProvider(name = "myprovider")
	public Object[][] getData() throws IOException {
		Object[][] obj = excel.getExcelData("signup");
		return obj;
	}

}
