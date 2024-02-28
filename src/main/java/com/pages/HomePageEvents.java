package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base;
import com.page.TopMenu;

public class HomePageEvents extends TopMenu{

	@FindBy(xpath = "//i[@class='fa fa-user']//ancestor::a")
	WebElement navbarUserText;

	WebDriver driver;

	public HomePageEvents(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void verifyTitle() {
		String expected = "Automation Exercise";
		//Assert.assertEquals(expected, driver.getTitle());
		Base.soft.assertEquals(expected, driver.getTitle());

	}

	public void verifyUserNamePresent(String username) {
		String text = "Logged in as " + username;
		System.out.println(text);
		System.out.println(navbarUserText.getText());
		if (navbarUserText.getText().contains(text)) {
			//Assert.assertTrue(true);
			Base.soft.assertTrue(false);
		} else {
			//Assert.assertTrue(false);
			Base.soft.assertTrue(false);
		}
	}

}
