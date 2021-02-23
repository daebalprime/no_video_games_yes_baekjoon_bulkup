package bj_2630;
import java.io.*;
import java.util.*;

public class Main{

	static int N, count, blue, white;
	static int[] di = {0,1,0,1};
	static int[] dj = {0,0,1,1};
	static boolean[][] map;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new boolean[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = st.nextToken().equals("1") ? true : false;
			}
		}
		divide(0,0,N);
		StringBuilder sb = new StringBuilder();
		sb.append(white+"\n");
		sb.append(blue+"\n");
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
	
	public static void divide(int x, int y, int n) {
		boolean p = map[y][x];
		boolean flag = true;
		for(int j = 0; j < n; j++) {
			if(!flag) break;
			for(int i = 0; i < n; i++) {
				if(p != map[y+j][x+i]) {
					flag = false;
					break;
				}
			}
		}
		if(flag) {
			if(p) blue++;
			else white++;
			return;
		}
		else {
			for(int k = 0; k < 4; k++) {
				divide(x+di[k]*(n/2),y+dj[k]*(n/2), n/2);
			}
		}
		
	}
//	public static void visit(int x, int y, int level) {
////		if(x > X || x + level <= X || y > Y || y + level <= Y) return;
//		if(level == 2) {
//			for(int i = 0; i < 4; i++) {
//				int nx = x+di[i];
//				int ny = y+dj[i];
//				if(ny == Y && nx == X) {
//					System.out.println(count);
//					System.exit(0);
//				}
//				count++;
//			}
//			return;
//		}
//		for(int i = 0; i < 4; i++) {
//			int dx = di[i]*(level/2); 
//			int dy = dj[i]*(level/2); 
//			if(X >= x+dx && X < x+dx+level/2 && Y >= y+dy && Y < y+dy+level/2) {
//				visit(x+dx, y+dy, level/2);
//			}
//			count += level*level/4;
//		}
////		visit(x, y, level/2);
////		visit(x+(level/2), y, level/2);
////		visit(x, y+(level/2), level/2);
////		visit(x+(level/2), y+(level/2), level/2);
//	}
}
