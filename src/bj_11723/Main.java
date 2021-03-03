package bj_11723;

import java.io.*;
import java.util.*;

import javax.print.attribute.HashAttributeSet;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		boolean[] set = new boolean[21];
		StringBuilder sb = new StringBuilder();
		for(int cmds = 0; cmds < N; cmds++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			if(cmd.equals("all")) {
				for(int i = 1; i <= 20; i++) {
					set[i] = true;
				}
			}
			else if(cmd.equals("add")) {
				set[Integer.parseInt(st.nextToken())] = true;
			}
			else if(cmd.equals("remove")) {
				set[Integer.parseInt(st.nextToken())] = false;
			}
			else if(cmd.equals("check")) {
				sb.append(set[Integer.parseInt(st.nextToken())]?"1\n" : "0\n");
			}
			else if(cmd.equals("toggle")) {
				set[Integer.parseInt(st.nextToken())] ^= true;
			}
			else { // empty
				set = new boolean[21];
			}
		}
		bw.write(sb.toString());
		bw.flush();
	}
}
