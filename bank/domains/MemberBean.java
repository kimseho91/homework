package com.bitcamp.bank.domains;

public class MemberBean {
	private String id, pw, name, ssn;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	@Override
	public String toString() {
		return String.format("아이디: %s, 비밀번호: %s, 이름: %s, 주민등록번호: %s"
							,id, pw, name, ssn);
	}
}
