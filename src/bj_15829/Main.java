package bj_15829;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		int N = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(br.readLine());
		BigInteger x = new BigInteger("0");
		String str = br.readLine();
		for(int i = 0; i < N; i++) {
			int tmp = str.charAt(i)-'a'+1;
			BigInteger a = new BigInteger(Integer.toString(tmp));
			BigInteger b = new BigInteger("31").pow(i);
			BigInteger c = a.multiply(b);
			x = x.add(c);
		}
		x = x.mod(new BigInteger("1234567891"));
		StringBuilder sb = new StringBuilder();
		sb.append(x.toString());
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}

}
