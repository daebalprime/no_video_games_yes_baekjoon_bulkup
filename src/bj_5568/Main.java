package bj_5568;

import java.util.HashSet;
import java.util.Scanner;

public class Main {
	static HashSet<Integer> s = new HashSet<>();
	static boolean[] isSelected;
	static int[] cards;
	static int N; // total number of cards
	static int K; // how many cards picking
	static int[] permRes;
	
	
	static void permutation(int n, int cardIndex[]) {
		if(n==0) {
			//push to the set
//			System.out.println("------------");
			StringBuilder sb = new StringBuilder();
			for(int c: permRes) {
				sb.append(cards[cardIndex[c]]);
//				System.out.print(cards[cardIndex[c]]+" ");
			}
//			System.out.println();
			s.add(Integer.parseInt(sb.toString()));
//			System.out.println("------------");
		}
		for(int i = 0; i < K; i++) {
			if(!isSelected[i]) {
				isSelected[i] = true;
				permRes[K-(n)] = i;
				permutation(n-1, cardIndex);
				isSelected[i] = false;
			}
		}
	}
	
	
	static void combination(int n/*count*/, int start, int[] arr) {
		if(n==K) {
			//do permutation
			permutation(K, arr);
			return;
		}
		for(int i = start+1; i < N; i++) {
			arr[n] = i;
			combination(n+1, i, arr);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		isSelected= new boolean[N];
		cards = new int[N];
		permRes = new int[K];
		for(int i = 0; i < N; i++) {
			cards[i] = sc.nextInt();
		} 
		
//		N=10;
//		K=4;
		
		
		
		
		
		combination(0,0,new int[K]);
		// pick combi & permutation
		permutation(K,new int[K]);
		
		// push set
		
		System.out.println(s.size());
	}

}
