import java.text.DateFormat;
import org.joda.time.LocalTime;

import com.team.medico.service.GenerateToken;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main {
	public static void main(String[] args) throws Exception {
//	      String strTime = "20:15:40";
//	      String endTime ="23:10:1";
//	      String[] arrOfStr = strTime.split(":", 2);
//	      int i = Integer.parseInt(arrOfStr[0]);
//	      String[] arrOfStr1 = endTime.split(":", 2);
//	      int j = Integer.parseInt(arrOfStr1[0]);
//	      long millis=System.currentTimeMillis();  
//	        //java.sql.Date date=;
//	      System.out.println(new java.sql.Date(millis));
//	      while(i<j) {
//	      System.out.println(i++);
//	      System.out.println(i+":"+arrOfStr[1]);
//	      }
//	      //System.out.println(i);
//	     // for (String a : arrOfStr) 
//	       //     System.out.println(a);
		
//		  Calendar cal = Calendar.getInstance();
//	        Date date=cal.getTime();
//	        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
//	        String later=dateFormat.format(date);
//	        LocalTime earlierTable = new LocalTime("11:03:34");
//	        System.out.println(earlierTable);
//	        LocalTime current = new LocalTime(later);
//	        System.out.println(current);
//
//	        System.out.println(earlierTable.compareTo(current));
//	     
		
		GenerateToken gen = new GenerateToken();
		gen.getToken("d");
	}
}
