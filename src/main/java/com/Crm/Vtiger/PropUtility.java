package com.Crm.Vtiger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropUtility {

	
	
	public String readFromtextFile(String  path,String key) throws IOException
	{
		FileInputStream fis=new FileInputStream(path);
		
	    Properties prop=new Properties();
	    
	    prop.load(fis);
	    
	  return  prop.getProperty(key);
		
	}
	
	public String readFromtextFile(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream(IAutoConstants.proptFilePath);
		Properties prop=new Properties();
		
		prop.load(fis);
		
		return prop.getProperty(key);
		
		
	}
	
	
	
	
	
	
}
