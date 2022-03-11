package com.Crm.Vtiger;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import ObjectPomClasses.HomePage;
import ObjectPomClasses.Login;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {


	public WebDriver driver;
	public PropUtility proUti=new PropUtility();
	public WebdriverUtility wdUtil = new WebdriverUtility();

	@BeforeTest(groups = {"smoke","regression"})
	public void beforeTest() 
	{
		System.out.println("==BeforeTest==");
	}

	@BeforeSuite(groups = {"smoke","regression"})
	public void makeConnections()
	{
		System.out.println("==Before Suite==");
		System.out.println("DB Connection");
	}
	/**
	 * This is Before Class Annotation  and This Will Open The Browser
	 * @throws IOException
	 */

	@Parameters("BROWSER")
	@BeforeClass(groups = {"smoke","regression"})
	public void launchBrowser_driver_initialize(String BROWSER) throws IOException
	{
		System.out.println("==BeforeClass==");

		WebDriverManager.chromedriver().setup();

		String Browser=proUti.readFromtextFile("Browser");


		if(Browser.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}

		else if(Browser.equalsIgnoreCase("opera"))
		{
			driver=new OperaDriver();
		}

		else
		{
			System.out.println("Browser Not Available");
		}

		driver.get(proUti.readFromtextFile("url"));


		driver.manage().window().maximize();


		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

	}


	/**
	 * This Method execute Before @Test  ,this will Login the Page 
	 * @throws IOException
	 */
	@BeforeMethod(groups = {"smoke","regression"})

	public void logintoApp() throws IOException
	{
		Login login=new Login(driver);

		login.getUsernametxtField().sendKeys(proUti.readFromtextFile("username"));

		login.getPasswordtxtField().sendKeys(proUti.readFromtextFile("password"));

		login.getLoginbtn().click();


	}

	/**
	 * This Method execute After @Test  ,And its Logout the Page 
	 */
	@AfterMethod(groups = {"smoke","regression"})

	public void logoutfromApp()
	{
		HomePage homePage = new HomePage(driver);

		WebElement signoutImg=homePage.signoutimg();


		wdUtil.movetoUtil(driver,signoutImg);

		homePage.signoutlink().click();

	}

	/**
	 * This is after class annotation and this will close the browser.
	 * @throws InterruptedException
	 */
	
	
	@AfterClass(groups = {"smoke","regression"})
	public void Ac() throws InterruptedException
	{
		Thread.sleep(10000);
		driver.close();
	}


	@AfterTest(groups = {"smoke","regression"})

	public void At()
	{

	}








}
