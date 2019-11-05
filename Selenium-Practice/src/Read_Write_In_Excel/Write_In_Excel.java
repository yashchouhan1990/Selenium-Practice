package Read_Write_In_Excel;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Write_In_Excel {

	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream("/Users/yashchouhan/git/Selenium-Practice/Selenium-Practice/testData/Write_In_Excel.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("TestData");
		Row row = sheet.createRow(1);
		Cell cell = row.createCell(1);
		cell.setCellType(CellType.STRING);
		
		 cell.setCellValue("SoftwareTestingMaterial.com");
		 FileOutputStream fos = new FileOutputStream("/Users/yashchouhan/git/Selenium-Practice/Selenium-Practice/testData/Write_In_Excel.xlsx");
		 workbook.write(fos);
		 fos.close();
		 System.out.println("END OF WRITING DATA IN EXCEL");
	}

}
