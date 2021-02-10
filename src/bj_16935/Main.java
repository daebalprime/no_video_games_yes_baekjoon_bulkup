package bj_16935;
import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int M;
	static int OPC; //operation count
	static int[][] map;
	static int[] di = {0, 1, 1, 0};
	static int[] dj = {0, 0, 1, 1};
	
	public static void oper1() {
		for(int i = 0; i < N/2; i++) {
			int[] temp = map[i];
			map[i] = map[N-1-i];
			map[N-1-i] = temp;
		}
	}
	
	public static void oper2() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M/2; j++) {				
				int temp = map[i][j];
				map[i][j] = map[i][M-1-j];
				map[i][M-1-j] = temp;
			}
		}
	}
	
	public static void oper3() {
		int[][] newmap = new int[M][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {				
				newmap[j][N-1-i] = map[i][j];
			}
		}
		map = newmap;
		int tmp = N;
		N = M;
		M = tmp;
	}
	
	public static void oper4() {
		int[][] newmap = new int[M][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {				
				newmap[M-1-j][i] = map[i][j];
			}
		}
		map = newmap;
		int tmp = N;
		N = M;
		M = tmp;
	}
	
	public static void oper5() {
		int[][] newmap = new int[N][M];
		for(int x = 0; x < 4; x++) {
			int px = di[x%4];
			int py = dj[x%4];
			int nx = di[(x+1)%4];
			int ny = dj[(x+1)%4];
			for(int i = 0; i < N/2; i++) {
				for(int j = 0; j < M/2; j++) {				
					newmap[ny*(N/2)+i][nx*(M/2)+j] = map[py*(N/2)+i][px*(M/2)+j];
				}
			}
		}
		map = newmap;
	}
	public static void oper6() {
		int[][] newmap = new int[N][M];
		for(int x = 0; x < 4; x++) {
			int px = di[(x+1)%4];
			int py = dj[(x+1)%4];
			int nx = di[x%4];
			int ny = dj[x%4];
			for(int i = 0; i < N/2; i++) {
				for(int j = 0; j < M/2; j++) {				
					newmap[ny*(N/2)+i][nx*(M/2)+j] = map[py*(N/2)+i][px*(M/2)+j];
				}
			}
		}
		map = newmap;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		OPC = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j ++) {
				map[i][j] = Integer.parseInt(st2.nextToken());
			}
		}
		StringTokenizer st3 = new StringTokenizer(br.readLine(), " ");
		for(int x = 0; x < OPC; x++) {
			int cmd = Integer.parseInt(st3.nextToken());
			switch (cmd) {
			case 1:
				oper1();
				break;
			case 2:
				oper2();
				break;
			case 3:
				oper3();
				break;
			case 4:
				oper4();
				break;
			case 5:
				oper5();
				break;
			case 6:
				oper6();
				break;
			default:
				break;
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int[] ia : map) {
			for(int i : ia) {
				sb.append(i).append(" ");
			}
			sb.setLength(sb.length()-1);
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
