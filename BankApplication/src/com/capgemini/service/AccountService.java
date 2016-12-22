package com.capgemini.service;

import java.util.StringJoiner;

import com.capgemini.exceptions.InsufficientBalanceException;
import com.capgemini.exceptions.InsufficientInitialBalanceException;
import com.capgemini.exceptions.InvalidAccountNumberException;
import com.capgemini.model.Account;

public interface AccountService {

	Account createAccount(int accountNumber, int amount) throws InsufficientInitialBalanceException;
	int showBalance(Account account) throws InvalidAccountNumberException;
	int withdrawAmount(Account account, int amount) throws InvalidAccountNumberException, InsufficientBalanceException;
	int depositAmount(Account account, int amount) throws InvalidAccountNumberException, InsufficientBalanceException;
	StringJoiner fundTransfer(int accountNum1, int accountNum2, int amount) throws InvalidAccountNumberException, InsufficientBalanceException;
}