package JecnkinTestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Crm.Vtiger.Base;
import com.Crm.Vtiger.JavaUtil;

import ObjectPomClasses.HomePage;
import ObjectPomClasses.OrgInfoPage;
import ObjectPomClasses.createOrgPage;

public class TC_1 extends Base{
	
	@Test (groups= {"regression"})
	public void orgnization_Create() throws InterruptedException
	{
		HomePage homePage=new HomePage(driver);
		homePage.getOrginizationlink().click();

		OrgInfoPage orginfo=new OrgInfoPage(driver);

		orginfo.getCreateorgimg().click();
		Thread.sleep(3000);

		JavaUtil jv = new JavaUtil();
		String orgname = jv.fakeFirstName();

		createOrgPage createorgpage= new createOrgPage(driver);

		createorgpage.getOrgname().sendKeys(orgname);

		createorgpage.getOrgsavebtn().click();

		Thread.sleep(2000);

		homePage.getOrginizationlink().click();

		OrgInfoPage orgname1=new OrgInfoPage(driver);

		orgname1.getSearchtxtbox().sendKeys(orgname);

		WebElement ele= orgname1.getOrgtypesdd();

		wdUtil.selectFromdd(ele,"Organization Name");

		orgname1.getSearchorgbtn().click();

		Thread.sleep(2000);
		//Validation 
		String value=driver.findElement(By.xpath("//a[@title='Organizations']")).getText();

		System.out.println(value);

		if(value.equals(orgname)) { 

			System.out.println("TC1 Pass");
		}

		else
		{
			System.out.println("TC1 Fail");
		}

		//driver
		
		
	}
	
	
	@Test(groups= {"smoke"})
	public void prgnization_Create() throws InterruptedException
	{
		HomePage homePage=new HomePage(driver);
		homePage.getOrginizationlink().click();

		OrgInfoPage orginfo=new OrgInfoPage(driver);

		orginfo.getCreateorgimg().click();
		

		Thread.sleep(2000);
		
		createOrgPage createorgpage= new createOrgPage(driver);
		createorgpage.getOrgsavebtn().click();
		Thread.sleep(3000);
		
		String text=wdUtil.getTextFromAlert(driver);

		Assert.assertEquals(text, "Organization Name cannot be empty");
		
		wdUtil.dismissAlert(driver);
		          

		
	}
	
}
