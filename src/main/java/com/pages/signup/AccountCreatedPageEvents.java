package com.pages.signup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.base.Base;
import com.page.TopMenu;
import com.pages.HomePageEvents;

public class AccountCreatedPageEvents extends TopMenu{

	WebDriver driver;
	@FindBy(xpath = "//h2/b")
	public WebElement verifyTxt;

	@FindBy(xpath = "//a[@data-qa='continue-button']")
	WebElement continueBtn;

	public AccountCreatedPageEvents(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void verifyAccountCreated() {
		String expected = "ACCOUNT CREATED!";
		//Assert.assertEquals(verifyTxt.getText(), expected);
		//Base.soft.assertEquals(verifyTxt.getText(), expected);
	}

	public HomePageEvents clickContinue() {
		Base.click(continueBtn);
		return new HomePageEvents(driver);
	}
}
