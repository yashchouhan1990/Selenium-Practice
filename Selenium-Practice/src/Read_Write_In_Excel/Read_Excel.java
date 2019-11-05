package Read_Write_In_Excel;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Read_Excel {
	
	
	public static void main(String []args) throws IOException{
		
		
		FileInputStream fis= new FileInputStream("/Users/yashchouhan/git/Selenium-Practice/Selenium-Practice/testData/Suite.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		Row row= sheet.getRow(0);
		Cell cel= row.getCell(0);
		
		System.out.println("Data from  Sheet: "+sheet.getRow(0).getCell(0));
		System.out.println("Data from  Sheet: "+sheet.getRow(0).getCell(1));
		
	}

}

/*
Data from  Sheet: TCID
Data from  Sheet: RunMode
*/