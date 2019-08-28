package com.bitcamp.bank.services;

import com.bitcamp.bank.domains.AccountBean;

public interface AccountService {
	public void createAccount(int money); //돈 입금하면 오늘 날짜 시간과 생성된 계좌번호가 같이 생성.
	public String createAccountNum();//계좌 생성(랜덤으로 0000-0000)- 유닉한 값으로 생성.
	public AccountBean[] findAll();
	public AccountBean findByAccountNum(String accountNum);
	public int countAccounts();
	public boolean existAccountNum(String accountNum);
	public String findDate(); //오늘 날짜, 현재 시간 , 분까지 반환
	public void depositMoney(AccountBean param);
	public void withdrawMoney(AccountBean param);
	public void deleteAccountNum(String accountNum);
}
