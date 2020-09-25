package com.cg_ewb1;

public class EmpWageBuilderOOPs {

	public static final int IS_PART_TIME = 1;
	public static final int IS_FULL_TIME = 2;
	public static final int EMP_RATE_PER_HOUR = 20;
	public static final int NUM_OF_WORKING_DAYS = 2;

	public static void main(String[] args) {

		int empHrs = 0;
		int empWage = 0;
		int totalEmpWages = 0;
		int day = 0;
		while (day != NUM_OF_WORKING_DAYS) {
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
			empWage = empHrs * EMP_RATE_PER_HOUR;
			totalEmpWages += empWage;
			System.out.println("Emp Wage: " + empWage);
			day++;
		}
		System.out.println("Total Emp Wages: " + totalEmpWages);

	}
}
