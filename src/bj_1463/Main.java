package bj_1463;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		br.close();
		int[] dp = new int[Math.max(4, N+1)];
		dp[1] = 0;
		dp[2] = 1;
		dp[3] = 1;
		
		System.out.println(dp(dp, N));
	}
	
	static int dp (int[] dp, int curr) {
		if(curr <= 1) return 0;
		else if(dp[curr] != 0) {
			return dp[curr];
		}else {
			dp[curr] = dp(dp, curr-1) + 1;
			if(curr%3 == 0) {
				dp[curr] = Math.min(dp(dp,curr/3) + 1, dp[curr]);
			}
			if(curr % 2 == 0) {
				dp[curr] = Math.min(dp(dp, curr/2)+1, dp[curr]);
			}
		}
		return dp[curr];
	}
}
