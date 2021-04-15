package bj_13706;

import java.io.*;
import java.math.BigInteger;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BigInteger N = new BigInteger(br.readLine());  
		br.close();
		BigInteger TWO = new BigInteger("2");
		BigInteger left = new BigInteger("1");
		BigInteger right = N.divide(TWO);
		
		
		while(true) {
			BigInteger mid = left.add(right).divide(TWO);
			BigInteger square = mid.multiply(mid);
			if(square.equals(N)) {
				System.out.println(mid.toString());
				return;
			}
			else if(square.compareTo(N) == -1) {
				left = mid.add(BigInteger.ONE);
			}
			else {
				right = mid.subtract(BigInteger.ONE);
			}
		}

	}

}
