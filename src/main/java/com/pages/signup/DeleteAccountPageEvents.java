package com.pages.signup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.base.Base;
import com.page.TopMenu;
import com.pages.HomePageEvents;

public class DeleteAccountPageEvents extends TopMenu{

	WebDriver driver;

	@FindBy(xpath = "//h2[@data-qa='account-deleted']")
	WebElement verifyText;

	@FindBy(xpath = "//a[@data-qa='continue-button']")
	WebElement continueBtn;

	public DeleteAccountPageEvents(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public HomePageEvents clickContinue() {
		Base.click(continueBtn);
		return new HomePageEvents(driver);
	}

	public void verifyTextPresent() {
		String expected = "ACCOUNT DELETED!";
		//Assert.assertEquals(verifyText.getText(), expected);
		Base.soft.assertEquals(verifyText.getText(), expected);
	}
}
