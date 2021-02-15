package bj_10866;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] s = new int[2000000];
		int T = Integer.parseInt(br.readLine());
		int size = 0;
		int f = 1000000;
		StringBuilder sb = new StringBuilder();
		for(int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			switch (st.nextToken()) {
			case "push_front":
				s[--f] = Integer.parseInt(st.nextToken());
				size++;
				break;
			case "push_back":
				s[f+(size++)] = Integer.parseInt(st.nextToken());
				break;
			case "pop_front":
				if(size == 0) {
					sb.append("-1"); 
					sb.append("\n");
				}
				else {
					sb.append(Integer.toString(s[f++]));
					sb.append("\n");
					size--;
				}
				break;
			case "pop_back":
				if(size == 0) {
					sb.append("-1"); 
					sb.append("\n");
				}
				else {
					sb.append(Integer.toString(s[f+(--size)]));
					sb.append("\n");
				}
				break;
			case "size":
				sb.append(Integer.toString(size));
				sb.append("\n");
				break;
			case "empty":
				sb.append(size==0 ? "1" : "0");
				sb.append("\n");
				break;
			case "front":				
				sb.append(size==0 ? "-1" : Integer.toString(s[f]));
				sb.append("\n");
				break;
			case "back":
				sb.append(size==0 ? "-1" : Integer.toString(s[f+size-1]));
				sb.append("\n");
				break;
			}
		}
		bw.write(sb.toString());
		bw.flush();
	}
}
