package bj_14889;



import java.io.*;
import java.util.*;

public class Main_combi{
	static int answer = 0;
	static int N = 0;
	static boolean[] visited;
	static int[][] synergy; 
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			synergy = new int[N][N];
			answer = Integer.MAX_VALUE;
			visited = new boolean[N];
			for(int y = 0; y < N; y++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int x = 0; x < N; x++) {
					synergy[y][x] = Integer.parseInt(st.nextToken());					
				}
			}
			//input 값 읽어들이기
			//synergy 값 저장하기
			combi(0,0);
			sb.append(answer);
		}
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
	
	static int calSynergy(int[][] ia, int a1, int a2) { // ingredients.
		return ia[a1][a2]+ia[a2][a1];
	}
	
	static int getDiff() {
		int f1, f2 = f1 = 0;
		for(int i = 0; i < N; i++) {
			for(int j = i+1; j < N; j++) {
				if(visited[i] == true && visited[j] == true) {
					f1 += calSynergy(synergy, i, j);
				}
				else if(visited[i] == false && visited[j] == false) {
					f2 += calSynergy(synergy, i, j);
				}
			}
		}
		return Math.abs(f1-f2);
	}
	
    static void combi(int cnt, int start) {
        if(cnt == N/2) {
            answer = Math.min(answer, getDiff());
            return;
        }
 
        for(int i=start; i<N; i++) {
            if(visited[i] != true) {
                visited[i] = true;
                combi(cnt+1, i+1);
                visited[i] = false;
            }
        }
    }
}
