package Bronze.bj_16170;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date time = new Date();
		SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy\nMM\ndd");
		String time1 = format1.format(time);
		System.out.println(time1);
	}

}
