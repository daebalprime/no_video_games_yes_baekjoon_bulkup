package bj_2164;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> q = new ArrayDeque<>();
		for(int i = 1; i <= N; i++) {
			q.offer(i);
		}
		while(true) {
			if(q.size()==1) {
				break;
			}
			q.poll();
			q.offer(q.poll());
		}
		bw.write(Integer.toString(q.poll()));
		bw.flush();
		br.close();
		bw.close();
		
	}

}
