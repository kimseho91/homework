package com.bitcamp.bank.domains;

public class AccountBean {
	private String accountNum, today, money;

	public String getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

	public String getToday() {
		return today;
	}

	public void setToday(String today) {
		this.today = today;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}
	@Override
	public String toString() {
		return String.format("계좌번호: %s, 계좌 생성일: %s, 잔액: %s"
							, accountNum, today, money);
	}
}
