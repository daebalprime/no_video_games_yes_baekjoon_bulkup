package bj_1978;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		List<Integer> li = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			li.add(sc.nextInt());
		}
		li.sort((o1,o2)->(o2-o1));
		int max = li.get(0);
		int[] map = new int[1001];
		map[0] = -1;
		map[1] = -1;
		int answer = 0;
		for(int i = 2; i < max+1; i++) {
			if(map[i] == -1) continue;
			if(map[i] != -1) map[i] = 1;
			for(int j = i; j < max+1; j+= i) {
				if(map[j] <= 0) map[j] = -1;
			}
		}
		for(int i : li) {
			if(map[i] == 1) answer++;
		}
		System.out.println(answer);
	}
}
