import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class test{
    public static void main(String[] args) throws ParseException{
        SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
        Date d1 = sdformat.parse("2022-09-28");
        Date d2 = sdformat.parse("2022-10-26");
        Date d3 = sdformat.parse("2022-11-23");
        Date d4 = sdformat.parse("2022-12-7");
        System.out.println("The Lab1 is due on: " + sdformat.format(d1));
        System.out.println("The Lab2 is due on: " + sdformat.format(d2));
        System.out.println("The Lab3 is due on: " + sdformat.format(d3));
        System.out.println("The Lab4 is due on: " + sdformat.format(d4));
    }
}