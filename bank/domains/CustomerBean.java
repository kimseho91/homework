package com.bitcamp.bank.domains;

public class CustomerBean extends MemberBean {
	private String credit;

	public String getCredit() {
		return credit;
	}

	public void setCredit(String credit) {
		this.credit = credit;
	}
	@Override
	public String toString() {
		return String.format("아이디: %s, 비밀번호: %s, 이름: %s, 주민등록번호: %s,  신용도: %s등급"
				 ,getId(), getPw(), getName(), getSsn(), credit);
	}
}
