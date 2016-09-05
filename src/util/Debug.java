package util;

public class Debug{
	private static int debug=0;
	
	public Debug(){
	}
	
	public static void setDebugOn(){
		debug = 1;
	}
	public static void setDebugOff(){
		debug = 0;
	}
	public static void print(String text){
		if(debug == 1){
			System.out.println(text);
		}
	}

}
