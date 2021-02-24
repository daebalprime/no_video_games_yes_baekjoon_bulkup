package bj_2605;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<Integer> al = new ArrayList<>();
		for(int i = 1; i <= N; i++) {
			int pass = Integer.parseInt(st.nextToken());
			if(pass == 0 ) {
				al.add(i);
			}
			else {
				al.add(al.size()-pass, i);
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i : al) {
			sb.append(i+" ");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
		br.close();
	}
}