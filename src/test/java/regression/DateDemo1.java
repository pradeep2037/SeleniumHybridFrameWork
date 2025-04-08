package regression;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDemo1 {

	public static void main(String[] args) {
		
		Date date = new Date();
		System.out.println(date);
		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String date1 = sdf.format(date);
		System.out.println(date1);
	}
}
