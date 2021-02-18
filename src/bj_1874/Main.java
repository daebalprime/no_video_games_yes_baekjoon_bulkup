package bj_1874;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		int N = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(br.readLine());
		int idx = 1;
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stt = new Stack<>();
		for(int i = 0; i < N; i++) {
			int curr = Integer.parseInt(br.readLine());
			for(;idx <= curr; idx++) {
				sb.append("+\n");
				stt.push(idx);
			}
			if(stt.isEmpty() || stt.peek() < curr) {
				sb = new StringBuilder("NO");
				break;
			}
			else {
				boolean flag = false;
				while(!stt.isEmpty()) {
					int top = stt.pop();
					sb.append("-\n");
					if(curr == top){
						flag = true;
						break;
					}
				}
				if(!flag) {
					sb = new StringBuilder("NO");
					break;
				}
			}
			
		}
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}

}
