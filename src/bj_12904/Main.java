package bj_12904;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String A = br.readLine();
		String B = br.readLine();
		int left = 0; 
		int right = B.length()-1;
		boolean flag = true;
		while(right-left+1 != A.length()) {
			if(flag) { // right
				if (B.charAt(right--) == 'B') {
					flag = false;
				}
			}
			else {
				if(B.charAt(left++)=='B') {
					flag = true;
				}
			}
		}
//		System.out.println();
		String result = B.substring(left,right+1);
		if(!flag) {
			StringBuilder sb = new StringBuilder(result);
			sb.reverse();
			result = sb.toString();
		}
		System.out.println(result);
		if(result.equals(A)) System.out.println(1);
		else System.out.println(0);
	}

}
