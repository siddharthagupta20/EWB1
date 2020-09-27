package com.cg_ewb1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
		CompanyEmpWage companyEmpWage = companyEmpWageList.get(0);
		companyEmpWage.setTotalEmpWage(this.computeEmpWage(companyEmpWage));
		System.out.println(companyEmpWage);
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

			totalEmpHours += empHours;
			System.out.println("Day: " + totalWorkingDays + " Emp Hr:  " + empHours);
		}
		return totalEmpHours * companyEmpWage.empRatePerHour;

	}

	public static void main(String[] args) {
		EmpWageBuilderOOPs empWageBuilder = new EmpWageBuilderOOPs();
		empWageBuilder.addCompanyEmpWage("Reliance", 20, 2, 10);
		empWageBuilder.addCompanyEmpWage("Capgemini", 10, 4, 20);
		empWageBuilder.computeEmpWage();
	}

}
