package Test1;

import sun.print.resources.serviceui;

public class Printf {

    public Printf() {
	// TODO Auto-generated constructor stub
    }

    public static void main(String[] args) {
	
	//1st arg - format string next args - objects for format
	//1$s == first input object
	
	System.out.printf("1st object String: %s\n"
		+ "second obj float %.2f:\n"
		+ "third==first string:%1$s\n", "FIRST",233.456789);
	//System.out.printf("12%3$.3f\n","13%1$S","14%1$s");
	System.out.printf("12%1s\n","13%1$S","14%1$s");
	//System.out.println("\n");	
	
	//System.out.printf("12%1$s","AAAA");
	
	String s="sri";
	      switch(s){
	        case "SRI": System.out.print("SRI LANKA ");
	        case "Sri": System.out.print("Sri Lanka ");
	        case "sri": System.out.print("sri lanka ");
	        case "sRI": System.out.print("sRI lANKA ");
	        default: System.out.print("www.lanka.lk");
	      }
	      
	
    }

}
