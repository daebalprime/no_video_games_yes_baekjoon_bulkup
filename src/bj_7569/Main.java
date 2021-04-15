package bj_7569;

import java.io.*;
import java.util.*;

public class Main {
	static int[] di = {0,0,-1,1,0,0};
	static int[] dj = {-1,1,0,0,0,0};
	static int[] dk = {0,0,0,0,1,-1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int[][][] map = new int[H][N][M];
		int remained = N*M*H;
        int t = 0;
//		int N = Integer.parseInt(br.readLine());
		LinkedList<int[]>[] niceTomato = new LinkedList[2];
		niceTomato[0] = new LinkedList<>();
		niceTomato[1] = new LinkedList<>();
		int list = 0;
		for(int k = 0; k < H; k++) {
			for(int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for(int i = 0; i < M; i++) {
					map[k][j][i] = Integer.parseInt(st.nextToken());
					if(map[k][j][i] == 1) {
						niceTomato[0].offer(new int[] {i,j,k});
						remained--;
					}
					else if(map[k][j][i] == -1) {
						remained--;
					}
					else{
						t++;
					}
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
				int x = curr[0], y = curr[1], z = curr[2];
				for(int k = 0; k < 6; k++) {
					int nx = x+di[k];
					int ny = y+dj[k];
					int nz = z+dk[k];
					if(nx >= 0 && nx < M && ny >= 0 && ny < N && nz >= 0 && nz < H && map[nz][ny][nx]==0) {
						map[nz][ny][nx]=1;
						niceTomato[nextlist].offer(new int[] {nx,ny,nz});
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
