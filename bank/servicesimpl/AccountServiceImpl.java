package com.bitcamp.bank.servicesimpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import com.bitcamp.bank.domains.AccountBean;
import com.bitcamp.bank.services.AccountService;

public class AccountServiceImpl implements AccountService {
	private AccountBean[] accounts;
	private AccountBean account;
	private int count;

	public AccountServiceImpl() {
		accounts = new AccountBean[10];
		count = 0;
	}

	@Override
	public void createAccount(int money) {
		account = new AccountBean();
		account.setAccountNum(createAccountNum());
		account.setMoney(money + "");
		account.setToday(findDate());
		accounts[count] = account;
		count++;
	}

	@Override
	public String createAccountNum() {
		String accountNum = "";
		Random random = new Random();
		for (int i = 0; i < 9; i++) {
			accountNum += (i == 4) ? "-" : random.nextInt(10);
		}
		return accountNum;
	}

	@Override
	public AccountBean[] findAll() {
		return accounts;
	}

	@Override
	public AccountBean findByAccountNum(String accountNum) {
		account = new AccountBean();
		for (int i = 0; i < count; i++) {
			if (accountNum.equals(account.getAccountNum())) {
				account = this.accounts[i];
				break;
			}
		}
		return account;
	}

	@Override
	public int countAccounts() {
		return count;
	}

	@Override
	public boolean existAccountNum(String accountNum) {
		boolean flag = true;
		for (int i = 0; i < count; i++) {
			if (accountNum.equals(accounts[i].getAccountNum())) {
				flag = false;
				break;
			}
		}
		return flag;
	}

	@Override
	public String findDate() {
		return new SimpleDateFormat("yyyy-MM-dd hh:mm").format(new Date());
	}

	@Override
	public void depositMoney(AccountBean param) {
		String accNum = param.getAccountNum();
		String money = param.getMoney();

		for (int i = 0; i < count; i++) {
			if (accNum.equals(accounts[i].getAccountNum())) {
				String newMoney = String.valueOf(Integer.parseInt(accounts[i].getMoney()) + Integer.parseInt(money));
				accounts[i].setMoney(newMoney);
				accounts[i].setToday(findDate());
				break;
			}
		}
	}

	@Override
	public void withdrawMoney(AccountBean param) {
		String accNum = param.getAccountNum();
		String money = param.getMoney();

		for (int i = 0; i < count; i++) {
			if (accNum.equals(accounts[i].getAccountNum())) {
				String newMoney = String.valueOf(Integer.parseInt(accounts[i].getMoney()) - Integer.parseInt(money));
				accounts[i].setMoney(newMoney);
				accounts[i].setToday(findDate());
				break;
			}
		}
	}

	@Override
	public void deleteAccountNum(String accountNum) {
		for (int i = 0; i < count; i++) {
			if (accountNum.equals(accounts[i].getAccountNum())) {
				accounts[i] = accounts[count - 1];
				System.out.println(accounts[count - 1]);
				accounts[count - 1] = null;
				count--;
				break;
			}
		}
	}

}
