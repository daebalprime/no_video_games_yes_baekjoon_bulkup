package bj_11650;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		PriorityQueue<Coordination> pq = new PriorityQueue<>();
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i ++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			pq.offer(new Coordination(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));			
		}
		br.close();
		StringBuilder sb = new StringBuilder();
		while(!pq.isEmpty()) {
			Coordination tmp = pq.poll();
			sb.append(tmp.x).append(" ").append(tmp.y).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

	
}

class Coordination implements Comparable<Coordination>{
	int x;
	int y;
	
	Coordination(int x, int y){
		this.x = x; 
		this.y = y;
	}
	 
	@Override
	public int compareTo(Coordination o) {
		if(x == o.x) {
			return y - o.y;
		}
		return x - o.x;
	}
	
}
