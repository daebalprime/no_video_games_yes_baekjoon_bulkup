package bj_1931;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->(
				o1[1]==o2[1]?
						Integer.compare(o1[0], o2[0]):
						Integer.compare(o1[1], o2[1])
						));
		int N = Integer.parseInt(br.readLine());
		int time = 0;
		int answer = 0;
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			pq.offer(new int[] { Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())});
		}
		while(!pq.isEmpty()) {
			int[] curr = pq.poll();
//			System.out.println(curr[0]+" "+curr[1]);
			if(time <= curr[0]) {
//				System.out.println("THIS");
				time=curr[1];
				answer++;
			}
		}
		bw.write(Integer.toString(answer));
		bw.flush();
		br.close();
		bw.close();
	}
}
/*
3
3 5
1 4
4 8
=> 2

1
1 1


 */