package bj_1149;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[][] cost = new int[N][3];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			cost[i][0] = Integer.parseInt(st.nextToken()); // R cost
			cost[i][1] = Integer.parseInt(st.nextToken()); // G cost
			cost[i][2] = Integer.parseInt(st.nextToken()); // B cost
		}
		br.close();
		int[][] dp = new int[N][3]; // 마지막 집이 특정 색으로 칠해졌을 때 까지의 최솟값
		
		dp[0][0] = cost[0][0]; // 첫 번째 집이 R 
		dp[0][1] = cost[0][1]; // 첫 번쨰 집이 G
		dp[0][2] = cost[0][2]; 
		
		//처음엔 그리디(피보나치 수열 상향식 DP로 풀기?) 스럽게 생각을 했는데 반례가 있다
		//동적 테이블의 의미 : dp[x][i] : i번 색칠을 시작으로 x번 집까지 칠하는 최소비용
		//점화식 : dp[x][i] <- 칠할 수 있는 색 중에 최소 비용 + dp[x][i-1]
//		int[] currColor = {0,1,2};
//		int[][] nextColor = {{1,2},{2,0}, {0,1}};
//		for(int i = 1; i < N; i++) {
//			int pick0 = Math.min(nextColor[currColor[0]][0], nextColor[currColor[0]][1]);
//			int pick1 = Math.min(nextColor[currColor[1]][0], nextColor[currColor[1]][1]);
//			int pick2 = Math.min(nextColor[currColor[2]][0], nextColor[currColor[2]][1]);
//			dp[i][0] = dp[i-1][0] + cost[i][pick0];
//			dp[i][1] = dp[i-1][1] + cost[i][pick1];
//			dp[i][2] = dp[i-1][2] + cost[i][pick2];
//			currColor[0] = pick0;
//			currColor[1] = pick1;
//			currColor[2] = pick2;
//		}
		
		
		//제약조건 : 인접한 집 색깔이 다르기만 하면 됨
		//마지막 집을 기준으로 다음 색 고르기
		
		/*
		 * 동전 거스름돈 구하기에서 
		 * 현재 시점에서 가능한 선택지 중 최소값을 고르는 데서 아이디어를 얻었음
		 * dp 2차원 배열의 의미 -> i칸에 특정 색을 칠할 때 제약조건을 지키며 최소한의 비용으로 작성
		 * */
		
		int answer = Integer.MAX_VALUE;
		for(int i = 1; i < N; i++) {
			dp[i][0] = cost[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);			
			dp[i][1] = cost[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);			
			dp[i][2] = cost[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
			//색을 먼저 정하고 이전 집의 최솟값 가져오기
		}
		for(int i = 0; i < 3; i++) {
			answer = Math.min(dp[N-1][i], answer);
		}
		System.out.println(answer);
	}
	

	
	//하나의 색을 기준으로 최적을 정하는 것도 출발하는 색깔에 따라 결과가 달라질 수도 있었다.
	//처음 정보 기준으로 최적성을 찾을 수 없다. 
	//DP의 기준을 잡는 것이 어려웠다
	

	

}
