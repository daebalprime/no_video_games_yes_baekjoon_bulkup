package bj_14502;

import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int M;
	static int[][] map;
	static int mark;
	static int safety;
	static ArrayList<int[]> virus;
	static ArrayList<int[]> candidate;
	static int answer = 0;
	static int[] di = {1,0,-1,0};
	static int[] dj = {0,-1,0,1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		mark = 3;
		safety = N*M;
		virus = new ArrayList<>();
		candidate = new ArrayList<>();
		
		for(int j = 0; j < N; j++) {
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < M; i++) {
				String tmp = st.nextToken();
				if(tmp.equals("1")) {
					map[j][i] = 1;
					--safety;
				}
				else if(tmp.equals("2")) {
					virus.add(new int[] {i,j});
					map[j][i] = 2;
					--safety;
				}
				else {
					candidate.add(new int[] {i,j});
				}
			}
		}
		
		comb(0,0,new int[3]);
		
		for(int i = 0; i < N; i++) {
		}
		br.close();
		System.out.println(answer);
	}
	
	static void comb(int cnt, int start, int[] picks) {
		if(cnt == 3) {
//			System.out.println(Arrays.toString(picks));
			simulate(picks);
			return;
		}
		for(int i = start; i < candidate.size(); i++) {
			picks[cnt] = i;
			comb(cnt+1, i+1, picks);
		}
	}
	
	static void simulate(int[] picks) {
		int local = safety;
		Queue<int[]> q = new LinkedList<int[]>();
		for(int p : picks) {
			int[] newWall = candidate.get(p);
			map[newWall[1]][newWall[0]] = mark;
			--local;
		}
		for(int[] v : virus) {
			q.offer(v);
			while(!q.isEmpty()) {
				int[] curr = q.poll();
				for(int i = 0; i < 4; i++) {
					int nx = curr[0] + di[i];
					int ny = curr[1] + dj[i];
					if(nx < 0 || nx >= M || ny < 0 || ny >= N || map[ny][nx] == mark
							|| map[ny][nx] == 1 || map[ny][nx] == 2) continue;
					map[ny][nx] = mark;
					--local;
					q.offer(new int[] {nx,ny});
				}
			}
		}
//		System.out.println(local);
//		if(local > answer)System.out.println("results " + local + " : " + answer);
		answer = Math.max(local, answer);
		mark++;
	}
}
