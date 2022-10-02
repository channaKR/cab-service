package com.go.cheeta.service;

import java.sql.SQLException;

import com.go.cheeta.dao.AccountManager;
import com.go.cheeta.model.Account;

public class AccountService {

	public Account adminLogin(Account login) throws ClassNotFoundException, SQLException {
		return AccountManager.adminLogin(login);
		
	}
}
