package application2;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities2.TaxPayer;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);

		Scanner sc = new Scanner(System.in);

		List<TaxPayer> list = new ArrayList<>();

		System.out.print("Quantos contribuintes você vai digitar? ");
		Integer n = sc.nextInt();
		int cont = 0;
		for (int i = 0; i < n; i++) {
			sc.nextLine();
			cont++;
			System.out.println("Digite os dados do " + cont + "° contribuinte: ");
			System.out.print("Renda anual com salário: ");
			Double salaryIncome = sc.nextDouble();
			System.out.print("Renda anual com prestação de serviço: ");
			Double servicesIncome = sc.nextDouble();
			System.out.print("Renda anual com ganho de capital: ");
			Double capitalIncome = sc.nextDouble();
			System.out.print("Gastos médicos: ");
			Double healthSpending = sc.nextDouble();
			System.out.print("Gastos educacionais: ");
			Double educationSpending = sc.nextDouble();
			System.out.println();

			TaxPayer tax = new TaxPayer(salaryIncome, servicesIncome, capitalIncome, healthSpending, educationSpending);

			list.add(tax);
		}

		for (TaxPayer tax1 : list) {
			System.out.println("Resumo do 1o contribuinte:");
			System.out.printf("Imposto bruto total: %.2f%n", tax1.grossTax());
			System.out.printf("Abatimento: %.2f%n", tax1.taxRebate());
			System.out.printf("Imposto devido: %.2f", tax1.netTax());
		}

	}

}