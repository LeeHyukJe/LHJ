package chap11;
import java.text.DecimalFormat;
import java.util.ArrayList;
public class FormatUtil {
	public static String number(long number, String pattern) {
		DecimalFormat format=new DecimalFormat(pattern);
		ArrayList<String> list=new ArrayList<>();
		
		return format.format(number);
	}
}
