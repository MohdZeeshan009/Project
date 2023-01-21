package project_ATM_Machine;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Accounts {

	private int accountNumber;
	private int pinNumber;
	private double currentBalance=0;
	private double savingbalance=0;

	Scanner sc= new Scanner(System.in);
	DecimalFormat moneyFormat=new DecimalFormat("'$'###,##0.00");

	// Setting customer Account number

	public int setAccountNumber(int accountNumber) {
		return this.accountNumber=accountNumber;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public int setPinNumber(int pinNumber) {
		return this.pinNumber=pinNumber;
	}

	public int getPinNumber() {
		return pinNumber;
	}


	// Using get function to get Saving Account Balance

	public double getCurrentBalance() {
		return currentBalance;
	}

	// Using get function to get Saving Account Balance

	public double getSavingBalance() {
		return savingbalance;
	}

	// Calculating Current account balance after Withdraw amount

	public double calCurrentWithdraw(double amount) {
		currentBalance=(currentBalance-amount);
		return currentBalance;
	}

	// Calculating Saving account balance after Withdraw amount

	public double calSavingWithdraw(double amount) {
		savingbalance=(savingbalance-amount);
		return savingbalance;
	}

	//	Calculating Current Account Balance After Deposit

	public double calCurrentDeposit(double amount) {
		currentBalance=(currentBalance+amount);
		return currentBalance;
	}

	//	Calculating Saving Account Balance After Deposit

	public double calSavingDeposit(double amount) {
		savingbalance=(savingbalance+amount);
		return savingbalance;
	}

	//	Checking customer withdraw Input of Current Account

	public void getCurrentWithdrawInput() {
		System.out.println("Cuurent Account Balance "+ moneyFormat.format(currentBalance));
		System.out.println("Amount you want to Withdraw from your Current Account: ");
		double amount=sc.nextDouble();

		if((currentBalance-amount)>=0) {
			calCurrentWithdraw(amount);
			System.out.println("New Current Account Balance is "+ moneyFormat.format(currentBalance));
		}
		else {
			System.out.println("You have Insuffcient Balance in your Current Account "+"\n");
		}

	}
	
	//	Checking customer withdraw Input of Saving Account
	
	public void getSavingWithdrawInput() {
		System.out.println("Saving Account balance is "+ moneyFormat.format(savingbalance));
		System.out.println("Enter the amount you want to withDraw from your Saving Account ");
		double amount=sc.nextDouble();
		
		if((savingbalance-amount)>=0) {
			calSavingWithdraw(amount);
			System.out.println("New Saving account balance is "+ moneyFormat.format(savingbalance));
		}
		else {
			System.out.println("You have Insufficient Balance in your Saving Account "+"\n");
		}
	}
	
	// Checking Customer deposit Input of Current Account
	
	public void getCurrentDepositInput() {
		System.out.println("Enter the amount you want to deposit in your Current Account ");
		double amount=sc.nextDouble();
		
		if((currentBalance+amount)>=0) {
			calCurrentDeposit(amount);
			System.out.println("New Current Account Balance is "+ moneyFormat.format(currentBalance));
		}
		else {
			System.out.println("You have entered wrong amount !!! Please Enter only positive Numbers "+"\n");
		}
	}
	
	// Checking Customer deposit Input of Saving Account
	
		public void getSavingDepositInput() {
			System.out.println("Enter the amount you want to deposit in your Current Account ");
			double amount=sc.nextDouble();
			
			if((savingbalance+amount)>=0) {
				calSavingDeposit(amount);
				System.out.println("New Current Account Balance is "+ moneyFormat.format(savingbalance));
			}
			else {
				System.out.println("You have entered wrong amount !!! Please Enter only positive Numbers "+"\n");
			}
		}


}

















