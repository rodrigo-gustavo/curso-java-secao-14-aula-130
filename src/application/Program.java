package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;
import entities.OutsourcedEmployee;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Employee> empList = new ArrayList<Employee>();

		System.out.print("Enter the number of employees: ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Employee #" + i + " data:");
			System.out.print("Outsourced (y/n)? ");
			char x = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String employeeName = sc.nextLine();
			System.out.print("Hours: ");
			Integer hours = sc.nextInt();
			System.out.print("Value per hour: ");
			Double vph = sc.nextDouble();
			if (x == 'y') {
				System.out.print("Additional charge: ");
				double additionalCharge = sc.nextDouble();
				empList.add(new OutsourcedEmployee(employeeName, hours, vph, additionalCharge));
			} else {
				
				empList.add(new Employee(employeeName, hours, vph));
			}
		}

		System.out.println();
		System.out.println("PAYMENTS:");
		for (Employee e : empList) {
			System.out.println(e.getName() + " - $" + String.format("%.2f", e.payment()));
		}

		sc.close();
	}
}
