package test_Excel;

import utility.Xls_Reader;

public class ExcelOperations {

	public static void main(String[] args) {
		Xls_Reader reader= new Xls_Reader("/Users/yashchouhan/git/Selenium-Practice/Selenium-Practice/testData/Datadriventestdata.xlsx");
		
		
		if(!reader.isSheetExist("Result")){
			reader.addSheet("Result");
		}
		
		int colCount = reader.getColumnCount("RegTestData");
		System.out.println("Total columns present in RegTestData sheet : "+colCount);
		
		System.out.println(reader.getCellRowNum("RegTestData", "firstname", "Tom"));
	}

}
