package Bronze.bj_13277;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {

		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			String[] tmp = sc.nextLine().split(" ");
			BigInteger a = new BigInteger(tmp[0]);
			BigInteger b = new BigInteger(tmp[0]);
			System.out.println(a.multiply(b));
			sc.close();	
		}
	}
