package com.bitcamp.bank.controllers;

import javax.swing.JOptionPane;

import com.bitcamp.bank.domains.AccountBean;
import com.bitcamp.bank.services.AccountService;
import com.bitcamp.bank.servicesimpl.AccountServiceImpl;

public class AdminController {
	public static void main(String[] args) {
		AccountBean accbean = null;
		AccountService accservice = new AccountServiceImpl();
		String temp = "";
		String[] arr = null;
		
		while (true) {
			switch (JOptionPane.showInputDialog("0.종료\n" + "1. 계좌 생성 \n " + "2. 계좌 정보 보기 \n  " 
																	+ "3. 계좌번호 조회하기 \n "+ "4. 계좌 수 확인  \n" 
																	+ "5. 존재하는 계좌 확인 \n" + "6. 예금 \n" 
																	+ "7. 인출 \n" + "8. 계좌 삭제 \n")) {
			case "0": JOptionPane.showMessageDialog(null, "종료합니다.");
				return;
			case "1":
				temp = JOptionPane.showInputDialog("계좌생성\n입금할 금액을 입력하세요.");
				accbean = new AccountBean();
				accbean.setMoney(temp);
				accservice.createAccount(Integer.parseInt(temp));
				JOptionPane.showMessageDialog(null, accservice.createAccountNum());
				break;
			case "2":
				JOptionPane.showMessageDialog(null,accservice.findAll());
				break;
			case "3":
				JOptionPane.showMessageDialog(null, accservice.findByAccountNum(JOptionPane.showInputDialog("계좌번호를 입력하세요")));
				break;
			case "4":
				JOptionPane.showMessageDialog( null, String.format("계좌는 총 %d입니다 ", accservice.countAccounts()) );
				
				break;
			case "5":
				JOptionPane.showMessageDialog(null, ""+accservice.findByAccountNum(JOptionPane.showInputDialog("계좌번호를 입력하세요")));
				break;
			case "6":
				
				arr =JOptionPane.showInputDialog("입금할 계좌번호, 입금할 금액을 입력하세요").split(","); 
				accbean = new AccountBean();
				accbean.setAccountNum(arr[0]);
				accbean.setMoney(arr[1]);
				accservice.depositMoney(accbean);
				JOptionPane.showMessageDialog(null, accbean.toString());
				break;
			case "7":
				String[] arr1 =JOptionPane.showInputDialog("출금할 계좌번호, 출금할 금액을 입력하세요").split(","); 
				accbean = new AccountBean();
				accbean.setAccountNum(arr1[0]);
				accbean.setMoney(arr1[1]);
				accservice.withdrawMoney(accbean);
				break;
			case "8":
				accservice.deleteAccountNum(JOptionPane.showInputDialog("계좌번호를 입력하세요"));
				break;

			}
			
			
		}

	}
}
