package com.pages.signup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.base.Base;
import com.page.TopMenu;
import com.pages.HomePageEvents;

public class SignUpSignInPageEvents extends TopMenu{

	WebDriver driver;

	@FindBy(xpath = "//div[@class='login-form']//h2")
	WebElement verifyloginText;

	@FindBy(xpath = "//div[@class='signup-form']//h2")
	WebElement verifyusrSignUpText;

	@FindBy(xpath = "//input[@data-qa='signup-name']")
	WebElement signupName;

	@FindBy(xpath = "//input[@data-qa='signup-email']")
	WebElement signupEmail;

	@FindBy(xpath = "//button[@data-qa='signup-button']")
	WebElement signupBtn;

	@FindBy(xpath = "//form/p[@style='color: red;']")
	WebElement loginerrorMsg;

	@FindBy(xpath = "//input[@data-qa='login-email']")
	WebElement emailName;

	@FindBy(xpath = "//input[@data-qa='login-password']")
	WebElement passwordName;

	@FindBy(xpath = "//button[@data-qa='login-button']")
	WebElement loginBtn;

	@FindBy(xpath = "//form[@action='/signup']/p")
	WebElement signupError;

	@FindBy(xpath = "//form[@action='/login']/p")
	WebElement loginError;

	public SignUpSignInPageEvents(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void verifySignUpTextPresent() {
		String expected = "New User Signup!";
		//Assert.assertEquals(verifyusrSignUpText.getText(), expected);
		Base.soft.assertEquals(verifyusrSignUpText.getText(), expected);
	}

	public void verifyLoginTextPresent() {
		String expected = "Login to your account";
		String actual = verifyloginText.getText();
		//Assert.assertEquals(actual, expected);
		Base.soft.assertEquals(actual, expected);
	}

	public AccountInformationPageEvents signUp(String name, String email) {

		Base.type(signupName, name);
		Base.type(signupEmail, email);
		Base.click(signupBtn);
		/*
		 * if(errorMsg.isDisplayed()) { Assert.assertTrue(false); }
		 */
		return new AccountInformationPageEvents(driver);
	}

	public void verifySignUpError() {
		String expected = "Email Address already exist!";
		//Assert.assertEquals(signupError.getText(), expected);
		Base.soft.assertEquals(signupError.getText(), expected);
	}

	public void verifyLoginError() {
		String expected = "Your email or password is incorrect!";
		//Assert.assertEquals(expected, loginError.getText());
		Base.soft.assertEquals(expected, loginError.getText());

	}

	public HomePageEvents login(String email, String password) {
		Base.type(emailName, email);
		Base.type(passwordName, password);
		Base.click(loginBtn);
		return new HomePageEvents(driver);

	}
}
