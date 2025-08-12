package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Conta;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		Conta conta; /**/

		System.out.print("Enter account number: ");
		int number = sc.nextInt();
		System.out.print("Enter account holder: ");
		sc.nextLine();
		String holder = sc.nextLine();
		System.out.print("Is there na initial deposit (y/n)? ");
		char response = sc.next().charAt(0);

		if (response == 'y') {
			System.out.print("Enter initial deposit value: ");
			double depositInitial = sc.nextDouble();
			conta = new Conta(number, holder, depositInitial);
			/*
			 * Veja que não pudemos declarar "Conta conta" aqui por vai ficar limitado essa
			 * declaração somente dentro do if. Por isso que declaramos la em cima, e depois
			 * só chamamos a instancia onde quisermos.
			 */

		} else {
			conta = new Conta(number, holder);
		}

		System.out.println();
		System.out.println("Account data:");
		System.out.println(conta.toString());
		System.out.println();
		System.out.print("Enter a deposit value: ");
		double deposit = sc.nextDouble();
		conta.deposit(deposit);
		System.out.println("Update account data: :");
		System.out.println(conta.toString());
		System.out.println();
		System.out.print("Enter a withdraw value: ");
		double withdraw = sc.nextDouble();
		conta.withdraw(withdraw);
		System.out.println(conta.toString());
	}

}