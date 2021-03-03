package bj_9095;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] dp = new int[12];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for(int i = 4; i <= 11; i++) {
			dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
		}
//		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < T; tc++) {
			System.out.println(dp[Integer.parseInt(br.readLine())]);
		}
		br.close();
	}

}
