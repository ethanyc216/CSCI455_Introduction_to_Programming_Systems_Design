// lab 2

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Date {

	public static void main(String [] args) {
	GregorianCalendar gcal = new GregorianCalendar(1995, 0, 20);
	System.out.println(gcal.get(Calendar.MONTH)+1+"/"+gcal.get(Calendar.DATE)+"/"+gcal.get(Calendar.YEAR));
	gcal.add(Calendar.DATE, 20); 
	System.out.println(gcal.get(Calendar.MONTH)+1+"/"+gcal.get(Calendar.DATE)+"/"+gcal.get(Calendar.YEAR));
    }

}

