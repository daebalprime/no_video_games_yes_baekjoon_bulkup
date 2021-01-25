package Bronze.bj_15964;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String[] tmp = sc.nextLine().split(" ");
//		System.out.println(tmp[0]);
//		System.out.println(tmp[1]);
		BigInteger a = new BigInteger(tmp[0]);
		BigInteger b = new BigInteger(tmp[1]);
		System.out.println(a.multiply(a).subtract(b.multiply(b)));
	}
}