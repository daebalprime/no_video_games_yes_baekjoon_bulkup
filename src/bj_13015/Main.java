package bj_13015;

import java.util.Scanner;
import java.io.*;
public class Main {

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		BufferedWriter br = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = sc.nextInt();
		sc.close();
		StringBuilder sb = new StringBuilder();
//		4*N-3
		for(int j = 0; j < 2*N-1; j++) {
			if(j >= N) {
				for(int i = 0; i < 2*N-2-j; i++) {
					sb.append(" ");
				}
			}
			else {				
				for(int i = 0; i < j; i++) {
					sb.append(" ");
				}
			}
			sb.append("*");
			for(int i = 0; i < N-2; i++) {
				if(j==0 || j == 2*N-2) sb.append("*");
				else sb.append(" ");
			}
			sb.append("*");
			if(j >=N) {
				for(int i = 0; i < Math.abs((2*N-3-2*j))-2 ; i++) {
					sb.append(" ");
				}
			}
			else if(j < N-1) {				
				for(int i = 0; i < Math.abs((2*N-3-2*j)) ; i++) {
					sb.append(" ");
				}
			}
			
			if(j != N-1) sb.append("*");
			for(int i = 0; i < N-2; i++) {
				if(j==0 || j == 2*N-2) sb.append("*");
				else sb.append(" ");
			}
			sb.append("*\n");
		}
		br.write(sb.toString());
		br.flush();
		br.close();
	}

}
