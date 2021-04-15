package bj_17114;

import java.io.*;
import java.util.*;

public class Main {
	static int[] d0 = 	{1,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	static int[] d1 = 	{0,0,1,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	static int[] d2 = 	{0,0,0,0,1,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	static int[] d3 = 	{0,0,0,0,0,0,1,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	static int[] d4 = 	{0,0,0,0,0,0,0,0,1,-1,0,0,0,0,0,0,0,0,0,0,0,0};
	static int[] d5 = 	{0,0,0,0,0,0,0,0,0,0,1,-1,0,0,0,0,0,0,0,0,0,0};
	static int[] d6 = 	{0,0,0,0,0,0,0,0,0,0,0,0,1,-1,0,0,0,0,0,0,0,0};
	static int[] d7 = 	{0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,0,0,0,0,0,0};
	static int[] d8 = 	{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,0,0,0,0};
	static int[] d9 = 	{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,0,0};
	static int[] d10 = 	{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1};
	
	
//	for(int i = 0; i < 11; i++) {
//		System.out.print("static int[] d"+(i+1) +" = {");
//		for(int j = 0; j < 11; j++) {
//			if(i== j) System.out.print("1,-1");
//			else System.out.print("0,0");
//			if(j!= 10) System.out.print(",");
//		}
//		System.out.println("};");
//	}
//	for(int i = 0; i < 11; i++) {
//		System.out.print("[d["+(10-i)+"]]");
//	}

	public static void main(String[] args) throws Exception{
//		for(int i = 0; i < 11; i++) {
//			char c = 'm';
//			System.out.println("&& n"+(char)(c+i)+" >= 0 && "+"n"+(char)(c+i) +" < d["+i+"]");
//			
//		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] d= new int[11];
		for(int i = 0; i < 11; i++) {
			d[i] = Integer.parseInt(st.nextToken());
		}
		int[][][][][][][][][][][] map = new int[d[10]][d[9]][d[8]][d[7]][d[6]][d[5]][d[4]][d[3]][d[2]][d[1]][d[0]];
		int remained = 1;
		for(int i : d) remained *= i;
		List<Queue<int[]>> niceTomato = new ArrayList<>();
		niceTomato.add(new LinkedList<int[]>());
		niceTomato.add(new LinkedList<int[]>());
		int list = 0, newTomato = 0;
		
		for(int w = 0; w < d[10]; w++){
			for(int v = 0; v < d[9]; v++) {
				for(int u = 0; u < d[8]; u++) {
					for(int t = 0; t < d[7]; t++) {
						for(int s = 0; s < d[6]; s++) {
							for(int r = 0; r < d[5]; r++) {
								for(int q = 0; q < d[4]; q++) {
									for(int p = 0; p < d[3]; p++) {
										for(int o = 0; o < d[2]; o++) {
											for(int n = 0; n < d[1]; n++) {
												st = new StringTokenizer(br.readLine());
												for(int m = 0; m < d[0]; m++) {
													int tmp = Integer.parseInt(st.nextToken());
													if(tmp == 1) {
//														niceTomato.get(0).offer(new int[] {w,v,u,t,s,r,q,p,o,n,m});
														niceTomato.get(0).offer(new int[] {m,n,o,p,q,r,s,t,u,v,w});
														remained--;
													}
													else if(tmp == -1) remained--;
													else newTomato++;
													map[w][v][u][t][s][r][q][p][o][n][m] = tmp;
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		if(remained == 0 && newTomato == 0) {
			System.out.println("0");
			return;
		}
		if(remained == 0) {
			System.out.println("-1");
			return;
		}
		int answer = 0;
		while(remained > 0) {
			int currlist = list;
			int nextlist = (list+1)%2;
			if(niceTomato.get(currlist).isEmpty() && niceTomato.get(nextlist).isEmpty()) {
				answer = -1;
				break;
			}
			while(!niceTomato.get(currlist).isEmpty()) {
				int[] curr = niceTomato.get(currlist).poll();
				int m = curr[0];
				int n = curr[1];
				int o = curr[2];
				int p = curr[3];
				int q = curr[4];
				int r = curr[5];
				int s = curr[6];
				int t = curr[7];
				int u = curr[8];
				int v = curr[9];
				int w = curr[10];
				for(int z = 0; z < 22; z++) {
					int nm = m+d0[z];
					int nn = n+d1[z];
					int no = o+d2[z];
					int np = p+d3[z];
					int nq = q+d4[z];
					int nr = r+d5[z];
					int ns = s+d6[z];
					int nt = t+d7[z];
					int nu = u+d8[z];
					int nv = v+d9[z];
					int nw = w+d10[z];
					if(nm >= 0 && nm < d[0]
							&& nn >= 0 && nn < d[1]
							&& no >= 0 && no < d[2]
							&& np >= 0 && np < d[3]
							&& nq >= 0 && nq < d[4]
							&& nr >= 0 && nr < d[5]
							&& ns >= 0 && ns < d[6]
							&& nt >= 0 && nt < d[7]
							&& nu >= 0 && nu < d[8]
							&& nv >= 0 && nv < d[9]
							&& nw >= 0 && nw < d[10]
							&& map[nw][nv][nu][nt][ns][nr][nq][np][no][nn][nm] == 0) {
						map[nw][nv][nu][nt][ns][nr][nq][np][no][nn][nm] = 1;
						niceTomato.get(nextlist).offer(new int[] {nm,nn,no,np,nq,nr,ns,nt,nu,nv,nw});
						remained--;
						
					}
				}
			}
			list = (list+1)%2;
			answer++;
		}
		System.out.println(answer);
		br.close();
	}

}
