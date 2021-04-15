package bj_12026;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] street = new int[N];
		String tmp = br.readLine();
		for(int i = 0; i < N; i++) {
			char a = tmp.charAt(i);
			switch(a) {
			case 'B':
				street[i] = 0;
				break;
			case 'O':
				street[i] = 1;
				break;
			case 'J':
				street[i] = 2;
				break;
			}
		}
		int[] dp = new int[N];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for(int i = 0; i < N; i++) {
			if(dp[i] == Integer.MAX_VALUE) continue;
			int curr = street[i];
			int next = (curr+1) % 3;
			
			for(int j = i+1; j < N; j++) {
				if(street[j]==next) {
					dp[j] = Math.min(dp[i] + (j-i)*(j-i), dp[j]);
				}
			}
		}
		System.out.println(dp[N-1] == Integer.MAX_VALUE?-1:dp[N-1]);
		br.close();
	}

}
