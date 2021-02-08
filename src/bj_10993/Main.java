package bj_10993;
import java.util.*;
import java.io.*;
public class Main {
	static boolean map[][];
	
	static int getXSize(int n) {
		return (int)Math.pow(2, n+1) - 3;
	}
	static int getYSize(int n) {
		return getXSize(n)/2+1;
	}
	
	static void drawOuter(int n, int x, int y) {
		for(int i = 0; i < getXSize(n); i++) {
			for(int j = 0; j < getYSize(n); j++) {
				if(j == (n%2 == 1 ? getYSize(n)-1 : 0) 
						||
						i+j == (n%2 == 1 ? getYSize(n) - 1: 2*getYSize(n)-2) 
						||
						i-j == (n%2 == 1 ? getYSize(n) - 1 : 0)
						) {
					map[y+j][x+i] = true;
				}
			}
		}
	}
	
	static void recursive(int n, int x, int y) {
		if(n==1) {
			map[y][x] = true;
			return;
		}
		drawOuter(n,x,y);
		if(n%2==1)
		recursive(n-1, x+getXSize(n)/4+1, y+getYSize(n)/2);
		else recursive(n-1,x+getXSize(n)/4+1, y+1);
				
	}
	
	public static void main(String[] args) throws Exception{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		map = new boolean[getYSize(n)][getXSize(n)];
		
		recursive(n,0,0);
		StringBuilder sb1 = new StringBuilder();
		for(int j = 0; j < getYSize(n); j++) {
			for(int i = 0; i <  (n%2 == 0 ? getXSize(n) - j : getXSize(n)/2 + 1 +j); i++) {
				sb1.append(map[j][i] ? "*" : " ");
			}
			sb1.append("\n");
		}
		bw.write(sb1.toString());
		bw.flush();
		bw.close();
	}

}
