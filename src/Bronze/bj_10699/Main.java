package Bronze.bj_10699;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

	public static void main(String[] args) {
		Date a = new Date();
		
		SimpleDateFormat format1= new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(format1.format(a));
		
	}

}
