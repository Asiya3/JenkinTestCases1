package JecnkinTestCase;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.Crm.Vtiger.Base;
import com.Crm.Vtiger.JavaUtil;

import ObjectPomClasses.ContactInfoPage;
import ObjectPomClasses.Contactinfo_PopUp;
import ObjectPomClasses.CreateContactPage;
import ObjectPomClasses.HomePage;

public class TC_3 extends Base{

	@Test(groups = {"regression"})
	public void create_Contact() throws IOException, InterruptedException
	{

		HomePage homepage=new HomePage(driver);

		homepage.getContactLink().click();



		ContactInfoPage info=new ContactInfoPage(driver);


		info.getCreatecontactsimg().click();

		CreateContactPage conPage=new CreateContactPage(driver);

		WebElement ele=conPage.getSaltutiontype();

		wdUtil.selectFromdd("Ms.", ele);

		JavaUtil jv = new JavaUtil();

		String firstname=jv.fakeFirstName();

		String lastname=jv.fakeLastName();

		conPage.getfirstname().sendKeys(firstname);

		conPage.getLastNameEdt().sendKeys(lastname);

		conPage.getOrganizationLookUpImage().click();

		wdUtil.swtichtowindow("Accounts", driver);

		String orgname="zzz";

		Contactinfo_PopUp contactinfo_PopUp=new Contactinfo_PopUp(driver);

		contactinfo_PopUp.getSearchorgtxtfld().sendKeys(orgname);


		contactinfo_PopUp.getSearchbtn().click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//a[@id='1']")).click();

		wdUtil.swtichtowindow("Contacts", driver);

		conPage.getSaveBtn().click();

		Thread.sleep(3000);

		homepage.getContactLink().click();

		info.getSearchcontacttxtfld().sendKeys(firstname);

		wdUtil.selectFromdd("firstname", info.getSearchforcontactDD());

		info.getSearchcontactbtn().click();

		Thread.sleep(2000);

		String value=driver.findElement(By.xpath("//a[@title='Organizations']")).getText();

		if(value.equalsIgnoreCase(orgname)) {
			System.out.println("TC PAss");
		}

		else {
			System.out.println("TC Fail");
		}


	}

	@Test(groups = {"smoke"})

	public  void create_contact_Test() throws InterruptedException, IOException {

		HomePage homepage=new HomePage(driver);

		homepage.getContactLink().click();



		ContactInfoPage info=new ContactInfoPage(driver);


		info.getCreatecontactsimg().click();

		CreateContactPage conPage=new CreateContactPage(driver);

		WebElement ele=conPage.getSaltutiontype();

		wdUtil.selectFromdd("Ms.", ele);

		JavaUtil jv = new JavaUtil();

		String firstname=jv.fakeFirstName();

		String lastname=jv.fakeLastName();

		conPage.getfirstname().sendKeys(firstname);

		conPage.getLastNameEdt().sendKeys(lastname);

		conPage.getSaveBtn().click();


		homepage.getContactLink().click();

		info.getSearchcontacttxtfld().sendKeys(firstname);

		wdUtil.selectFromdd("firstname", info.getSearchforcontactDD());

		info.getSearchcontactbtn().click();

		Thread.sleep(2000);

		String value=driver.findElement(By.xpath("//a[@title='Contacts']")).getText();

		if(value.equalsIgnoreCase(firstname)) {
			System.out.println("TC PAss");
		}

		else {
			System.out.println("TC Fail");
		}	
	}
}
