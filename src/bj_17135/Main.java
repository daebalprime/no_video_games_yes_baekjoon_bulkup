package bj_17135;

import java.io.*;
import java.util.*;

public class Main {

	static int[] di = {-1,0,1};
	static int[] dj = {0,-1,0};
	
	static int N,M,D,answer;
	static boolean[][] map;
	static int[] archers;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		boolean[][] orgMap = new boolean[N][M];
		archers = new int[M];
		for(int i = 0; i < 3; i++) {
			archers[M-i-1] = 1;
		}
		answer = 0;
		int enemys = 0;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				String tmp = st.nextToken();
				if(tmp.equals("1")) {
					orgMap[i][j] = true;
					enemys++;
				}
			}
		}
		do {
			int res = simulate(archers, deepCopy(orgMap), enemys);
			answer = Math.max(answer, res);
		}while(np(archers));
		StringBuilder sb = new StringBuilder();
		sb.append(answer);
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
	
	static int attack(boolean[][] map, int j, int[] archer) {
		Queue<attackOrder> bfs = new LinkedList<attackOrder>();
		Queue<int[]> target = new LinkedList<int[]>();
		for(int a : archer) {
			boolean[][] visited = new boolean[N][M];
			bfs.clear();
			bfs.offer(new attackOrder(a, j-1, 1));
			visited[j-1][a] = true;
			while(!bfs.isEmpty()){
				attackOrder c = bfs.poll();
				if(c.getLevel() > D) {
					break;
				}
				int x = c.getX();
				int y = c.getY();
				int level = c.getLevel();
				visited[y][x] = true;
				if(map[y][x]) {
					target.offer(new int[] {x,y});
					break;
				}
				for(int i = 0; i < 3; i++) {
					int nx = x + di[i];
					int ny = y + dj[i];
					if(nx >= 0 && nx < M && ny >= 0 && ny < N &&
							!visited[ny][nx]) {
						bfs.offer(new attackOrder(nx, ny, level+1));
					}
				}
			}
		}
		int ret = 0;
		while(!target.isEmpty()) {
			int[] c = target.poll();
			if(map[c[1]][c[0]]) {
				ret++;
				map[c[1]][c[0]] = false;
			}
		}
		return ret;
	}
	
	static int simulate(int[] arch, boolean[][] map, int enemys) {
		int[] archer = new int[3];
		int tmp = 0;
		for(int i = 0; i < M; i++) {
			if(arch[i] == 1) {
				archer[tmp++] = i;
			}
		}
		int ret = 0;
		int j = N;
		while(j > 0 || enemys != 0) {
			for(int x = 0; x < j; x++) {
				boolean[] ba = map[x];
				for(boolean b : ba) {
					System.out.print(b?"X " : "- ");
				}
				System.out.println();
			}
			for(int i = 0; i < M; i++) {
				System.out.print(arch[i] == 1? "^ " : "| ");
			}
			System.out.println();
			for(int x = j; x < N; x++) {
				boolean[] ba = map[x];
				for(boolean b : ba) {
					System.out.print(b?"X " : "- ");
				}
				System.out.println();
			}
			int kill = attack(map, j, archer);
			ret += kill;
			enemys -= kill;
			j--;
			for(int i = 0; i < M; i++) {
				if(map[j][i]) {
					enemys --;
					map[j][i] = false;
				}
			}
			System.out.println("kill "+ kill+ " -----------------");
		}
		System.out.println("++++++++++++++++++");
		
		//shoot arrow
		//
		return ret;
	}
	static boolean np(int[] ia) {
		int i = ia.length-1;
		while(i > 0 && ia[i-1] >= ia[i]) i--;
		if(i == 0) return false;
		int j = ia.length-1;
		while(ia[i-1] >= ia[j]) j--;
		swap(ia,i-1,j);
		
		int k = ia.length-1;
		while(i < k) swap(ia,i++,k--);
		
		return true;
	}

	static void swap(int[] ba, int x, int y) {
		int tmp = ba[x];
		ba[x] = ba[y];
		ba[y] = tmp;
	}
	
	static boolean[][] deepCopy(boolean[][] org){
		boolean[][] newMap = new boolean[N][M];
		for(int j = 0; j < N; j++) {
			newMap[j] = Arrays.copyOf(org[j], M);
		}		
		return newMap; 
	}
}

class attackOrder {
	int x, y, level;

	public attackOrder(int x, int y, int level) {
		super();
		this.x = x;
		this.y = y;
		this.level = level;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	public int getLevel() {
		return level;
	}
	
}
