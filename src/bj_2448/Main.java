package bj_2448;

import java.util.Scanner;
import java.io.*;

public class Main {
	static boolean[][] map;
	
	static int size(int i) {
		int p = (int) (Math.log10(i/3)/Math.log10(2));
//		return 3*p*p+3*p+5;
//		int p = i/6;
		return 3*((int)Math.pow(2, p+1));
	}
	
	static void recursive(int n, int x, int y, int sizet) {
//		if(n==6 || n == 3)
//		System.out.println("x : "+x+" y : "+y+" n : "+n);
		if(n==3) {
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < 5; j++) {					
					if(i==2 || i+j == 2 || j-i == 2) map[x+i][y+j] = true;
				}
			}
			return;
		}
		recursive(n/2, x,y+sizet/4,size(n/2));
		recursive(n/2, x+n/2,y,size(n/2));
		recursive(n/2, x+n/2,y+sizet/2,size(n/2));
		
	}
	
	public static void main(String[] args) throws Exception{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
//		int n = 12;
		
		map = new boolean[n][size(n)];
//		System.out.println(size(n));
		recursive(n,0,0,size(n));
//		
//		for(int )
		
		StringBuilder sb = new StringBuilder();
		for(boolean[] bt : map) {
			for(boolean b : bt) {
				if(b) sb.append('*');
				else sb.append(' ');
			}
			sb.append('\n');
		}
		bw.write(sb.toString());
		bw.flush();
		
	}
}
