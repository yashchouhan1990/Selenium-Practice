package Selenium_HashMap_concept;

import java.util.HashMap;

public class Data {

	public static HashMap<String, String> getUserLoginInfo(){
		HashMap<String, String> userMap= new HashMap<String, String>();
		userMap.put("admin", "yashchauhanyash@gmail.com_Yash@1990");
		userMap.put("subadmin", "admin_admin@123");
		return userMap;
		
	}
	
	public static  HashMap<Integer, String> monthMap() {
		HashMap<Integer, String> monthMap= new HashMap<Integer, String>();
		monthMap.put(1, "January");
		monthMap.put(1, "Feburary");
		monthMap.put(1, "March");
		monthMap.put(1, "April");
		monthMap.put(1, "May");
		
		monthMap.put(1, "June");
		monthMap.put(1, "July");
		monthMap.put(1, "August");
		monthMap.put(1, "September");
		monthMap.put(1, "October");
		
		monthMap.put(1, "November");
		monthMap.put(1, "December");
		return monthMap;
	}

}
