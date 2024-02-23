package com.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base;
import com.pages.CartPageEvents;
import com.pages.ContactUsEvents;
import com.pages.HomePageEvents;
import com.pages.ProductsPageEvents;
import com.pages.TestCasesEvents;
import com.pages.VideoTutorialsEvents;
import com.pages.signup.DeleteAccountPageEvents;
import com.pages.signup.SignUpSignInPageEvents;



public class TopMenu{

	WebDriver driver;

	@FindBy(xpath="//a[contains(text(),' Home')]")
	WebElement homePageLink;
	
	@FindBy(xpath="//a[@href='/products']")
	WebElement productsLink;
	
	@FindBy(xpath="//a[contains(text(),' Cart')]")
	WebElement cartLink;
	
	@FindBy(xpath = "//a[@href='/login']")
	WebElement singUpLonginLink;
	
	@FindBy(xpath="//a[contains(text(),' Test Cases')]")
	WebElement testCasesLink;
	
	@FindBy(xpath="//a[contains(text(),' API Testing')]")
	WebElement apiTestingLink;
	
	@FindBy(xpath="//a[contains(text(),' Video Tutorials')]")
	WebElement videoTutorialsLink;
	
	@FindBy(xpath="//a[contains(text(),' Contact us')]")
	WebElement contactUsLink;
	
	@FindBy(xpath="//a[@href='/delete_account']")
	WebElement deleteAccBtn;
	
	@FindBy(xpath="//a[@href='/logout']")
	WebElement logoutBtn;
	
	@FindBy(xpath="//i[@class='fa fa-user']//ancestor::a")
	WebElement navbarUserText;

	
	public TopMenu(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public HomePageEvents clickHomePageLink() {
		Base.click(homePageLink);
		return new HomePageEvents(driver);
		
	}
	public ProductsPageEvents clickProductsLink() {
		Base.click(productsLink);
		return new ProductsPageEvents();
			
		}
	public CartPageEvents clickCartLink() {
		Base.click(cartLink);
		return new CartPageEvents();
		
	}
	public SignUpSignInPageEvents clickSignUpLoginLink() {
		Base.click(singUpLonginLink);
		return new SignUpSignInPageEvents(driver);
		
	}
	
	public DeleteAccountPageEvents deleteAccount() {
		Base.click(deleteAccBtn);
		return new DeleteAccountPageEvents(driver);
	}
	
	
	public TestCasesEvents clickTestCasesLink() {
		Base.click(testCasesLink);
		return new TestCasesEvents();
		
	}
	public VideoTutorialsEvents clickVideoTutorialsLink() {
		Base.click(videoTutorialsLink);
		return new VideoTutorialsEvents();
		
	}
	public ContactUsEvents clickContactUsLink() {
		Base.click(contactUsLink);
		return new ContactUsEvents();
		
	}
	
	public SignUpSignInPageEvents clickLogOutLink() {
		Base.click(logoutBtn);
		return new SignUpSignInPageEvents(driver);
		
	}
}
