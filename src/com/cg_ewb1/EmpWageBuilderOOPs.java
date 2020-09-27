package com.cg_ewb1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EmpWageBuilderOOPs implements EmpWageBuilderInterface {
	public static final int IS_PART_TIME = 1;
	public static final int IS_FULL_TIME = 2;

	private ArrayList<CompanyEmpWage> companyEmpWageList;
	private Map<String, CompanyEmpWage> companyToEmpWageMap;

	public EmpWageBuilderOOPs() {
		companyEmpWageList = new ArrayList<>();
		companyToEmpWageMap = new HashMap<>();
	}

	public void addCompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maxHoursPerMonth) {
		CompanyEmpWage companyEmpWage = new CompanyEmpWage(company, empRatePerHour, numOfWorkingDays, maxHoursPerMonth);
		companyEmpWageList.add(companyEmpWage);
		companyToEmpWageMap.put(company, companyEmpWage);
	}

	public void computeEmpWage() {
		for (CompanyEmpWage cew : companyEmpWageList) {
			cew.setTotalEmpWage(this.computeEmpWage(cew));
			System.out.println(cew);
			cew.computeDailyWages();
		}
	}

	public int computeEmpWage(CompanyEmpWage companyEmpWage) {
		int empHours = 0, totalEmpHours = 0, totalWorkingDays = 0;

		while (totalEmpHours <= companyEmpWage.maxHoursPerMonth && totalWorkingDays < companyEmpWage.numOfWorkingDays) {
			totalWorkingDays++;

			int empCheck = (int) Math.floor(Math.random() * 10) % 3;

			switch (empCheck) {
			case IS_PART_TIME:
				empHours = 4;
				break;
			case IS_FULL_TIME:
				empHours = 8;
				break;
			default:
				empHours = 0;
			}
			companyEmpWage.dailyWages.add(empHours * companyEmpWage.empRatePerHour);

			totalEmpHours += empHours;
			System.out.println("Day: " + totalWorkingDays + " Emp Hr:  " + empHours);
		}
		return totalEmpHours * companyEmpWage.empRatePerHour;

	}

	public CompanyEmpWage getTotalWages(String companySearch) {
		for (CompanyEmpWage cew : companyEmpWageList) {
			if ((cew.company).equalsIgnoreCase(companySearch))
				return cew;
			else
				return null;
		}
		return null;
	}

	public static void main(String[] args) {
		EmpWageBuilderOOPs empWageBuilder = new EmpWageBuilderOOPs();
		Scanner sc = new Scanner(System.in);
		boolean continuation = true;
		while (continuation) {
			System.out.println("1.Add Company Details.");
			System.out.println("2.Search Company for Employee Wages.");
			System.out.println("3.End Employee Wage Builder.");

			int check = sc.nextInt();
			switch (check) {
			case 1:
				System.out.println("Enter Company name: ");
				String name = sc.nextLine();
				sc.nextLine();
				System.out.println("Enter Employee Rates Per Hour: ");
				int rate = sc.nextInt();
				System.out.println("Enter Number Of Working Days: ");
				int days = sc.nextInt();
				System.out.println("Enter Max Hours per Month: ");
				int hours = sc.nextInt();
				sc.nextLine();
				empWageBuilder.addCompanyEmpWage(name, rate, days, hours);
				break;
			case 2:
				System.out.println("Enter company to be searched: ");
				String nameSearch = sc.nextLine();
				sc.nextLine();
				System.out.println("Total Emp Wages are: "+empWageBuilder.computeEmpWage(empWageBuilder.getTotalWages(nameSearch)));
				break;
			case 3:
				System.out.println("Thank You :)");
				continuation=false;
			}
		}
	}

}
