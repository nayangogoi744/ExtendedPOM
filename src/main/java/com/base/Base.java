package com.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;

import listeners.CustomListeners;
import utilities.ExcelReader;
import utilities.ExtentManager;

public class Base {

	public ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	public static ExtentReports extent = ExtentManager.getInstance();
	public static Properties prop = new Properties();
	public static Logger log = LogManager.getLogger();
	public static ExcelReader excel = new ExcelReader("\\src\\test\\resources\\com\\excel\\testdatasheet.xlsx");;
	public static FileInputStream fis;

	public void setDriver(WebDriver driver) {
		this.driver.set(driver);
	}

	public WebDriver getDriver() {
		return this.driver.get();
	}

	@BeforeSuite
	public void initializeConfig() {

		try {

			// fis = new
			// FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\com\\properties\\config.properties");
			if (System.getProperty("os.name").contains("Linux")) {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "//src//test//resources//com//properties//config.properties");
			}
			fis = new FileInputStream(
					System.getProperty("user.dir") + "//src//test//resources//com//properties//config.properties");
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Parameters(value = { "browserName" })
	@BeforeMethod
	public void setup(String browserName) {

		if (browserName.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("incognito");
			options.addArguments("disable-extensions");
			options.addArguments("disable-popup-blocking");
			options.addArguments("make-default-browser");
			options.addArguments("disable-infobars");
			setDriver(new ChromeDriver(options));
		} else if (browserName.equalsIgnoreCase("firefox")) {
			setDriver(new FirefoxDriver());
		}

		getDriver().get(prop.getProperty("testurl"));
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@AfterMethod
	public void teardown() {
		getDriver().quit();
	}

	@AfterSuite
	public void flush() {
		extent.flush();
	}

	public static void click(WebElement link) {
		link.click();
		CustomListeners.test.log(Status.INFO, "Clicking the link" + link);
		log.info("Clicked the link " + link);

	}

	public static void type(WebElement link, String value) {
		link.sendKeys(value);
		CustomListeners.test.log(Status.INFO, "Typing " + value + " in the textbox" + link);
		log.info("Typed " + value + " in the textbox" + link);
	}

	public static void clear(WebElement link) {
		link.clear();
		CustomListeners.test.log(Status.INFO, "Clearing the textbox" + link);
		log.info("Clear the textbox" + link);
	}

	public static void select(WebElement link, String value) {
		Select se = new Select(link);
		se.selectByVisibleText(value);
		CustomListeners.test.log(Status.INFO, "Selecting the " + value + "from" + link);
		log.info("Selecting the " + value + "from" + link);
	}

}
