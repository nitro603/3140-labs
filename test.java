import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class test{
    public static void main(String[] args) throws ParseException,Exception{
        //Setting up objects
        HashMap<String, String> dateCollection = new HashMap<String, String>();
        Scanner stdin = new Scanner(System.in);

        Boolean running = true;
        while(running){
            if(!dateCollection.isEmpty()){
                System.out.println("_Current Dates_");
                for (String key : dateCollection.keySet()){
                    System.out.print("* "+ key + " : ");
                    System.out.println(dateCollection.get(key));
                }
            }
            System.out.println("_______________");

            
            System.out.println("-----Menu-----");
            System.out.println("A: Add a date to collection");
            System.out.println("B: Compare dates by name in collection");
            System.out.println("C: Compare dates by input");
            
            System.out.print("Choice:");
            String letter = stdin.next();
            option(letter, dateCollection,stdin);

            
            System.out.println("Continue? Y/N");
            String input = stdin.next();
            if(input.equals("N")){
                running = false;
            }
            System.out.println("<<<<>>>>" + "\n");
        }
        stdin.close();
    }
    
    public static void option(String letter, HashMap<String,String> collection, Scanner in) throws Exception{
        if(letter.equals("A")){
            System.out.print("Add a Date: ");
            String date = in.next();
            System.out.print("Add a label to date: ");
            String key = in.next();
            collection.put(key,date);

        }else if(letter.equals("B")){
            if(collection.isEmpty()){
                System.out.println("ERROR: Collection is empty, Try adding some dates first");
            }else{
                System.out.println("Choose from available dates");
                System.out.print("label 1: ");
                String label1 = in.next();
                System.out.print("label 2:");
                String label2 = in.next();
                System.out.println("The dates are " + daysBetweenDates(collection.get(label1), collection.get(label2)) + " days apart");
            }

        }else if(letter.equals("C")){
            System.out.println("Create your Dates");
            System.out.print("Date 1: ");
            String Date1 = in.next();
            System.out.print("Date 2: ");
            String Date2 = in.next();
            int days = daysBetweenDates(Date1, Date2);
            if(days == -1){
                System.out.println("ERROR: please input with format MM-dd-YYYY");
            }else{
                System.out.println("The dates are " + days + " days apart");
            }
        }else{
            System.out.println("ERROR: Please input A , B , C");
        }
    }


    public static int daysBetweenDates(String date1, String date2) throws Exception {
        
        if(!isValidDate(date1, date2)){
            return -1;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/d/uuuu", Locale.ENGLISH);
        LocalDate one = LocalDate.parse(date1, formatter);
        LocalDate two = LocalDate.parse(date2, formatter);

	    return Math.abs((int)ChronoUnit.DAYS.between(one, two));
    }

    public static boolean isValidDate(String date1, String date2) throws Exception{
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/DD/YYYY");
        try {
            dateFormat.parse(date1.trim());
        } catch (ParseException pe) {
            return false;
        }
        try {
            dateFormat.parse(date2.trim());
        } catch (ParseException pe) {
            return false;
        }
        return true;
    }

   
}