package bj_11403;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
//		int[][] result = new int[N][N];
		for(int k = 0; k < N; k++) {
			for(int i = 0; i < N; i++) {
//				if(i==k) continue;
				for(int j = 0; j < N; j++) {
//					if(j==k || j == i) continue;
					if(map[i][k]==1 && map[k][j] ==1) {
						map[i][j] = 1;
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++){
				sb.append(map[i][j]+" ");
			}
			sb.setLength(sb.length()-1);
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}

}
