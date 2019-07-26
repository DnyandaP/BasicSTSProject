import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.sql.Date;

public class Main {
	public static void main(String[] args) throws Exception {
	      String strTime = "20:15:40";
	      String endTime ="23:10:1";
	      String[] arrOfStr = strTime.split(":", 2);
	      int i = Integer.parseInt(arrOfStr[0]);
	      String[] arrOfStr1 = endTime.split(":", 2);
	      int j = Integer.parseInt(arrOfStr1[0]);
	      long millis=System.currentTimeMillis();  
	        //java.sql.Date date=;
	      System.out.println(new java.sql.Date(millis));
	      while(i<j) {
	      System.out.println(i++);
	      System.out.println(i+":"+arrOfStr[1]);
	      }
	      //System.out.println(i);
	     // for (String a : arrOfStr) 
	       //     System.out.println(a);
	   }
}
