package com.cg_ewb1;

public class EmpWageBuilderOOPs implements EmpWageBuilderInterface {
	public static final int IS_PART_TIME = 1;
	public static final int IS_FULL_TIME = 2;

	private int numOfCompany = 0;
	private CompanyEmpWage[] companyEmpWageArray;

	public EmpWageBuilderOOPs() {
		companyEmpWageArray = new CompanyEmpWage[5];
	}

	public void addCompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maxHoursPerMonth) {
		companyEmpWageArray[numOfCompany] = new CompanyEmpWage(company, empRatePerHour, numOfWorkingDays,
				maxHoursPerMonth);
		numOfCompany++;
	}

	public void computeEmpWage() {
		for (int i = 0; i < numOfCompany; i++) {
			companyEmpWageArray[i].setTotalEmpWage(this.computeEmpWage(companyEmpWageArray[i]));
			System.out.println(companyEmpWageArray[i]);
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
