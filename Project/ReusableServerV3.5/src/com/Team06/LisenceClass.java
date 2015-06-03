package com.Team06;


public class LisenceClass {
	private static int TotalService = 10;
	public static int UsedService = 0;
	
	public LisenceClass() {		
	}
	
	public void resetLisenceNum(int newNum)
	{
		UsedService = 0;
		TotalService = newNum;
		System.out.println("Lisence number changed to: "+ newNum);
		System.out.println("Used lisence number has reset to 0");
	}
	
	public boolean useLisence() {
		if(UsedService < TotalService){
			UsedService += 1;
			System.out.println("service has been used for: "+UsedService+" times.");
			return true;
		}
		else {
			System.out.println("Service invalid: U have run out of service(10 times)");
			return false;
		}
	}
}
