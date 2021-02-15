package bj_10814;

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
			pq.offer(new Coordination(Integer.parseInt(st.nextToken()), st.nextToken(), i));			
		}
		br.close();
		StringBuilder sb = new StringBuilder();
		while(!pq.isEmpty()) {
			Coordination tmp = pq.poll();
			sb.append(tmp.x).append(" ").append(tmp.name).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

	
}

class Coordination implements Comparable<Coordination>{
	int x;
	String name;
	int id;
	
	Coordination(int x, String name, int id){
		this.x = x; 
		this.name = name;
		this.id = id;
	}
	 
	@Override
	public int compareTo(Coordination o) {
		if(x == o.x) {
			return id - o.id;
		}
		return x - o.x;
	}
	
}
