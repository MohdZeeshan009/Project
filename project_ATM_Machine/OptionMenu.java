package project_ATM_Machine;

// Main Class

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class OptionMenu extends Accounts{
	
	int selection;

	Scanner menuOutput=new Scanner(System.in);
	DecimalFormat moneyFormat=new DecimalFormat("'$'###,##0.00");
	HashMap<Integer, Integer> data=new HashMap<Integer, Integer>();

	// Validate Login Information of Account Number and Pin Number
	
	public void getLogin()throws IOException{
		int x=1;
		
		do {
			try {
				data.put(961668	, 2255);
				data.put(961768	, 2253);
				data.put(961568	, 2353);

				System.out.println("----------Welcome to the ATM Machine Project----------");
				
				System.out.println("Enter your Account number: ");
				setAccountNumber(menuOutput.nextInt());
				
				System.out.println("Enter your correct PIN number: ");
				setPinNumber(menuOutput.nextInt());
			
			}catch (Exception e) {
				System.out.println("\n"+"You have Enter Incorrect value !! you have to enter only numbers: "+"\n");
				x=2;
			}
			for(Entry<Integer, Integer> entry : data.entrySet()) {
				if(entry.getKey()== getAccountNumber() && entry.getValue()== getPinNumber()) {
					getAccountType();
				}
			}
			System.out.println("\n"+"Wrong Account or Pin Number "+"\n");
		}while(x == 1);
	}

	// Display Account Type Menu with Selection

	public void getAccountType() {

		System.out.println("Selected the Account you want to Access: ");
		System.out.println("Type 1:- Current Account");
		System.out.println(("Type 2:- Saving Account"));
		System.out.println("Type 3:- Exit");
		System.out.println("Choice: ");

		selection=menuOutput.nextInt();

		switch(selection) {

		case 1: 
			getCurrent();
			break;

		case 2:
			getSaving();
			break;
		case 3:
			System.out.println("Thankyou for using this ATM"+"\n"+"Have you nice day, bye bye....");
			break;
			
		default:
			System.out.println("Invailid choice. "+"\n");
			getAccountType();


		}
	}

	// Display Current Account Menu with selection


	public void getCurrent() {
		System.out.println("Current Account");
		System.out.println("Type 1:- View Balance");
		System.out.println("Type 2:- Withdraw Balance");
		System.out.println("Type 3:- Deposite Fund");
		System.out.println("Type 4:- Exit");
		System.out.println("Choice: ");

		selection=menuOutput.nextInt();

		switch (selection) {
		case 1: 
			System.out.println("Current Account Balance is "+moneyFormat.format(getCurrentBalance()));
			getAccountType();
			break;
		case 2:
			getCurrentWithdrawInput();
			getAccountType();
			break;
		case 3:
			getCurrentDepositInput();
			getAccountType();
			break;
		case 4: 
			System.out.println("Thankyou for using this ATM"+"\n"+" Have you nice day, bye bye....");
			break;
		default:
			System.out.println("\n"+ "You have entered wrong selection "+"\n");
			getCurrent();
		}

	}

	// Display Saving Account menu with selection

	public void getSaving() {
		System.out.println("Saving Account");
		System.out.println("Type 1:- View Balance");
		System.out.println("Type 2:- Withdraw Balance");
		System.out.println("Type 3:- Deposit fund");
		System.out.println("Type 4:- Exit");
		System.out.println("Choice: ");

		selection=menuOutput.nextInt();

		switch (selection) {
		case 1: 
			System.out.println("Your Saving account Balance is "+moneyFormat.format(getSavingBalance()));
			getAccountType();
			break;
		case 2:
			getSavingWithdrawInput();
			getAccountType();
			break;
		case 3:
			getSavingDepositInput();
			getAccountType();
			break;
		case 4:
			System.out.println("Thankyou for using this ATM"+"\n"+" Have you nice day, bye bye....");
			break;
		
		default:
			System.out.println("\n"+"You have entered wrong keyword "+"\n");
			getSaving();
		}
	}


}


