import java.text.ParseException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class test{
    public static void main(String[] args) throws ParseException{
        String date1 = "2022-10-28";
        String date2 = "2022-09-26";
        System.out.println(daysBetweenDates(date1,date2));

    }
    public static int daysBetweenDates(String date1, String date2) {
	    return Math.abs((int)ChronoUnit.DAYS.between(LocalDate.parse(date1), LocalDate.parse(date2)));
    }

   
}