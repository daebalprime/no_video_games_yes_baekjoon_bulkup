package bj_1676;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		if(N<= 1) {
			System.out.println(0);
			return;
		}
		br.close();
		BigInteger num = new BigInteger("1");
		for(int i = 2; i <= N; i++) {
			num = num.multiply(new BigInteger(Integer.toString(i)));
		}
		int answer = 0;
		String x = num.toString();
		for(int i = x.length()-1; i >= 0; i--) {
			if(x.charAt(i)=='0') {
				answer++;
			}else {
				break;
			}
		}
		System.out.println(answer);
	}
}
