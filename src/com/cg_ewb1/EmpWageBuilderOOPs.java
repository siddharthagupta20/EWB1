package com.cg_ewb1;
import java.util.Random;
public class EmpWageBuilderOOPs {
	static int IS_FULL_TIME = 1;

	public static void main(String[] args) {
		Random rand=new Random();
		
		int  empCheck =rand.nextInt(2);
		if (IS_FULL_TIME == empCheck) {
			System.out.println("The employee is present.");
		} else
			System.out.println("The employee is absent.");
	}
}
