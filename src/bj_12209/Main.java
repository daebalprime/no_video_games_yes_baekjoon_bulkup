package bj_12209;
import java.io.*;
import java.util.*;

public class Main {
	static int tc; 
	static int size = 10;
	static int[] di = {1,-1,0,0};
	static int[] dj = {0,0,1,-1};
	static int[][] orgMap;
	static int N, answer;
	public static void main(String[] args) throws Exception{
//		N = 4;
//		orgMap = new int[][] {{2,2,2,4}, {2,0,2,4}, {4,8,4,0}, {0,0,0,0}};
//		int[] od = new int[] {0,1,0,3,0};
//		for(int i : od) {
//			for(int[] ia : orgMap) {
//				System.out.println(Arrays.toString(ia));
//			}
//			System.out.println();
//			calculate(i,orgMap);
//		}
//		for(int[] ia : orgMap) {
//			System.out.println(Arrays.toString(ia));
//		}
//		System.exit(0);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int ori = 0;
			switch (st.nextToken()) {
			case "right":
				ori = 0;
				break;
			case "up":
				ori = 3;
				break;
			case "down":
				ori = 2;
				break;
			case "left":
				ori = 1;
				break;
			default:
				break;
			}
			orgMap = new int[N][N];
			answer = 0;
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					orgMap[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			calculate(ori, orgMap);
			StringBuilder sb = new StringBuilder();
			sb.append("Case #"+tc+":\n");
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					sb.append(orgMap[i][j]+" ");
				}
				sb.setLength(sb.length()-1);
				sb.append("\n");
			}
			
			bw.write(sb.toString());
		}
		br.close();
		bw.flush();
		bw.close();
	}

	static void calculate(int ori, int[][]map) {
		int tx = di[ori];
		int ty = dj[ori];
		int startX = 0;
		int startY = 0;
		
		
		if(tx == 1) startX = N-1;
		else if(tx == -1) startX = 0;
		if(ty == 1) startY = N-1;
		else if(ty == -1) startY = 0;
		
		if(tx != 0) { // 좌우로
			for(int j = 0; j < N; j++) {
				int itr = startX;
				int prev = 0;
				for(int i = startX; i >= 0 && i < N; i-=tx) {
					if(map[j][i] != 0) {
						if(prev == map[j][i]) {
							itr += tx;
							map[j][itr] = map[j][i]*2;
							prev = 0;
						}else {
							prev = map[j][i];
							map[j][itr] = map[j][i];
						}
						if(itr != i) map[j][i] = 0;
						itr -= tx;
					}
				}
			}
		}
		else { // 상하로
			for(int i = 0; i < N; i++) {
				int itr = startY;
				int prev = 0;
				for(int j = startY; j >= 0 && j < N; j-=ty) {
					if(map[j][i] != 0) {
						if(prev == map[j][i]) {
							itr += ty;
							map[itr][i] = map[j][i]*2;
							prev = 0;
						}else {
							prev = map[j][i];
							map[itr][i] = map[j][i];
						}
						if(itr != j) map[j][i] =0;
						itr -= ty;
					}
				}
			}
		}
	}
}