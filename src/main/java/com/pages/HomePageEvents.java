package com.pages;

import java.util.List;

import org.apache.logging.log4j.core.util.internal.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.base.Base;
import com.page.TopMenu;
import com.pages.signup.DeleteAccountPageEvents;
import com.pages.signup.SignUpSignInPageEvents;

import listeners.CustomListeners;


public class HomePageEvents extends TopMenu{

	@FindBy(xpath="//i[@class='fa fa-user']//ancestor::a")
	WebElement navbarUserText;

	WebDriver driver;
	public HomePageEvents(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void verifyTitle() {
		String expected="Automation Exercise";
		Assert.assertEquals(expected, driver.getTitle());
		
	}
	
	
	public void verifyUserNamePresent(String username) {
		String text="Logged in as "+username;
		System.out.println(text);
		System.out.println(navbarUserText.getText());
		if(navbarUserText.getText().contains(text)) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
	}

	


	
}
