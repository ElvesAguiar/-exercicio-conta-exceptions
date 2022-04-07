package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.entities.LendingAccount;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
	Locale.setDefault(Locale.US);
	Scanner sc = new Scanner(System.in);

	
	try {
	System.out.println("Enter account data");
	//adquirindo dados
	
	System.out.print("Number: ");
	int number =sc.nextInt();
	System.out.print("Holder: ");
	sc.nextLine();
	String holder = sc.nextLine();
	System.out.print("Initial balance: ");
	double initialBalance = sc.nextDouble();
	System.out.print("Withdraw limit: ");
	double witharawLimit = sc.nextDouble();
	
	Account account = new LendingAccount(number, holder, initialBalance, witharawLimit);
	
	System.out.println("");
	//testando metodo withdraw
	System.out.print("Enter amount for withdraw: ");
	double withdraw = sc.nextDouble();
	account.withdraw(withdraw);
	
	System.out.println("New balance: "+account.getBalance());
	
	}catch (DomainException e) {
		System.out.println(e.getMessage());
	}catch (RuntimeException e) {
		System.out.println(e.getMessage());
	}
	
	sc.close();
	}

}
