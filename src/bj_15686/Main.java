package bj_15686;

import java.io.*;
import java.util.*;



public class Main {
	
	static int getDist(Home h, Chic c) {
		return Math.abs(h.getX()-c.getX()) + Math.abs(h.getY()-c.getY());
	}
	
	static int N, M, hc, cc, answer;
	static boolean[] visited;
	static ArrayList<Home> ha;
	static ArrayList<Chic> ca;
	
	
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
//		int N = Integer.parseInt(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][N];
		ha = new ArrayList<>();
		ca = new ArrayList<>();
		hc = 0;
		cc = 0;
		answer = Integer.MAX_VALUE;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				String tm = st.nextToken();
				if (tm.equals("1")) {
					ha.add(new Home(i,j));
					hc++;
				}
				else if(tm.equals("2")) {
					ca.add(new Chic(i,j));
					cc++;
				}
			}
		}
		visited = new boolean[cc]; 
		
		pick(0,0);
		
		StringBuilder sb = new StringBuilder();
		sb.append(answer);
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
	
	static void pick(int cnt, int start) {
		
		if(cnt == M) {
//			for(boolean b : visited) {
//				System.out.print((b? 'O' : 'X') + " ");
//			}
//			System.out.println();
			for(int i = 0; i < cc; i++) {
				if(visited[i]) {
					Chic curr = ca.get(i);
					for(Home h : ha) {
						h.putChic(curr);
					}
				}
			}
			int ans = 0;
			for(Home h : ha) {
//				System.out.println(ans);
				ans += h.getMin();
				h.clear();
			}
			answer = Math.min(ans, answer);
			return;
		}
		for(int i = start; i < cc; i++) {
			visited[i] = true;
			pick(cnt+1, i+1);
			visited[i] = false;
		}

	}
}

class Home{
	int x, y;
	PriorityQueue<Chic>closestChic;
	
	public Home(int x, int y) {
		super();
		this.x = x;
		this.y = y;
		this.closestChic = new PriorityQueue<>((o1,o2)->(Integer.compare(
				Main.getDist(this,o1),Main.getDist(this,o2)
				)));
	}
	public void putChic(Chic c) {
		closestChic.offer(c);
//		System.out.println("chic size(): "+closestChic.size());
	}
	
	public int getMin() {
//		System.out.println("chic size(): "+closestChic.size());
		if(closestChic.isEmpty()) return 0;
		return Main.getDist(this,closestChic.peek());
	}
	
	public void clear() {
		closestChic.clear();
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
}

class Chic{
	int x,y;
	PriorityQueue<Home> closestHome;
	
	public Chic(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}