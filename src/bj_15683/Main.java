package bj_15683;

import java.io.*;
import java.util.*;

public class Main {
	static int[][][][] cctvWatching = {
			{{{}},{{}}},
			{{{1},{0},{-1},{0}}, {{0},{1},{0},{-1}}},
			{{{1,-1},{0, 0}}, {{0, 0},{1, -1}}},
			{{{1,0},{-1,0},{-1,0},{1,0}},{{0,-1},{0,-1},{0,1},{0,1}}},
			{{{1,0,-1},{0,-1,0},{-1,0,1},{0,1,0}},{{0,-1,0},{-1,0,1},{0,1,0},{1,0,-1}}},
			{{{1,0,-1,0}},{{0,1,0,-1}}}
	};
	
	//[type][x or y][ranges][rotate]
	//[cctv의 종류][x축 or y축][한 번의 감시에 가능한 모든 방향][각 방향]
	
	static int mark = 7; // 빈공간, cctv 등 의미있는 숫자의 범위가 0~6
	static int blank, cctvCounts = 0;
	static int answer = Integer.MAX_VALUE;
	static int N, M;
	static int[][] cctv, map;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		blank = N*M; // 전체 빈 공간의 갯수
		cctv = new int[8][3]; // [cctv 번호][0->x 1->y 2->cctv 종류]
		cctvCounts = 0; // cctv 갯수
		
		for(int j = 0; j < N; j++) {
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < M; i++) {
				int tmp = Integer.parseInt(st.nextToken());
				map[j][i]= tmp;
				if(tmp >= 1 && tmp <= 5) {
					cctv[cctvCounts++] = new int[] {i,j,tmp};
				}
				if(tmp != 0) --blank;
				// 벽 혹은 cctv가 존재한다면 빈 공간 카운트에서 1을 빼줘야함
			}
		}
		
		recursive(0, new int[cctvCounts]); // 중복순열
		System.out.println(answer);
		
		
		br.close();
	}
	
	static void recursive(int idx, int[] picks) {
//		if(answer == 0) return; //백트래킹,
		if(idx == cctvCounts) {
			answer = Math.min(remained(picks),answer);
			//remained() 메서드 호출-> 사각지대 계산 후 answer 갱신
			return;
		}
		int type = cctv[idx][2];
		int comb = cctvWatching[type][0].length;
		//comb -> 각 cctv가 회전으로 만들어 낼 수 있는 가짓수
		//[cctv의 종류][x축 or y축][한 번의 감시에 가능한 모든 방향][각 방향]
		
		for(int i = 0; i < comb; i++) {
			picks[idx] = i;
			recursive(idx+1, picks);
		}
		
	}
	
	static int remained(int[] picks) {
		int ret = blank; // 빈 공간
		for(int i = 0; i < cctvCounts; i++) {
			//[cctv의 종류][x축 or y축][한 번의 감시에 가능한 모든 방향][각 방향]
			int ori = picks[i]; // 현재 CCTV의 회전
			int type = cctv[i][2]; // 현재 cctv의 타입
			int[] di = cctvWatching[type][0][ori]; // 감시하는 방향의 배열
			int[] dj = cctvWatching[type][1][ori]; 
			for(int j = 0; j < di.length; j++) { 
				int nx = cctv[i][0], ny = cctv[i][1];
				while(true) {
					ny += dj[j];
					nx += di[j];
					if(ny < 0 || ny >= N || 
							nx < 0 || nx >= M  // 맵 범위체크
							|| map[ny][nx]==6) break; // 만약 벽이라면?
					if(map[ny][nx] == 0 || map[ny][nx] > 6 // 해당 공간이 비었을 경우 
							&& map[ny][nx] != mark) { //다른 CCTV가 감시하고 있지 않을 경우
						map[ny][nx] = mark; // cctv 감시중인 영역이라고 표시
						ret--;
					}
				}
			}
		}
		mark++; // map 재활용을 하지 않기 위하여 mark ++
		print();
		return ret;
	}
	
	static void print() { // for debugging & visualization
		for(int[] ia : map) {
			System.out.println(Arrays.toString(ia));
		}
		System.out.println("------------------------");
	}

}
