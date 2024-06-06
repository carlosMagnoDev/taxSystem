package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPlayer;

public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner input = new Scanner(System.in);
		
		List<TaxPlayer> list = new ArrayList<>();
		
		System.out.print("Enter the number of tax player: ");
		int number = input.nextInt();
		
		for (int i = 0; i < number; i++) {
			
			System.out.print("Individual or company (i/c)? ");
			char confirm = input.next().charAt(0);
			
			input.nextLine();
			
			System.out.print("Name: ");
			String name = input.nextLine();
			
			System.out.print("Anual income: ");
			Double anualIncome = input.nextDouble();
			
			if (confirm == 'i') {
				System.out.print("Helath expenditures: ");
				Double healthSpending = input.nextDouble();
				TaxPlayer taxPlayer = new Individual(name, anualIncome, healthSpending);
				list.add(taxPlayer);
				
			} else if (confirm == 'c') {
				System.out.print("Number of employee: ");
				Integer employee = input.nextInt();
				TaxPlayer taxPlayer = new Company(name, anualIncome, employee);
				list.add(taxPlayer);
				
			} else {
				System.out.println("erro!");
			}
			
		}
		
		System.out.println("\nTAXES PAID:");
		for (TaxPlayer taxPlayer : list) {
			System.out.printf("%s: $ %.2f\n", taxPlayer.getName(), taxPlayer.tax());
		}
		
		Double sum = 0.0; 
		for (TaxPlayer taxPlayer : list) {
			sum += taxPlayer.tax();
		}

		System.out.printf("\nTOTAL TAXES: $ %.2f", sum);
		
		input.close();
	}
}
