package bj_16926;

import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int M;
	static int R;
	static int[][] map;
//	static int[] di = new int[] {0,1,0,-1};
//	static int[] dj = new int[] {1,0,-1,0};
	static int[] di = new int[] {1,0,-1,0};
	static int[] dj = new int[] {0,1,0,-1};
	
	static void rotate(int count, int level, int[][] newMap) {
		int maxLength = 2*((M-2*level) + (N-2*level)) - 4;
		int x = level;
		int y = level;
		int ox = level;
		int oy = level;
		int ori = -1;
		int oori = -1;
		count = count % maxLength;
//		System.out.println(level + " " + count);
		for(int i = 0; i < count+maxLength; i++) {
			if((x == level || x == M-1-level) && (y == level || y == N-1-level)) {
				ori = (ori+1) % 4;
			}
			x += di[ori];
			y += dj[ori];
			if(i >= count) {
				if((ox == level || ox == M-1-level) && (oy == level || oy == N-1-level)) {
					oori = (oori+1) % 4;
				}
				ox += di[oori];
				oy += dj[oori];
				newMap[oy][ox] = map[y][x]; 
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int maxLevel = Math.min(N/2, M/2);
		int newMap[][] = new int[N][M];
		
//		for(int[] ia : map) {
//			for(int i : ia) {
//				System.out.print(i+" ");
//			}
//			System.out.println();
//		}
//		System.out.println("-----------------");
		for(int i = 0; i < maxLevel; i++) {
			rotate(R, i, newMap);
		}
		StringBuilder sb = new StringBuilder();
		for(int[] ia : newMap) {
			for(int i : ia) {
				sb.append(i).append(" ");
			}
			sb.setLength(sb.length()-1);
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
