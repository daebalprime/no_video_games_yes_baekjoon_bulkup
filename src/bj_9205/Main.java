package bj_9205;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= T; tc++) {
			int C = Integer.parseInt(br.readLine()); // 편의점 갯수
			int[][] coord = new int[C+2][2]; //집(0)-편의점들-목표(C+1)
			int[][][] dp = new int[C+2][C+2][2];
			
			StringTokenizer st = null;
			for(int i = 0; i < C+2; i++) {
				st = new StringTokenizer(br.readLine());
				coord[i][0] = Integer.parseInt(st.nextToken());
				coord[i][1] = Integer.parseInt(st.nextToken());
				for(int j = 0; j < i; j++) {
					int dist = getDist(coord[i], coord[j]);
					if(dist <= 1000) {						
						dp[i][j][0] = dist;
						dp[j][i][0] = dist;
						dp[i][j][1] = 1;
						dp[j][i][1] = 1;
					}
					else {
						dp[i][j][0] = Integer.MAX_VALUE;
						dp[j][i][0] = Integer.MAX_VALUE;						
					}
				}
			}
			
			for(int k = 0; k < C+2; k++) {
				for(int i = 0; i < C+2; i++) {
					if(i==k) continue;
					for(int j = 0; j < C+2; j++) {
						if(j==k || j==i) continue;
						if(dp[i][j][0] > dp[i][k][0]+dp[k][j][0]
								&& isPossible(dp[i][k])
								&& isPossible(dp[k][j])) {
							
							dp[i][j][0] = dp[i][k][0]+dp[k][j][0];
							dp[i][j][1] = dp[i][k][1]+dp[k][j][1];
						}else if(dp[i][j][0] == dp[i][k][0]+dp[k][j][0]
								&& isPossible(dp[i][k])
								&& isPossible(dp[k][j])) {
							dp[i][j][1] = Math.max(dp[i][k][1]+dp[k][j][1], dp[i][j][1]);
						}
					}
				}
			}
//			System.out.println(Arrays.toString(dp[0][C+1]));
			sb.append((isPossible(dp[0][C+1])? "happy" : "sad")+"\n");
		}
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
	static int getDist(int[] a, int[] b) {
		return Math.abs(a[0]-b[0])+Math.abs(a[1]-b[1]);
	}
	
	static boolean isPossible(int[] path) {
		if(path[0] <= path[1]*1000) return true; 
		return false;
	}

}
/*
3
0
1000 1000
1000 1001
1
0 0
1000 0
0 2000
2
0 0
10000 0
0 1000
0 2000

정답:
happy
sad
happy


1
1
1000 0
0 1000
0 1001

정답: sad

1
1
0 0
9999 9999
0 1

output: sad
answer: happy

1
0
0 0
1000 0
output:
happy

2
2
0 0
1000 0
1000 1000
2000 1001
2
0 0
1000 0
2000 1000
2000 2000

sad
sad

1
2
0 0
0 1001
1 1
1000 1001

sad

입력:
3
0
1000 1000
1000 1001
1
0 0
1000 0
0 2000
2
0 0
10000 0
0 1000
0 2000

정답:
happy
sad
happy
 * */
