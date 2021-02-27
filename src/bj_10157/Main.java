package bj_10157;

import java.io.*;
import java.util.*;

public class Main {
	static int[] di = {0,1,0,-1};
	static int[] dj = {1,0,-1,0};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		int[][] map = new int[H][W];
		if(W*H < K) {
			System.out.println("0");
			return;
		}
		int x = 0;
		int y = 0;
		map[0][0] = 1;
		
		int ori = 3;
		for(int i = 2; i <= K; i++) {
			if((x == 0 || x == W-1) && (y == 0 || y == H-1) ||
					(map[y+dj[ori]][x+di[ori]] != 0)) {
				ori= (ori+1)%4;
			}
			
			x += di[ori];
			y += dj[ori];
			map[y][x] = i;
		}
		
		System.out.println((x+1)+ " " + (y+1));
		br.close();
	}

}
