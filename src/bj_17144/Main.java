package bj_17144;

import java.io.*;
import java.util.*;

public class Main {
	static int R, C, T, remained;
	static int dust;
	static int[][] purifier;
	static int[][] map;
	static int[] di = {0,1,0,-1};
	static int[] dj = {-1,0,1,0}; // counterclockwise
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		dust = 0;
		purifier = new int[2][2];
		int pCnt = 0;
		for(int j = 0; j < R; j++) {
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < C; i++) {
				map[j][i] = Integer.parseInt(st.nextToken());
				if(map[j][i] == -1) {
					purifier[pCnt][0] = i;
					purifier[pCnt++][1] = j;
				}
				else {
					dust += map[j][i];
				}
			}
		}
		for(int x = 0; x < T; x++) {
			//확산
			diffusion();
//			for(int[] ia : map) {
//				System.out.println(Arrays.toString(ia));
//			}
			purify();
//			for(int[] ia : map) {
//				System.out.println(Arrays.toString(ia));
//			}
			//공청기 가동
		}
		System.out.println(dust);
		br.close();
	}
	static void purify() {
		//upper -> counterclockwise
		int ux = purifier[0][0];
		int uy = purifier[0][1];
		int ori = uy == 0 ? 1 : 0;
		int px = ux;
		int py = uy;
		while(true) {
			int nx = px + di[ori];
			int ny = py + dj[ori];
			if(nx == ux && ny == uy) break;
			
			if((nx == 0 && ny == 0) || (nx == C-1 && ny == 0) || (nx == C-1 && ny == uy)) {
				ori++;
			}
			if(px == ux && py == uy) {
				dust -=map[ny][nx]; 
				map[ny][nx] = 0;
			}else {
				int tmp = map[ny][nx];
				map[ny][nx] = map[py][px];
				map[py][px] = tmp;
			}
			px = nx;
			py = ny;
		}
		//lower -> clockwise
		int lx = purifier[1][0];
		int ly = purifier[1][1];
		ori = ly == R-1 ? 1 : 2;
		px = lx;
		py = ly;
		while(true) {
			int nx = px + di[ori];
			int ny = py + dj[ori];
			if(nx == lx && ny == ly) break;
			
			if((nx == C-1 && ny == ly) || (nx == 0 && ny == R-1) || (nx == C-1 && ny == R-1)) {
				ori = (ori+4-1)%4;
			}
			if(px == lx && py == ly) {
				dust -=map[ny][nx];
				map[ny][nx] = 0;
			}else {
				int tmp = map[ny][nx];
				map[ny][nx] = map[py][px];
				map[py][px] = tmp;
			}
			px = nx;
			py = ny;
		}
	}
	static void diffusion() {
		int[][] next = new int[R][C];
		next[purifier[0][1]][purifier[0][0]] = -1;
		next[purifier[1][1]][purifier[1][0]] = -1;
		for(int j = 0; j < R; j++) {
			for(int i = 0; i < C; i++) {
				int curr = map[j][i];
				if(curr > 0) {
					int part = curr/5;
					for(int k = 0; k < 4; k++) {
						int nx = i+di[k];
						int ny = j+dj[k];
						if(nx >= 0 && nx < C && ny >= 0 && ny < R && next[ny][nx] != -1) {
							next[ny][nx] += part;
							curr -= part;
						}
					}
					next[j][i] += curr;
				}
			}
		}
		map = next;
	}

}
