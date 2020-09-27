package com.cg_ewb1;

import java.util.ArrayList;

public class CompanyEmpWage {
	public final String company;
	public final int empRatePerHour;
	public final int numOfWorkingDays;
	public final int maxHoursPerMonth;
	public int totalEmpWage;
	public ArrayList<Integer> dailyWages;

	public CompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maxHoursPerMonth) {

		this.company = company;
		this.empRatePerHour = empRatePerHour;
		this.numOfWorkingDays = numOfWorkingDays;
		this.maxHoursPerMonth = maxHoursPerMonth;
		dailyWages = new ArrayList<>();

	}

	public void setTotalEmpWage(int totalEmpWage) {
		this.totalEmpWage = totalEmpWage;
	}

	public void computeDailyWages() {
		for (Integer dailyWage : dailyWages) {
			System.out.println("Daily Wages for company :" + company + ": are:  " + dailyWage);
		}

	}

	@Override
	public String toString() {
		return "Total Emp Wage for Company : " + company + " is: " + totalEmpWage;
	}
}