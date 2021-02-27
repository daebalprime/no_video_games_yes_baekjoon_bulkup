package bj_2628;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> wc = new PriorityQueue<>();
		PriorityQueue<Integer> hc = new PriorityQueue<>();
		
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			if(Integer.parseInt(st.nextToken()) == 1)
				wc.offer(Integer.parseInt(st.nextToken()));
			else
				hc.offer(Integer.parseInt(st.nextToken()));
		}
		wc.offer(W);
		hc.offer(H);
		int wm = 0;
		int hm = 0;
		int curr = 0;
		while(!wc.isEmpty()) {
			int x = wc.poll();
			wm = Math.max(wm, x-curr);
			curr = x;
		}
		curr = 0;
		while(!hc.isEmpty()) {
			int x = hc.poll();
			hm = Math.max(hm, x-curr);
			curr = x;
		}
		System.out.println(hm*wm);
		br.close();
	}

}
