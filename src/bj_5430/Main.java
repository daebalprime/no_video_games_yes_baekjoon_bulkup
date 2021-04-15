package bj_5430;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder answer = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			String cmd = br.readLine();
			int size = Integer.parseInt(br.readLine());
			String tmp = br.readLine();
			
			StringTokenizer raw = new StringTokenizer(tmp.substring(1,tmp.length()-1), ",");
			Deque<Integer> dq = new LinkedList<>();
			for(int i = 0; i < size; i++) {
				dq.offerLast(Integer.parseInt(raw.nextToken()));
			}
			boolean flag = true; // T for first, F for last;
			for(int i = 0; i < cmd.length(); i++) {
				char singleCmd = cmd.charAt(i);
				if(singleCmd == 'R') flag ^= true;
				else {
					if(dq.isEmpty()) {
						dq= null;
						break;
					}
					if(flag) { // from front
						dq.pollFirst();
					}
					else {
						dq.pollLast();
					}
				}
			}
			StringBuilder sb = new StringBuilder();
			if(dq == null) sb.append("error\n");
			else {
				sb.append('[');
				while(!dq.isEmpty()) {
					if(flag) sb.append(dq.pollFirst()).append(',');
					else sb.append(dq.pollLast()).append(',');
				}
				if(sb.length() != 1)
					sb.setLength(sb.length()-1);
				sb.append(']').append('\n');
			}
			answer.append(sb);
		}
		bw.write(answer.toString());
		bw.flush();
		br.close();
		bw.close();
	}

}
