package bj_9461;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		long dp[] = new long[101];
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;
		dp[4] = 2;
		dp[5] = 2;
		dp[6] = 3;
		int t = 6;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			int X = Integer.parseInt(br.readLine());
			for(; t<=X; t++) {
				dp[t] = dp[t-1] + dp[t-5];
			}
			sb.append(dp[X]+"\n");
		}
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
