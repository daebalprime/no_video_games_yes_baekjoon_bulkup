package bj_10773;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> st = new Stack<>();
		for(int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(br.readLine());
			if(tmp == 0) {
				st.pop();
			}
			else {
				st.push(tmp);
			}
		}
		int answer = 0;
		while(!st.isEmpty()) {
			answer += st.pop();
		}
		StringBuilder sb = new StringBuilder();
		sb.append(answer);
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}

}
