package com.nopCommerceTestData;

import org.testng.annotations.DataProvider;

import com.nopCommerceUtility.Utility_Excel;

public class DataSupplier {
	Utility_Excel excel = new Utility_Excel();

	@DataProvider(name = "UserDetails")
	public Object[][] getRegistrationData() {
		// Totals rows count
		int rows = excel.getRowCount("Register");
		// Total Columns
		int column = excel.getColumnCount("Register");
		int actRows = rows - 1;

		Object[][] data = new Object[actRows][column];

		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = excel.getCellData("Register", j, i + 2);
			}
		}
		return data;
	}

	@DataProvider(name = "UserBillingDetails")
	public Object[][] getBillingData() {
		// Totals rows count
		int rows = excel.getRowCount("Checkout");
		// Total Columns
		int column = excel.getColumnCount("Checkout");
		int actRows = rows - 1;

		Object[][] data = new Object[actRows][column];

		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = excel.getCellData("Checkout", j, i + 2);
			}
		}
		return data;
	}

	@DataProvider(name = "SearchItems")
	public Object[][] getSearchItemsData() {
		// Totals rows count
		int rows = excel.getRowCount("SearchItems");
		// Total Columns
		int column = excel.getColumnCount("SearchItems");
		int actRows = rows - 1;

		Object[][] data = new Object[actRows][column];

		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = excel.getCellData("SearchItems", j, i + 2);
			}
		}
		return data;
	}
}
