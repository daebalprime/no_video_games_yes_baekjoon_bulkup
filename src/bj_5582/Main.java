package bj_5582;

import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();
		sc.close();
		
		int answer = 0;
		LinkedList<Integer> max = new LinkedList<>();
		int tmp = 0;
		int[][] map = new int[s1.length()][s2.length()];
		for(int i = 0; i < s1.length(); i++) {
			for(int j = 0; j < s2.length(); j++) {
				if(s1.charAt(i) == s2.charAt(j)) {
					if(i-1 >= 0 && j-1 >= 0) {
						map[i][j] = map[i-1][j-1]+1;
					}
					else {
						map[i][j] = 1;
					}
//					answer = Math.max(answer, map[i][j]);
					if(answer < map[i][j]) {
						answer = map[i][j];
						max.clear();
						max.offer(i);
					}
					else if(answer == map[i][j]) {
						max.offer(i);
					}
				}
			}
		}
		System.out.println(answer);
		while(!max.isEmpty()) {
			int a = max.poll();
			for(int i = answer-1; i >= 0; i--) {
				System.out.print(s1.charAt(a-i));
			}
			System.out.println();
		}
	}

}
