// lab 2

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Birthday {
	public static void main(String [] args) {
       Scanner sc = new Scanner(System.in);
       System.out.println("Enter your birth month [1..12]: ");
       int mon = sc.nextInt();
       System.out.println("Enter your birth day of month: ");
       int date = sc.nextInt();
       System.out.println("Enter your birth year [4-digit year]: ");
       int year = sc.nextInt();
       
       Calendar curDate = Calendar.getInstance();
       int curYear = curDate.get(Calendar.YEAR);
       GregorianCalendar gcal = new GregorianCalendar(curYear, mon-1, date);
       GregorianCalendar curDate_1 = new GregorianCalendar(curYear, curDate.get(Calendar.MONTH), curDate.get(Calendar.DATE));
       int age = curYear - year;
       
       if (curDate_1.after(gcal)) {
          System.out.println("Your birthday has already happened this year.");
       } else if (curDate_1.equals(gcal)) {
          System.out.println("Your birthday is today!");
       } else {
          System.out.println("Your birthday has not yet happened this year.");
          age --;
       }
       System.out.println("You're "+ age +" years old.");
    }

}

