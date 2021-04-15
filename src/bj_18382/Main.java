package bj_18382;


import java.io.*;
import java.util.*;

public class Main {
	static int tc; 
	static int[] di = {1,-1,0,0}; // R L D U
	static int[] dj = {0,0,1,-1};
	static int[][] orgMap;
	static int N;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int score = Integer.parseInt(br.readLine());
		String cmd = br.readLine();
		N = 4;
		StringTokenizer st = new StringTokenizer(br.readLine());
		orgMap = new int[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				orgMap[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0; i < cmd.length(); i+=4) {
			char o = cmd.charAt(i);
			int ori = 0;
			if(o=='L') {
				ori = 1;
			}
			else if(o=='D') {
				ori = 2;
			} 
			else if(o=='U') {
				ori = 3;
			}
			else {
				ori = 0;
			}
			score += calculate(ori, orgMap);
			int newb = cmd.charAt(i+1)-'0';
			int y = cmd.charAt(i+2)-'0';
			int x = cmd.charAt(i+3)-'0';
			orgMap[y][x] = newb;
		}
		System.out.println(score);

	}

	static int calculate(int ori, int[][]map) {
		int tx = di[ori];
		int ty = dj[ori];
		int startX = 0;
		int startY = 0;
		
		int ret = 0;
		
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
							ret += map[j][i]*2;
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
							ret += map[j][i]*2;
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
		return ret;
	}
}
