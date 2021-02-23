package bj_14889;



import java.io.*;
import java.util.*;

public class Main{
	static int answer = 0;
	static int N = 0;
	static boolean[] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
			N = Integer.parseInt(br.readLine());
			int[][] synergy = new int[N][N];
			int[] subsetMarker = new int[N];
			answer = Integer.MAX_VALUE;
			for(int y = 0; y < N; y++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int x = 0; x < N; x++) {
					synergy[y][x] = Integer.parseInt(st.nextToken());					
				}
			}
			//input 값 읽어들이기
			//synergy 값 저장하기
			for(int k = N/2; k < N; k++) {
				subsetMarker[k] = 1; // 00001111, 0011, 0000000011111111,...
			}
			do {
				//0으로 표시된 재료는 1번 요리, 1은 2번 요리
				if(subsetMarker[0] == 1) break;//가지치기 
				//1010 == 0101 케이스가 같으므로, 전체 순열의 절반만 고려해주면 된다.
				//첫 번째 자리가 1이 되면, 딱 절반까지 고려하게 됨
				int f1, f2 = f1 = 0;
				//nC2 -> 재귀로 구현해도 되지만 2개만 뽑기 때문에 for문으로 간단하게 구현
				for(int i = 0; i < N; i++) {
					for(int j = i+1; j < N; j++) {
						if(subsetMarker[i] == 0 && subsetMarker[j] == 0) {
							f1 += calSynergy(synergy, new int[]{i,j});
						}
						else if(subsetMarker[i] == 1 && subsetMarker[j] == 1) {
							f2 += calSynergy(synergy, new int[]{i,j});
						}
					}
				}
				//계산하고 난 뒤에 차이의 최소값을 비교하여 answer에 푸쉬
				answer = Math.min(Math.abs(f1-f2),answer);
			}while(np(subsetMarker, N));
			sb.append(answer+"\n");
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
	
	static int calSynergy(int[][] ia, int[] ing) { // ingredients.
		int a1 = ing[0];
		int a2 = ing[1];
		return ia[a1][a2]+ia[a2][a1];
	}
	
	public static boolean np(int[] ia, int N) {
		int i = N-1; // 꺾이는 포인트
		while(i>0 && ia[i-1] >= ia[i]) --i;
		
		if(i==0) return false;
		
		int j = N-1;
		while(ia[i-1] >= ia[j]) --j;
		
		swap(i-1, j, ia);
		
		int k = N-1;
		while(i < k) {
			swap(i++, k--, ia);
		}
		
		return true;
	}
	
	static void swap(int a, int b, int[] ia) {
		int temp = ia[a];
		ia[a] = ia[b];
		ia[b] = temp;
		return;
	}
}
