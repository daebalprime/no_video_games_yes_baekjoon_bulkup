package bj_7576;

import java.io.*;
import java.util.*;

public class Main {
	static int[] di = {0,0,-1,1};
	static int[] dj = {-1,1,0,0};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		int remained = N*M;
		int t = 0;
//		int N = Integer.parseInt(br.readLine());
		LinkedList<int[]>[] niceTomato = new LinkedList[2];
		niceTomato[0] = new LinkedList<>();
		niceTomato[1] = new LinkedList<>();
		int list = 0;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					niceTomato[0].offer(new int[] {j,i});
					remained--;
				}
				else if(map[i][j] == -1) {
					remained--;
				}
				else {
					t++;
				}
			}
		}
		if(remained == 0 && t== 0) {
			System.out.println("0");
			return;
		}
		if(remained == 0) {
			System.out.println("-1");
			return;
		}
		
		int answer = 0;
		while(remained > 0) {
			int currlist = list;
			int nextlist = (list+1)%2;
			if(niceTomato[currlist].isEmpty() && niceTomato[nextlist].isEmpty()) {
				answer = -1;
				break;
			}
			while(!niceTomato[currlist].isEmpty()) {
				int[] curr = niceTomato[currlist].poll();
				int x = curr[0], y = curr[1];
				for(int k = 0; k < 4; k++) {
					int nx = x+di[k];
					int ny = y+dj[k];
					if(nx >= 0 && nx < M && ny >= 0 && ny < N && map[ny][nx]==0) {
						map[ny][nx]=1;
						niceTomato[nextlist].offer(new int[] {nx,ny});
						remained--;
					}
				}
			}
			list = (list+1)%2;
			answer++;
		}
		System.out.println(answer);
		br.close();
	}

}
