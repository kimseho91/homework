package com.bitcamp.bank.domains;

public class AdminBean extends MemberBean{
	private int sabun;

	public int getSabun() {
		return sabun;
	}

	public void setSabun(int sabun) {
		this.sabun = sabun;
	}
	@Override
	public String toString() {
		return String.format("아이디: %s, 비밀번호: %s, 이름: %s, 주민등록번호: %s, 사원번호: %d"
				, getId(),getPw(), getName(), getSsn(), sabun);
	}
}
