package bj_11729;

import java.io.*;

public class Main {
	static int count = 0;
	static StringBuilder sb = new StringBuilder();
	static void hanoi(int c, int start, int mid, int dest) {
		if(c==1) {
			sb.append(start+" "+dest+"\n");
			count++;
			return;
		}
		// 자기 빼고 나머지 다 중간으로
		hanoi(c-1, start,dest,mid);
		// 제일 큰 것 목표지로
		sb.append(start+" "+dest+"\n");
		count++;
		// 나머지 다 목표지로
		hanoi(c-1, mid, start, dest);
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int inp = Integer.parseInt(br.readLine());
		
		hanoi(inp,1,2,3);
		System.out.println(count);
		System.out.println(sb.toString());
	}

}
