package com.Crm.Vtiger;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {

	/**
	 * @author Ashu
	 * This method will read data from excel
	 * @param Excel Sheet name
	 * @param rNum
	 * @param cellNum
	 * @return value in string form
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readFromExcel(String sName,int rNum,int cellNum) throws EncryptedDocumentException, IOException
	{

		FileInputStream fis=new FileInputStream(IAutoConstants.excelPath);

		return 	WorkbookFactory.create(fis).getSheet(sName).getRow(rNum).getCell(cellNum).getStringCellValue();


	}


}
