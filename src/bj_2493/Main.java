package bj_2493;

import java.util.*;
import java.io.*;
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[] tower = new int[n];
		int[] result = new int[n];
		Stack<int[]> st = new Stack<>();
		StringTokenizer stt = new StringTokenizer(br.readLine(), " ");
		br.close();
		for(int i = 0; i < n; i++) {
			tower[i] = Integer.parseInt(stt.nextToken());
		}
		for(int i = n-1; i>=0; i--) {
			if(st.isEmpty() || st.peek()[0] > tower[i]) {
				st.push(new int[] {tower[i],i});
				continue;
			}
			else {
				while(!st.isEmpty() && (st.peek()[0] <= tower[i])) {
					int h = st.peek()[0];
					int id = st.pop()[1];
					result[id] = i+1;
				}
			}
			st.push(new int[] {tower[i],i});
		}
		StringBuilder sb = new StringBuilder();
		for (int  i : result) {
			sb.append(i).append(" ");
		}
		sb.setLength(sb.length()-1);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
