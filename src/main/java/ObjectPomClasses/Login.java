package ObjectPomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	
	WebDriver driver;
	
	
	@FindBy(name="user_name")
	private WebElement  usernametxtfld;
	
	
	@FindBy(name="user_password")
	private WebElement  passwordtxtfld;
	
	@FindBy(id="submitButton")
	
	private WebElement loginbtn;
	
	
	public WebElement getUsernametxtField()
	{
		return usernametxtfld;
		
	}
	
	public WebElement getPasswordtxtField()
	{
		return passwordtxtfld;
		
	}
	
	public WebElement getLoginbtn()
	{
		return loginbtn;
		
	}
	
	public Login(WebDriver driver)
	{
		
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}

}

/*
 * LoginPage loginpage = new LoginPage(driver);
 * 
 * loginpage.getUsernametxtfld().sendKeys(fileutil.readDatafromPropfile("UN"));
 * 
 * loginpage.getPasswordtxtfld().sendKeys(fileutil.readDatafromPropfile("PWD"));
 * 
 * loginpage.getLoginbtn().click();
 */

