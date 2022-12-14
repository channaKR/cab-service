package com.go.cheeta.service;

import java.sql.SQLException;
import java.util.List;

import com.go.cheeta.dao.BookingManager;
import com.go.cheeta.dao.SaleManager;
import com.go.cheeta.model.Booking;
import com.go.cheeta.model.Sales;

public class SaleService {

	public boolean addSales(Sales sale) throws ClassNotFoundException, SQLException {
		
		return SaleManager.addSale(sale);
		
	}
	public boolean delteBooking(Booking booking) throws ClassNotFoundException, SQLException {
		
		return BookingManager.deleteBooking(booking);
	}
	public List<Sales> searchByBranch() throws ClassNotFoundException, SQLException{
		return SaleManager.searchByBranch();
		
		
	}
	
	public Sales allCoast() throws ClassNotFoundException, SQLException {
		
		return SaleManager.allCoast();
	}
	public  List<Sales> searchBranchSales(Sales sale) throws ClassNotFoundException, SQLException{
		return SaleManager.searchBranchSales(sale);
	}
	
	public List<Sales> getSalesbyID(Sales sale) throws ClassNotFoundException, SQLException {
		return SaleManager.getConfirmOrders(sale);
	}
}
