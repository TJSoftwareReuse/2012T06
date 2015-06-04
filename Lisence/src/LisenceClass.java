
public class LisenceClass {
	private static int TotalService = 10;
	public static int UsedService = 0;
	
	public LisenceClass() {		
	}
	
	public int totalService()
	{
		return TotalService;
	}

	public int usedService()
	{
		return UsedService;
	}

	public int restService()
	{
		int rest = TotalService - UsedService;
		return rest;
	}

	public void resetLisenceNum(int newNum)
	{
		UsedService = 0;
		TotalService = newNum;
		System.out.println("Lisence number changed to: "+ newNum);
		System.out.println("Used lisence number has reset to 0");
	}
	
	public boolean useLisence() {
		if(UsedService < 10){
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
