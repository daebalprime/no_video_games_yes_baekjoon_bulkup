package bj_1003;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		
		int[][] dp = new int[41][2];
		int dpc = 2;
		dp[0][0] = 1;
		dp[0][1] = 0;
		dp[1][0] = 0;
		dp[1][1] = 1;
		dp[2][0] = 1;
		dp[2][1] = 1;
		
		for(int tc = 0; tc < N; tc++) {
			int X = Integer.parseInt(br.readLine());
			for(int i = dpc-2; i <= X-2; i++) {
				dp[i+2][0] = dp[i][0] + dp[i+1][0];
				dp[i+2][1] = dp[i][1] + dp[i+1][1];
				dpc = i+2;
			}
			bw.write(dp[X][0]+ " " + dp[X][1]+"\n");
		}
		StringBuilder sb = new StringBuilder();
		br.close();
		bw.close();
	}

}
