import java.text.ParseException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class test{
    public static void main(String[] args) throws ParseException{
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
            System.out.println("B: Compare dates by input");
            System.out.println("C: Compare dates by name in collection");
            System.out.print("Choice:");
            String letter = stdin.next();
            option(letter, dateCollection);

            
            System.out.println("Continue? Y/N");
            String input = stdin.next();
            if(input.equals("N")){
                running = false;
            }
            System.out.println("<<<<>>>>" + "\n");
        }
        stdin.close();
    }
    
    public static void option(String letter, HashMap<String,String> collection){
        Scanner in = new Scanner(System.in);
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
            System.out.print("Date 2:");
            String Date2 = in.next();
            System.out.println("The dates are " + daysBetweenDates(Date1, Date2) + " days apart");
        }else{
            System.out.println("ERROR: Please input A , B , C");
        }
        in.close();
    }


    public static int daysBetweenDates(String date1, String date2) {
	    return Math.abs((int)ChronoUnit.DAYS.between(LocalDate.parse(date1), LocalDate.parse(date2)));
    }

   
}