package bj_11727;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[Math.max(2, N)];
		dp[0] = 1;
		dp[1] = 3;
		for(int i = 2; i < N; i++) {
			dp[i] = (dp[i-2]*2+ dp[i-1])%10007; 
		}
		System.out.println(dp[N-1]);
	}

}
