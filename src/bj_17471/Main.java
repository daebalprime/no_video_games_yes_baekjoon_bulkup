package bj_17471;

import java.io.*;
import java.util.*;

public class Main {
	static int N, answer, sum;
	static int[][] graph;
	static int[] population;
	static Queue<Integer> qa = new ArrayDeque<Integer>();
	static Queue<Integer> qb = new ArrayDeque<Integer>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		graph = new int[N][];
		population = new int[N];
		answer = Integer.MAX_VALUE;
		sum = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			population[i] = Integer.parseInt(st.nextToken());
			sum += population[i];
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st2.nextToken());
			graph[i] = new int[S];
			for(int k = 0; k < S; k++) {
				graph[i][k] = Integer.parseInt(st2.nextToken())-1;
			}
		}
//		check(13);
		for(int i = 1; i <(int) Math.pow(2, N-1); i++) {
//			System.out.println(Integer.toBinaryString(i));
			check(i);
		}
		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
		StringBuilder sb = new StringBuilder();
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
	
	static void check(int div) {
		int visited = 0;
		qa.offer(N-1);
		visited |= (1<<(N-1));
		for(int i = 0; i < N; i++) {
			if((div & (1<< i)) > 0) {
				qb.offer(i);
				visited |= (1<<i);
				break;
			}
		}
		int aSum = 0;
		while(!qa.isEmpty()) {
			int curr = qa.poll();
			aSum += population[curr];
			for(int nxt : graph[curr]) {
				if((visited & (1<<nxt)) == 0 && (div & (1<< nxt)) == 0) {				
					visited |= (1<<nxt);
					qa.offer(nxt);
				}
			}
		}
		while(!qb.isEmpty()) {
			int curr = qb.poll();
			visited |= (1<<curr);
			for(int nxt : graph[curr]) {
				if((visited & (1<<nxt)) == 0 && (div & (1<< nxt)) != 0) {				
					qb.offer(nxt);
				}
			}
		}
		if(visited != Math.pow(2, N)-1) {
			return;
		}
		answer = Math.min(answer, Math.abs(sum-2*aSum));
	}
	
}
