package com.example.demo.util;

public class CheckRR {

	public static String check(String rr_no) {
		String res = rr_no;
		int []arr=new int[13];
		for (int i = 0; i < 13; i++) {
			arr[i]=res.charAt(i)-48;
		}
		int sum=0;
		for (int i = 0; i < 12; i++) {		
			if((i)>7) {
				sum=sum+((i-6)*arr[i]);
			}else {
				sum=sum+((i+2)*arr[i]);
			}			
		}
		int l=(11-sum%11)%10;
		
		String re = "";
		if(l==arr[12]) {
			re = "o";
		}else {
			re = "x";
		}
		
		return re;
	}
}
