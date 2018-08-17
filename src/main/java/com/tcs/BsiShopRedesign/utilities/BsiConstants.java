package com.tcs.BsiShopRedesign.utilities;

import java.util.Hashtable;

public class BsiConstants {
	public static final String ENV = "UAT"; // QA,PROD,STAGE

	// URLs-QA5
	public static final String QA5_URL = "";
	public static final String QA5_USERNAME = "autoTest@tcs.com";
	public static final String QA5_PASSWORD = "Test@1234";
	public static final String QA5_MEM_USERNAME = "subhrateja.satapathy@tcs.com";
	public static final String QA5_MEM_PASSWORD = "Test@1234";

	// URLs-Store QA
	public static final String STORE_QA_URL = "https://standards-storeqa.bsigroup.com/";
	public static final String STORE_QA_USERNAME = "sharmileemohapatra@gmail.com";
	public static final String STORE_QA_PASSWORD = "Test@1234";
	public static final String STORE_QA_MEM_USERNAME = "subhrateja.satapathy@tcs.com";
	public static final String STORE_QA_MEM_PASSWORD = "Test@1234";

	// URLs-Prod
	public static final String PROD_URL = "";
	public static final String PROD_USERNAME = "";
	public static final String PROD_PASSWORD = "";
	public static final String PROD_MEM_USERNAME = "";
	public static final String PROD_MEM_PASSWORD = "";

	// URLs-UAT
	public static final String UAT_URL = "https://staging-standards.bsigroup.com/";
	public static final String UAT_USERNAME = "subhrateja@rediffmail.com";
	public static final String UAT_PASSWORD = "Test@1234";
	public static final String UAT_MEM_USERNAME ="subhrateja.satapathy@tcs.com";
	public static final String UAT_MEM_PASSWORD = "Test@1234";
	public static final String UAT_REG_USERNAME = "autoTest@tcs.com";
	public static final String UAT_MEM_SEC_USERNAME = "sharmileemohapatra@gmail.com";
	public static final String UAT_MEM_SEC_PASSWORD = "June@2018";
	public static final String UAT_TEN_USERNAME = "tenAddress@tcs.com";
	

	public static Hashtable<String, String> table;

	public static Hashtable<String, String> getEnvDetails() {
		if (table == null) {
			table = new Hashtable<String, String>();

			if (ENV.equals("PROD")) {
				table.put("url", PROD_URL);
				table.put("username", PROD_USERNAME);
				table.put("password", PROD_PASSWORD);

			} else if (ENV.equals("UAT")) {
				table.put("url", UAT_URL);
				table.put("username", UAT_USERNAME);
				table.put("password", UAT_PASSWORD);
				table.put("mem_username", UAT_MEM_USERNAME);
				table.put("mem_password", UAT_MEM_PASSWORD);
				table.put("reg_username", UAT_REG_USERNAME);
				table.put("mem_sec_username", UAT_MEM_SEC_USERNAME);
				table.put("mem_sec_password", UAT_MEM_SEC_PASSWORD);
				table.put("ten_address_username", UAT_TEN_USERNAME);

			} else if (ENV.equalsIgnoreCase("QA5")) {
				table.put("url", QA5_URL);
				table.put("username", QA5_USERNAME);
				table.put("password", QA5_PASSWORD);
				table.put("mem_username", QA5_MEM_USERNAME);
				table.put("mem_password", QA5_MEM_PASSWORD);

			} else if (ENV.equalsIgnoreCase("STOREQA")) {
				table.put("url", STORE_QA_URL);
				table.put("username", STORE_QA_USERNAME);
				table.put("password", STORE_QA_PASSWORD);
				table.put("mem_username", STORE_QA_MEM_USERNAME);
				table.put("mem_password", STORE_QA_MEM_PASSWORD);

			}

		}
		return table;

	}
}
