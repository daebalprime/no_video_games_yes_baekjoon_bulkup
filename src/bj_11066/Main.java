package bj_11066;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int sum = 0;
			int[] chapters = new int[N];
			int[] partialSum = new int[N];
			int[][] dp = new int[N][N];
			for(int i = 0; i < N; i++) {
				chapters[i] = Integer.parseInt(st.nextToken());
				sum+= chapters[i];
				partialSum[i] = sum;
				// can be replaced by any other summation algorithm?
			}
			for(int d = 1; d <= N-1; d++) { // 끝점 - 시작점의 크기
				for(int s = 0; s < N-d; s++) { // 시작점 0부터 가능한 부분까지
					int e = s+d;
					if(dp[s][e] == 0) dp[s][e] = Integer.MAX_VALUE;
					int subSum = partialSum[e]-partialSum[s]+chapters[s];
					for(int b = s; b < e; b++) { // break dp into sub prob
						dp[s][e] = Math.min(dp[s][e], dp[s][b]+dp[b+1][e]+subSum );
					}
				}
			}
			sb.append(Integer.toString(dp[0][N-1])+"\n");
		}		
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
