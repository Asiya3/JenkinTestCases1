package ObjectPomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	
	WebDriver driver;
	@FindBy(xpath="//a[.='Organizations']")
	private WebElement Organizationlink;
	
	@FindBy(xpath="//a[.='Contacts']")
	private WebElement contactslink;
	
	
	public WebElement getOrginizationlink() 
	{
		return Organizationlink;
	}

	public WebElement getContactLink()
	{
		return contactslink;
	}
	
public HomePage(WebDriver driver)
{
	this.driver=driver;
	
	PageFactory.initElements(driver, this);
}
	
@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
private WebElement signoutimg;	

	
@FindBy(xpath="//a[.='Sign Out']")
private WebElement signoutlink;


public WebElement signoutimg()
{
	
	return signoutimg;
	
}


public WebElement signoutlink()
{
	return signoutlink;
	
}
	
	
	

}
