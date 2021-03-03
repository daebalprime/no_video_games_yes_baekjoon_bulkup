package bj_7662;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> min = new PriorityQueue<>();
		PriorityQueue<Integer> max = new PriorityQueue<>((o1,o2)->(Integer.compare(o2, o1)));
		HashMap<Integer, Integer> hm = new HashMap<>();
		for(int tc = 0; tc < T; tc++) {
			int total = 0;
			int N = Integer.parseInt(br.readLine());
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				if(st.nextToken().charAt(0) == 'I') {
					int tmp = Integer.parseInt(st.nextToken());
					max.offer(tmp);
					min.offer(tmp);
					if(!hm.containsKey(tmp)) {
						hm.put(tmp, 0);
					}
					++total;
					hm.replace(tmp, hm.get(tmp)+1);
				}
				else {
					int tmp = Integer.parseInt(st.nextToken());
					if(tmp == 1) {
						if(total != 0) {
							while(true) {
								int x = max.poll();
								if(hm.get(x) != 0) {
									hm.replace(x, hm.get(x)-1);
									break;
								}
							}
							--total;
						}
					}else {
						if(total != 0) {
							while(true) {
								int x = min.poll();
								if(hm.get(x) != 0) {
									hm.replace(x, hm.get(x)-1);
									break;
								}
							}
							--total;
						}
					}
				}
			}
			if(total == 0) System.out.println("EMPTY");
			else {
				while(true) {
					int x = max.poll();
					if(hm.get(x) != 0) {
						System.out.print(x+" ");
						break;
					}
				}
				while(true) {
					int x = min.poll();
					if(hm.get(x) != 0) {
						System.out.println(x);
						break;
					}
				}
			}
			hm.clear();
			max.clear();
			min.clear();
		}
		StringBuilder sb = new StringBuilder();
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}

}
