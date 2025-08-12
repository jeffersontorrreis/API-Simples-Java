package entities;

public class Conta {
	private int number;
	private String holder;
	private double balance;
	private double depositInitial;

	public Conta(int number, String holder) {
		this.number = number;
		this.holder = holder;
	}

	public Conta(int number, String holder, double depositInitial) {
		this.number = number;
		this.holder = holder;
		deposit(depositInitial);
	}

	public int getNumber() {
		return number;
	}
	/*
	 * Pelo que o exercicio fala o usuario não pode alterar sua conta depois de
	 * informada. Logo só criaremos get
	 */

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public void deposit(double amount) {
		balance += amount;
	}

	public void withdraw(double amount) {
		balance -= amount + 5.0;
	}

	public String toString() {
		return "Account " 
				+ number 
				+ ", Holder: " 
				+ holder 
				+ ", Balance: $ " 
				+ String.format("%.2f", balance);
	}

}
