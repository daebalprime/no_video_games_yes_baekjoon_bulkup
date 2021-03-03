package bj_17626;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N+1];
		dp[1] = 1;
		for(int i = 2; i <= N; i++) {
			if(Math.sqrt(i)%1 > 0) { // is not square
				int sqrt = (int)(Math.sqrt(i)/1);
				int x = i - sqrt*sqrt;
				int min = 1 + dp[x];
				int k = sqrt-1;
					while(true) {
						int tmp = i - k*k;
						if(tmp < 1 || k == 0) break;
						min = Math.min(min, dp[tmp]+1);
						if(min == 2) break;
						k--;
					}
				dp[i] = min;
//				System.out.println(i + " : " + dp[i]);
			}
			else {
				dp[i] = 1;
			}
		}
		System.out.println(dp[N]);
		br.close();
	}

}
 