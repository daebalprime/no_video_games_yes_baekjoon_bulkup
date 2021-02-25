package bj_2309;
import java.io.*;
import java.util.*;

public class Main {
	
	static int[] numbers;
	static boolean[] visited;
	static int[] cand;
	static int N = 9, R = 7;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		numbers = new int[N];
		visited = new boolean[N];
		cand = new int[R];
		for(int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(br.readLine());
		}
		combination(0, 0, 0);
	}
	
	static void combination(int cnt, int start, int sum) {
		if(sum > 100) return;
		if(cnt == R) {
			if(sum == 100) {
				Arrays.sort(cand);
				for(int x : cand) {
					System.out.println(x);
				}
				System.exit(0);
			}
			return;
		}
		for(int i = start; i < N; i++) {
//			if(visited[i]) continue;
//			visited[i] = true;
			cand[cnt] = numbers[i];
			combination(cnt+1, i+1, numbers[i]+sum);
//			visited[i] = false;
		}
	}
}
