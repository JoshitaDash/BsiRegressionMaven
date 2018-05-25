package com.tcs.BsiShopRedesign.utilities;

import java.util.Hashtable;

public class BsiConstants {
	public static final String ENV = "UAT"; // QA,PROD,STAGE

	// URLs-QA5
	public static final String QA5_URL = "";
	public static final String QA5_USERNAME = "";
	public static final String QA5_PASSWORD = "";

	// URLs-Store QA
	public static final String STORE_QA_URL = "";
	public static final String STORE_QA_USERNAME = "";
	public static final String STORE_QA_PASSWORD = "";

	// URLs-prod
	public static final String PROD_URL = "";
	public static final String PROD_USERNAME = "";
	public static final String PROD_PASSWORD = "";

	// URLs-uat
	public static final String UAT_URL = "https://staging-standards.bsigroup.com/";
	public static final String UAT_USERNAME = "autoTest@tcs.com";
	public static final String UAT_PASSWORD = "Test@1234";

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
			} else if (ENV.equalsIgnoreCase("QA5")) {
				table.put("url", QA5_URL);
				table.put("username", QA5_USERNAME);
				table.put("password", QA5_PASSWORD);
			}else if (ENV.equalsIgnoreCase("STOREQA")) {
				table.put("url", STORE_QA_URL);
				table.put("username", STORE_QA_USERNAME);
				table.put("password", STORE_QA_PASSWORD);
			}

		}
		return table;

	}
}
