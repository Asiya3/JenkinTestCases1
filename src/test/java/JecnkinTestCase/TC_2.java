package JecnkinTestCase;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.Crm.Vtiger.Base;
import com.Crm.Vtiger.IAutoConstants;
import com.Crm.Vtiger.JavaUtil;
import com.Crm.Vtiger.WebdriverUtility;

import ObjectPomClasses.HomePage;
import ObjectPomClasses.OrgInfoPage;
import ObjectPomClasses.createOrgPage;

public class TC_2 extends Base{
	
	
	@Test(groups = {"regression"})
	public void createOrgTc2() throws InterruptedException, EncryptedDocumentException, IOException
	{

		HomePage homePage=new HomePage(driver);
		homePage.getOrginizationlink().click();

		OrgInfoPage orginfo=new OrgInfoPage(driver);

		orginfo.getCreateorgimg().click();


		FileInputStream fis=new FileInputStream(IAutoConstants.excelPath);

		Thread.sleep(3000);

		JavaUtil jv = new JavaUtil();
		int randomNumber=jv.generateRandomNumber();

		String orgnameexcel=WorkbookFactory.create(fis).getSheet("Sheet1").getRow(2).getCell(1).getStringCellValue();

		String orgname=orgnameexcel+randomNumber;
		System.out.println(orgname);

		createOrgPage createorgpage= new createOrgPage(driver);

		createorgpage.getOrgname().sendKeys(orgname);



		WebdriverUtility wbUti=new WebdriverUtility();

		wbUti.selectFromdd("Hospitality",createorgpage.getIndustry());

		wbUti.selectFromdd(createorgpage.getRating(),3);

		wbUti.selectFromdd(createorgpage.getType(),"Customer");


		createorgpage.getOrgsavebtn().click();

		Thread.sleep(3000);

		homePage.getOrginizationlink().click();
		Thread.sleep(3000);

		orginfo.getSearchtxtbox().sendKeys(orgname);

		WebElement ele= orginfo.getOrgtypesdd();


		wdUtil.selectFromdd(ele,"Organization Name");


		orginfo.getSearchorgbtn().click();

		Thread.sleep(2000);

		String value=driver.findElement(By.xpath("//a[@title='Organizations']")).getText();



		if(value.equals(orgname))
		{
			System.out.println("TC2 Pass");

		}

		else
		{
			System.out.println("TC2 Fail");
		}



		Thread.sleep(2000);




	}


}
