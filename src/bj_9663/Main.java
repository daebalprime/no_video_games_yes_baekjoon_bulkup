package bj_9663;
import java.util.Scanner;

public class Main{

	static int ans, N;
	static int[] col;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		col = new int[N+1];
		
		setQueen(0);
		System.out.println(ans);
	}
	
	//
	public static void setQueen(int rowNo) {
		
		//지금 위치에
		if(!isAvailable(rowNo)) {
			return;
		}
		
		if(rowNo == N) {
			ans++;
			return;
		}
		
		//자식노드의 가지를 파생
		for(int i = 1; i <= N; i++) {
			col[rowNo+1] = i;
			setQueen(rowNo+1);
		}
	}

	private static boolean isAvailable(int rowNo) {
		// TODO Auto-generated method stub
		for(int i = 1; i < rowNo; i++) {
			//퀸이 서로 위협적인 위치면 false
			if(col[rowNo] == col[i]) return false;
			if(Math.abs(rowNo-i) == Math.abs(col[rowNo]-col[i])) return false;
		}
		return true;
	}
}
