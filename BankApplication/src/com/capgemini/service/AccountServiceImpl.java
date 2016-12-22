package com.capgemini.service;

import java.util.StringJoiner;

import com.capgemini.exceptions.InsufficientBalanceException;
import com.capgemini.exceptions.InsufficientInitialBalanceException;
import com.capgemini.exceptions.InvalidAccountNumberException;
import com.capgemini.model.Account;
import com.capgemini.repository.AccountRepository;

public class AccountServiceImpl implements AccountService {
	
	/* (non-Javadoc)
	 * @see com.capgemini.service.AccountService#createAccount(int, int)
	 */
	
	AccountRepository accountRepository;
	
	public AccountServiceImpl(AccountRepository accountRepository)
	{
		this.accountRepository=accountRepository;
	}
	@Override
	public Account createAccount(int accountNumber,int amount)throws InsufficientInitialBalanceException
	{
		if(amount<500)
		{
			throw new InsufficientInitialBalanceException();
		}
		
		Account account = new Account();
		account.setAccountNumber(accountNumber);
		account.setAmount(amount);
		
		if(accountRepository.save(account))
		{
			return account;
		}
		
		return null;
		
	}

	
	@Override
	public int showBalance(Account account) throws InvalidAccountNumberException {
		if(account == accountRepository.searchAccount(account.getAccountNumber())){
			return account.getAmount();
		}
		return 0;
		
		
	}
	@Override
	public int withdrawAmount(Account account, int amount) throws InvalidAccountNumberException, InsufficientBalanceException {
		int balanceAmount = 0;
		if(account == accountRepository.searchAccount(account.getAccountNumber())){
			balanceAmount = showBalance(account) - amount; 
		}
		return balanceAmount;
	}
	@Override
	public int depositAmount(Account account, int amount) throws InvalidAccountNumberException, InsufficientBalanceException {
		int balanceAmount = 0;
		if(account == accountRepository.searchAccount(account.getAccountNumber())){
			balanceAmount = showBalance(account) + amount; 
		}
		return balanceAmount;
	}
	@Override
	public StringJoiner fundTransfer(int accountNum1, int accountNum2, int amount)
			throws InvalidAccountNumberException, InsufficientBalanceException {
		// TODO Auto-generated method stub
		return null;
	}
}
