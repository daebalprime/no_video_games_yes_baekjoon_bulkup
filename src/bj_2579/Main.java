package bj_2579;

import java.io.*;
import java.util.*;

public class Main {
	static long answer = 0;
	static int N;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		int max = Integer.MIN_VALUE;
		int[] scores = new int[N];
		int[] dp = new int[N];
		for(int i = 0; i < N; i++) {
			scores[i] = Integer.parseInt(br.readLine());
		}
		if(N == 1) {
			System.out.println(scores[0]);
			return;
		}else if(N==2) {
			System.out.println(scores[0]+scores[1]);
			return;
		}
		br.close();
		dp[0] = scores[0];
		dp[1] = Math.max(scores[1], scores[0]+scores[1]);
		dp[2] = Math.max(scores[0]+scores[2], scores[1]+scores[2]);
		for(int i = 3; i < N; i++) {
			dp[i] = Math.max(dp[i-2] + scores[i], dp[i-3]+scores[i-1]+scores[i]);
		}
		System.out.println(dp[N-1]);
	}
}
