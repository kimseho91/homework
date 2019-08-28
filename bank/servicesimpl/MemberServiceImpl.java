package com.bitcamp.bank.servicesimpl;

import com.bitcamp.bank.domains.AdminBean;
import com.bitcamp.bank.domains.CustomerBean;
import com.bitcamp.bank.domains.MemberBean;
import com.bitcamp.bank.services.MemberService;

public class MemberServiceImpl implements MemberService {
	private AdminBean admin = new AdminBean();
	private CustomerBean customer = new CustomerBean();
	private CustomerBean[] customers;
	private AdminBean[] admins;
	private int cusCount;
	private int admCount;

	public MemberServiceImpl() {
		customers = new CustomerBean[10];
		admins = new AdminBean[10];
		cusCount = 0;
		admCount = 0;
	}

	@Override
	public void join(CustomerBean param) {
		if (existId(param.getId()) == true) {
			customers[cusCount] = param;
			cusCount++;
		}
	}

	@Override
	public void resister(AdminBean param) {
		// TODO Auto-generated method stub

	}

	@Override
	public CustomerBean[] findAllCustomers() {
		return customers;
	}

	@Override
	public AdminBean[] findAllAdmins() {
		return admins;
	}

	@Override
	public MemberBean[] findByName(String name) {
		int j = 0;
		for (int i = 0; i < cusCount; i++) {
			if (name.equals(customers[i].getName())) {
				j++;
				break;
			}
		}
		int k = 0;
		for (int i = 0; i < admCount; i++) {
			if (name.equals(admins[i].getName())) {
				k++;
				break;
			}
		}
		int count1 = 0, count2 = 0;
		MemberBean[] members = new MemberBean[j + k];
		for (int i = 0; i < cusCount; i++) {
			if (name.equals(customers[i].getName())) {
				members[i] = customers[i];
				count1++;
				if (count1 == j) {
					break;
				}
			}
		}
		for (int i = 0; i < admCount; i++) {
			if (name.equals(admins[i].getName())) {
				members[j + i] = admins[i];
				count2++;
				if (count2 == k) {
					break;
				}
			}
		}
		return members;
	}

	@Override
	public MemberBean findById(String id) {
		MemberBean members = new MemberBean();
		for (int i = 0; i < cusCount; i++) {
			if (id.equals(customers[i].getId())) {
				members = customers[i];
				break;
			}
		}
		for (int i = 0; i < admCount; i++) {
			if (id.equals(admins[i].getId())) {
				members = admins[i];
				break;
			}
		}
		return members;
	}

	@Override
	public boolean login(MemberBean param) {
		boolean flag = false;
		if (findById(param.getId()).equals(param.getPw())) {
			flag = true;
		}
		return flag;
	}

	@Override
	public int countMembers() {
		return cusCount;
	}

	@Override
	public int countAdmins() {
		return admCount;
	}

	@Override
	public boolean existId(String id) {
		boolean flag = true;
		for (int i = 0; i < cusCount; i++) {
			if (id.equals(customers[i].getId())) {
				flag = false;
			}
		}
		return flag;
	}

	@Override
	public void updatePass(MemberBean param) {
		String loginId = param.getId();
		String loginPw = param.getPw();
		String[] arr = loginPw.split(",");
		String oldPw = arr[0];
		String newPw = arr[1];
		System.out.println(arr[0] + arr[1]);
		if (login(param)) {
			for (int i = 0; i < cusCount; i++) {
				if (loginId.equals(customers[i].getId())) {
					customers[i].setPw(newPw);
					break;
				}
			}
			for (int i = 0; i < admCount; i++) {
				if (loginId.equals(admins[i].getId())) {
					admins[i].setPw(newPw);
					break;
				}
			}
		}
	}

	@Override
	public void deleteMember(MemberBean param) {
		if (login(param)) {
			for (int i = 0; i < cusCount; i++) {
				if (param.getId().equals(customers[i].getId())) {
					customers[i] = customers[cusCount - 1];
					cusCount--;
					break;
				}
			}
			for (int i = 0; i < admCount; i++) {
				if (param.getId().equals(admins[i].getId())) {
					admins[i] = admins[admCount - 1];
					admCount--;
					break;
				}
			}

		}
	}

}
