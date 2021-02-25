package bj_2669;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		boolean[][] map = new boolean[100][100];
		for(int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			int nx = Integer.parseInt(st.nextToken())-1;
			int ny = Integer.parseInt(st.nextToken())-1;
			for(int a = x; a < nx; a++) {
				for(int b = y; b < ny; b++) {
					map[a][b]=true;
				}
			}
		}
		int answer = 0;
		for(int j = 0; j < 100; j++) {
			for(int i = 0; i < 100; i++) {
				if(map[j][i]) answer++; 
			}
		}
		System.out.println(answer);
	}
}
