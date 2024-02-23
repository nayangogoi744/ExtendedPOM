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

public class RegisterValidUserTest extends Base{

	@Test(priority = 1,dataProvider  = "myprovider")
	public void performSignUp(String firstname,String lastname,String email,String title,String password,String day,String month,String year,String company,String firstaddress,String secondaddress,String country,String state,String city,String zipcode,String mobile) throws InterruptedException {
		HomePageEvents hm = new HomePageEvents(getDriver());
		hm.verifyTitle();
		SignUpSignInPageEvents signuplogin = hm.clickSignUpLoginLink();
		signuplogin.verifySignUpTextPresent();
		AccountInformationPageEvents accinfo = signuplogin.signUp(firstname,email);
		accinfo.verifyTextPresent();
		AccountCreatedPageEvents acccreated= accinfo.enterAccountInfo(title,password,day,month,year,firstname,lastname,company,firstaddress,secondaddress,country, state,city,zipcode,mobile);
		acccreated.verifyAccountCreated();
		hm = acccreated.clickContinue();
		hm.verifyUserNamePresent(firstname);
		
	}
	
	
	@Test(enabled=true,priority = 2,dataProvider = "myprovider")
	public void loginWithValidCredentials(String firstname,String lastname,String email,String title,String password,String day,String month,String year,String company,String firstaddress,String secondaddress,String country,String state,String city,String zipcode,String mobile) throws InterruptedException {
		HomePageEvents hm = new HomePageEvents(getDriver());
		SignUpSignInPageEvents signuplogin = hm.clickSignUpLoginLink();
		signuplogin.verifyLoginTextPresent();
		hm = signuplogin.login(email, password);
		hm.verifyUserNamePresent(firstname);
		//DeleteAccountPageEvents deleteacc = hm.deleteAccount();
		//deleteacc.verifyTextPresent();
		//hm = deleteacc.clickContinue();
		
		
	}
	
	@Test(enabled=true,priority = 3,dataProvider = "myprovider")
	public void logoutTest(String firstname,String lastname,String email,String title,String password,String day,String month,String year,String company,String firstaddress,String secondaddress,String country,String state,String city,String zipcode,String mobile) throws InterruptedException {
		HomePageEvents hm = new HomePageEvents(getDriver());
		SignUpSignInPageEvents signuplogin = hm.clickSignUpLoginLink();
		signuplogin.verifyLoginTextPresent();
		hm = signuplogin.login(email, password);
		hm.verifyUserNamePresent(firstname);
		SignUpSignInPageEvents su = hm.clickLogOutLink();
		su.verifyLoginTextPresent();
		
	}
	
	@Test(enabled=true,priority = 4,dataProvider = "myprovider")
	public void performSignUpWithExistingEmail(String firstname,String lastname,String email,String title,String password,String day,String month,String year,String company,String firstaddress,String secondaddress,String country,String state,String city,String zipcode,String mobile) throws InterruptedException {
		HomePageEvents hm = new HomePageEvents(getDriver());
		hm.verifyTitle();
		SignUpSignInPageEvents signuplogin = hm.clickSignUpLoginLink();
		signuplogin.verifySignUpTextPresent();
		signuplogin.signUp(firstname,email);
		signuplogin.verifySignUpError();
	}
	
	
	  @DataProvider(name="myprovider") 
	  public Object[][] getData() throws IOException {
		  Object[][] obj = excel.getExcelData("signup");
		  return obj;
		  }
	 
}
