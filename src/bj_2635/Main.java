package bj_2635;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int answer = 0;
		
		LinkedList<Integer> ll = new LinkedList<>();
		LinkedList<Integer> max = new LinkedList<>();
		for(int i = 0; i <= N; i++) {
			ll.clear();
			ll.offer(N);
			ll.offer(i);
			int idx = 3;
			while(true) {
				int curr = ll.get(idx-3) - ll.get(idx-2);
				if (curr < 0) {
					if(answer < idx -1) {
						answer = idx-1;
						max = ll;
						ll = new LinkedList<>();
					}
					break;
				}
				ll.offer(curr);
				idx++;
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(answer+"\n");
		while(!max.isEmpty()) {
			sb.append(max.poll()+" ");
		}
		sb.setLength(sb.length()-1);
		bw.write(sb.toString());
		bw.flush();
	}

}
