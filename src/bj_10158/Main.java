package bj_10158;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(br.readLine());
		
		X = (X + T) % (2 * W);
		Y = (Y + T) % (2 * H);			
		if(X > W) X = 2 * W - X;
		if(Y > H) Y = 2 * H - Y;
		
		System.out.println(X + " " + Y);
	}
}
