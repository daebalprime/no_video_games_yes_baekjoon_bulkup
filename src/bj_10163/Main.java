package bj_10163;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[101][101];
		int[] sz = new int[101];
		StringBuilder sb = new StringBuilder();
		for(int id = 1; id <= N; id++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int sx = Integer.parseInt(st.nextToken());
			int sy = Integer.parseInt(st.nextToken());
			int zx = Integer.parseInt(st.nextToken());
			int zy = Integer.parseInt(st.nextToken());
			sz[id] = zx*zy;
			for(int j = 0; j < zy; j++) {
				for(int i = 0; i < zx; i++) {
					int curr = map[sy+j][sx+i];
					if(curr != 0) {
						sz[curr]--;
					}
					map[sy+j][sx+i] = id;
				}
			}
		}
		for(int i = 1; i <= N; i++) {
			sb.append(sz[i]+"\n");
		}
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}

}
