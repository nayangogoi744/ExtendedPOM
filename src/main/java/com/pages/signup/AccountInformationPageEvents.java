package com.pages.signup;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.base.Base;
import com.page.TopMenu;

public class AccountInformationPageEvents extends TopMenu{

	WebDriver driver;
	@FindBy(xpath = "//div[@class='login-form']/h2")
	public WebElement verifyText;

	// @FindBy(xpath="//div[@class='radio-inline']")
	// WebElement radioBtn;
	// @FindBys(xpath="//label")
	// WebElement radioBtnLabel;

	@FindBys({ @FindBy(xpath = "//div[@class='radio-inline']"), @FindBy(xpath = "//label") })
	private List<WebElement> exampleFindBys;

	@FindBy(id = "id_gender2")
	WebElement mrsRadioBtn;

	@FindBy(id = "name")
	WebElement nameField;

	@FindBy(id = "email")
	WebElement emailField;

	@FindBy(id = "password")
	WebElement passwordField;

	@FindBy(id = "days")
	WebElement daysDropDown;

	@FindBy(id = "months")
	WebElement monthsDropDown;

	@FindBy(id = "years")
	WebElement yearsDropDown;

	@FindBy(id = "newsletter")
	WebElement newsletterCheckBox;

	@FindBy(id = "optin")
	WebElement optinCheckBox;

	@FindBy(id = "first_name")
	WebElement firstName;

	@FindBy(id = "last_name")
	WebElement lastName;

	@FindBy(id = "company")
	WebElement companyName;

	@FindBy(id = "address1")
	WebElement firstAddress;

	@FindBy(id = "address2")
	WebElement secondAddress;

	@FindBy(id = "country")
	WebElement countryName;

	@FindBy(id = "state")
	WebElement stateName;

	@FindBy(id = "city")
	WebElement cityName;

	@FindBy(id = "zipcode")
	WebElement zipCodeName;

	@FindBy(id = "mobile_number")
	WebElement mobileNo;

	@FindBy(xpath = "//button[@data-qa='create-account']")
	WebElement createAccBtn;

	public AccountInformationPageEvents(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void verifyTextPresent() {
		String expected = "ENTER ACCOUNT INFORMATION";
		//Assert.assertEquals(verifyText.getText(), expected);
		//Base.soft.assertEquals(verifyText.getText(), expected);
	}

	public void selectTitle(String title) {

		for (WebElement select : exampleFindBys) {
			if (select.getText().contains(title)) {
				select.click();
			}
		}
	}

	public AccountCreatedPageEvents enterAccountInfo(String title, String password, String day, String month,
			String year, String firstname, String lastname, String companyname, String firstaddress,
			String secondaddress, String country, String state, String district, String pincode, String phn)
			throws InterruptedException {
		selectTitle(title);
		Base.type(passwordField, password);
		Base.select(daysDropDown, day);
		Base.select(monthsDropDown, month);
		Base.select(yearsDropDown, year);
		Base.click(newsletterCheckBox);
		Base.click(optinCheckBox);
		Base.type(firstName, firstname);
		Base.type(lastName, lastname);
		Base.type(companyName, companyname);
		Base.type(firstAddress, firstaddress);
		Base.type(secondAddress, secondaddress);
		Base.select(countryName, country);
		Base.type(stateName, state);
		Base.type(cityName, district);
		Base.type(zipCodeName, pincode);
		Base.type(mobileNo, phn);
		Base.click(createAccBtn);
		return new AccountCreatedPageEvents(driver);
	}

}
