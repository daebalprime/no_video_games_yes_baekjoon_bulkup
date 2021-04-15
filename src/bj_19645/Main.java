package bj_19645;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] burgers = new int[N+1];
		int sum = 0;
		for(int i = 1; i < N+1; i++) {
			burgers[i] = Integer.parseInt(st.nextToken());
			sum+= burgers[i];
		}
		long[][][] dp = new long[3][N+1][sum+1];
		for(int j = 1; j < N+1; j++) {
			for(int i = 1; i < sum+1; i++) {
				if(burgers[j] > i) dp[0][j][i] = dp[0][j-1][i];
				else {
					if(dp[0][j-1][i]%4096 < dp[0][j-1][i-burgers[j]]%4096+burgers[j]) {
						dp[0][j][i] = dp[0][j-1][i-burgers[j]]+burgers[j];
						dp[0][j][i] |= 2048<<j;
					}else {
						dp[0][j][i] = dp[0][j-1][i];
					}
				}
			}
		}
		
//		for(int k = 0; k <= 2
		for(int j = 0; j < sum+1; j++) {
			System.out.println(j + " ==================");
			for(int i = 0; i < 3; i++) {
				long x = dp[i][N][j];
				System.out.print(Long.toBinaryString(x/4096)+" ");
				System.out.println(x%4096);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}

}
