
public class LisenceClass {
	private static int TotalService = 10;
	public static int UsedService = 0;
	
	public LisenceClass() {		
	}
	
	public void useLisence() {
		if(UsedService < 10){
			UsedService += 1;
			System.out.println("service has been used for: "+UsedService+" times.");
		}
		else {
			System.out.println("Service invalid: U have run out of service(10 times)");
		}
	}
}
