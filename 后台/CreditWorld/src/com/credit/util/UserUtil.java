package com.credit.util;

public class UserUtil {
	
	public static String divideStr(String str){
		if(str != null){
			String[] temp = str.split("_");
			return temp[0];
		}
		return "";
	}
	
	public static double divideStrForMask(String str){
		double mask = 0;
		if(str != null){
			String[] temp = str.split("_");
			if(temp.length > 0)
				mask = Double.parseDouble(temp[1]);
		}
		return mask;
	}
}
