package bj_18511;

import java.util.Scanner;

public class Main {
	static int[] k;
	static int ksz;
	static int max;
	static boolean[] visited;
	static int permu(int c, int bound, int[] arr) {
		if(c==bound) {
			String ret = "";
			for(int i : arr) {
				ret += Integer.toString(i);
			}
			int t = Integer.parseInt(ret);
//			System.out.println(t);
			if(t <= max) return t;
			return 0;
		}
		int localmax = 0;
		for(int i = 0; i < ksz; i++) {
			arr[c] = k[i];
//			for(int j : arr) System.out.println(j+" ");
//			System.out.println();
//			if(local)
			localmax = Math.max(permu(c+1,bound,arr),localmax);
		}
		if(c==0) {
			arr[0] = 0;
			localmax = Math.max(permu(c+1,bound,arr),localmax);
		}
		return localmax;
		
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String target = sc.next();
		max = Integer.parseInt(target);
		ksz = sc.nextInt();
		k = new int[ksz];
//		visitied = new boolean[target.length()];
		for(int i = 0; i < ksz; i++) {
			k[i] = sc.nextInt();
		}
//		k[ksz] = 0;
		System.out.println(permu(0, target.length(), new int[target.length()]));
	}
}
