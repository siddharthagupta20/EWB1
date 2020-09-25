package com.cg_ewb1;

public class EmpWageBuilderOOPs {
	public static final int IS_PART_TIME = 1;
	public static final int IS_FULL_TIME = 2;

	private final String comp;
	private final int empRatePerHour;
	private final int numOfWorkingDays;
	private final int maxHoursPerMonth;
	private int totalEmpWage;

	public EmpWageBuilderOOPs(String compName, int empRatePerHour, int numOfWorkingDays, int maxHoursPerMonth) {
		this.comp = compName;
		this.empRatePerHour = empRatePerHour;
		this.numOfWorkingDays = numOfWorkingDays;
		this.maxHoursPerMonth = maxHoursPerMonth;

	}

	public void calEmpWages() {

		int empHrs = 0;
		int totalWorkingDays = 0;
		int totalEmpHrs = 0;

		while (totalEmpHrs <= maxHoursPerMonth && totalWorkingDays < numOfWorkingDays) {
			totalWorkingDays++;
			int empCheck = (int) Math.floor(Math.random() * 10) % 3;
			switch (empCheck) {
			case IS_PART_TIME:
				empHrs = 4;
				break;

			case IS_FULL_TIME:
				empHrs = 8;
				break;

			default:
				empHrs = 0;
			}
			totalEmpHrs += empHrs;

			System.out.println("Day#: " + totalWorkingDays + " Emp Hr: " + empHrs);

		}
		totalEmpWage = totalEmpHrs + empRatePerHour;
		System.out.println("Total Emp Wages for Company: " + comp + " is: " + totalEmpWage);

	}

	public static void main(String[] args) {
		EmpWageBuilderOOPs cg = new EmpWageBuilderOOPs("Capgemini", 25, 6, 15);
		EmpWageBuilderOOPs wipro = new EmpWageBuilderOOPs("Wipro", 17, 5, 12);
		cg.calEmpWages();
		wipro.calEmpWages();
		System.out.println(cg);
		System.out.println(wipro);
	}
}
