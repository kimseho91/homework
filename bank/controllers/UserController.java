package com.bitcamp.bank.controllers;

import javax.swing.JOptionPane;

import com.bitcamp.bank.domains.CustomerBean;
import com.bitcamp.bank.domains.MemberBean;
import com.bitcamp.bank.services.MemberService;
import com.bitcamp.bank.servicesimpl.MemberServiceImpl;

public class UserController {

	public static void main(String[] args) {
		CustomerBean cusbean = null;
		MemberService memservice = new MemberServiceImpl();
		String temp = "";
		String[] arr = null;

		while (true) {

			switch (JOptionPane.showInputDialog("0. 종료\n" 
												+ "1. 회원가입 \n "
												+ "2. 회원 리스트 \n  " 
												+ "3. 이름 찾기 \n  " 
												+ "4. 아이디 찾기 \n " 
												+ "5. 로그인  \n" 
												+ "6. 회원 수 확인 \n"
												+ "7. 아이디확인 \n" 
												+ "8. 비밀번호 변경 \n" 
												+ "9. 회원탈퇴 \n")) {
			case "0":
				JOptionPane.showMessageDialog(null, "종료합니다");

				return;
			case "1":
				cusbean = new CustomerBean();
				 arr = JOptionPane.showInputDialog("아이디, 비번 , 이름, 주민번호, 신용등급을 입력하세요  ")
															.split(",");
				cusbean.setId(arr[0]);
				cusbean.setPw(arr[1]);
				cusbean.setName(arr[2]);
				cusbean.setSsn(arr[3]);
				cusbean.setCredit(arr[4]);

				JOptionPane.showMessageDialog(null, "회원가입 완료");

				break;
			case "2":
				JOptionPane.showMessageDialog(null, memservice.findAllCustomers());

				break;
			case "3":
				JOptionPane.showMessageDialog(null, memservice.findByName(JOptionPane.showInputDialog("이름을 입력하세요")));

				break;
			case "4":
				JOptionPane.showMessageDialog(null, memservice.findById(JOptionPane.showInputDialog("아이디를 입력하세요")));

				break;
			case "5":
				cusbean = new CustomerBean();
				arr = JOptionPane.showInputDialog("아이디, 비번을 입력하세요").split(",");
				cusbean.setId(arr[0]);
				cusbean.setPw(arr[1]);
				JOptionPane.showMessageDialog(null, memservice.login(cusbean));
				break;
			case "6":
				JOptionPane.showMessageDialog(null, String.format("회원수는 %s명입니다.", memservice.countMembers()));
				break;

			case "7":
				if (memservice.existId(JOptionPane.showInputDialog("아이디를 입력하세요"))) {
					JOptionPane.showMessageDialog(null, "존재하는 아이디 입니다");
				} else {
					JOptionPane.showMessageDialog(null, "존재하지 않는 아이디 입니다");
				}
				break;
			case "8":
				cusbean = new CustomerBean();
				arr = JOptionPane.showInputDialog("아이디, 이전 비번 , 새로 변경할 비번을 입력하세요").split(",");
				cusbean.setId(arr[0]);
				cusbean.setPw(arr[1] + arr[2]);

				memservice.updatePass(cusbean);

				break;
			case "9":
				cusbean = new CustomerBean();
				arr = JOptionPane.showInputDialog("삭제할 아이디와 비번을 입력하세요").split(",");
				cusbean.setId(arr[0]);
				cusbean.setPw(arr[1]);
				memservice.deleteMember(cusbean);

				break;
			}
		}
	}
}
