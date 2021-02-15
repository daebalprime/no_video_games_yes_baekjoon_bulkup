package bj_2609;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int gcd = GCD(Math.max(N, M), Math.min(N, M));
		StringBuilder sb = new StringBuilder();
		sb.append(gcd+"\n");
		sb.append(N/gcd*M+"\n");
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
	
	static int GCD(int a, int b) {
		if(b == 0) return a;
		return GCD(b, a%b);
	}

}
