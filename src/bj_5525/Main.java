package bj_5525;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int L = Integer.parseInt(br.readLine());
		String S = br.readLine();
		ArrayList<Integer> al = new ArrayList<>();
		for(int i = 0; i < L; i++) {
			if(S.charAt(i)=='I') {
				int streak = 0;
				while(i+2 < L) {
					if(S.charAt(i+1) == 'O') {
						i++;
						if(S.charAt(i+1)=='I') {
							i++;
							streak++;
						}else break;
					}
					else break;
				}
				if(streak != 0)al.add(streak);
			}
		}
		int answer = 0;
		for(int i : al) {
			if(i >= N) answer +=  i-N+1;
		}
		System.out.println(answer);
		br.close();
	}

}
