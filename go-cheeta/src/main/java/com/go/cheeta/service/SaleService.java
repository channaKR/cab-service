package com.go.cheeta.service;

import java.sql.SQLException;

import com.go.cheeta.dao.SaleManager;

public class SaleService {

	public boolean addSales() throws ClassNotFoundException, SQLException {
		
		return SaleManager.addSale();
		
	}
}
