package genericLibraries;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	/**
	 * this method generates random number within the limit
	 * @param limit
	 * @return
	 */
	
	public int generateRandomNum(int limit) {
	Random random = new Random();
	return random.nextInt(limit);
	}
	
	/**
	 * this method gets system time in specified format
	 * @return
	 */
	public String getCurrentTime() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd_MM__yy_hh__mm__sss");
		return sdf.format(date);
	}

}
