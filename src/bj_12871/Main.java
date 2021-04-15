package bj_12871;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine();
		String b = br.readLine();
		int lenA = a.length();
		int lenB = b.length();
		int lenC = lenA*lenB/gcd(lenA, lenB); 
		for(int i = 0; i < lenC; i++) {
			if(a.charAt(i%lenA) != b.charAt(i%lenB)) {
				System.out.println(0);
				return;
			}
		}
		System.out.println("1");
	}
	
	static int gcd(int a, int b) {
		if (b == 0)return a;
	    else return gcd(b, a % b);
	}
}
