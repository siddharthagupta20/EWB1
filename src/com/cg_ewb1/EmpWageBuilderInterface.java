package com.cg_ewb1;

public interface EmpWageBuilderInterface {
	public void addCompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maxHoursPerMonth);

	public void computeEmpWage();

	public int computeEmpWage(CompanyEmpWage compEmpWage);

}
