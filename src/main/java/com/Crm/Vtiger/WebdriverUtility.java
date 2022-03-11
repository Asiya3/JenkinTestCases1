package com.Crm.Vtiger;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

/**
 * 
 * @author Ashu
 *
 */

public class WebdriverUtility {

	/**
	 * 
	 * @param driver
	 */
	

	
	public void pageloadtimeout(WebDriver driver)
	{
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	}
	
	
	//this method used for dropdownlist based on visible text
	
	public void selectFromdd(WebElement element,String value)
	{
		Select sel=new Select(element);
		
		sel.selectByVisibleText(value);
				
	}
	
	
	public void selectFromdd(WebElement element,int  value)
	{
		
		Select sel=new Select(element);
		
		sel.selectByIndex(value);
		
	}
	
	public void selectFromdd(String value,WebElement element)
	{
		Select sel=new Select(element);
		
		sel.selectByValue(value);
	}
	
	
	public void movetoUtil(WebDriver driver,WebElement target)
	{
		 Actions act=new Actions(driver);
		  
		  act.moveToElement(target).build().perform();
		  
	}
	
	public void swtichtowindow(String title,WebDriver driver)
	{
		Set<String> winids = driver.getWindowHandles();
		String currenttitle;
		for (String string : winids) 
		{
			currenttitle=	driver.switchTo().window(string).getTitle();

			if(currenttitle.contains(title)) 
			{
				break;
			}
		}
	}

	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}

	public void dismissAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	public void entertextinAlert(WebDriver driver, String text) {
		driver.switchTo().alert().sendKeys(text);
	}

	public String getTextFromAlert(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}
	
	public void switchframe(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	public void switchframe(WebDriver driver, String nameorid)
	{
		driver.switchTo().frame(nameorid);
	}
	public void switchframe(WebElement element,WebDriver driver)
	{
		driver.switchTo().frame(element);
	}

	
	
}
