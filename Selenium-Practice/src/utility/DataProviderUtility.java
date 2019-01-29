package utility;

import java.util.ArrayList;

public class DataProviderUtility {
	static Xls_Reader reader;
	public static ArrayList<Object[]> getDataFromExcel(){
		
		ArrayList<Object[]>  mydata = new ArrayList<Object[]>();
		try{
			reader= new Xls_Reader("/Users/A622893/git/Selenium-Practice/Selenium-Practice/testData/DataProviderDatadrivenTest.xlsx");
		   }
		catch(Exception e){
			e.printStackTrace();
		}
		
		for(int rowNum=2; rowNum <= reader.getRowCount("RegTestData"); rowNum++){
			String firstname=reader.getCellData("RegTestData", "firstname", rowNum);
			System.out.println(firstname);
			
			String lastname=reader.getCellData("RegTestData", "lastname", rowNum);
			System.out.println(lastname);
			
			String phone=reader.getCellData("RegTestData", "phone", rowNum);
			System.out.println(phone);

			String email=reader.getCellData("RegTestData", "email", rowNum);
			System.out.println(email);
			
			String address1=reader.getCellData("RegTestData", "address1", rowNum);
			System.out.println(address1);
			
			String address2=reader.getCellData("RegTestData", "address2", rowNum);
			System.out.println(address2);
			
			String city=reader.getCellData("RegTestData", "city", rowNum);
			System.out.println(city);
			
			String state=reader.getCellData("RegTestData", "state", rowNum);
			System.out.println(state);
			
			String zipcode=reader.getCellData("RegTestData", "zipcode", rowNum);
			System.out.println(zipcode);
			
			String username=reader.getCellData("RegTestData", "username", rowNum);
			System.out.println(username);
			
			String password=reader.getCellData("RegTestData", "password", rowNum);
			System.out.println(password);
			
			String confirmpassword=reader.getCellData("RegTestData", "confirmpassword", rowNum);
			System.out.println(confirmpassword);
			
			Object ob[] = {firstname, lastname, address1, address2, city, state, zipcode, username, password, confirmpassword };
			mydata.add(ob);

		}
		
		return mydata;
		
	}
	
	

}
