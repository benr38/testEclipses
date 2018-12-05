package fr.uga.projet1;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class App {
	public static void main(String[] args) {
		try {
//			CompteB cb1 = new CompteB("AAA", 400);
//			CompteB cb2 = new CompteB("BBB", 300);
//			int resComp = cb1.compareTo(cb2);
//			System.out.println("resComp = "+resComp);
//			List<CompteB> lc = new ArrayList<>();
//			lc.add(cb1);
//			lc.add(cb2);
//			
//			List<CompteB> lc2 = Arrays.asList(cb1, cb2);
//			Collections.sort(lc2);
//			System.out.println("Apres tri croissant :");
//			for (CompteB cb: lc2) {
//				System.out.println(cb);
//			}
//			
//			lc2.sort(new CompSoldeDec());
//			System.out.println("Apres tri décroissant :");
//			for (CompteB cb: lc2) {
//				System.out.println(cb);
//			}
//			
//			List<Contact> contacts = 
//					Arrays.asList(new Contact(1,"toto",45), 
//								  new Contact(2,"titi",1));
//			ExportTools.exportCsv("contacts.csv", contacts);
//			System.out.println("Export OK");
			
			//java < 8
			Date d1= new Date(); //date du jour
			Calendar cl = Calendar.getInstance();
			System.out.println(cl.getTime());
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
			System.out.println(sdf);

			//java 8
			LocalDate loDate1 = LocalDate.now();
			System.out.println("loDate1 = "+ loDate1);
			DateTimeFormatter dtf =  DateTimeFormatter.ofPattern("dd/MM/yy");
			System.out.println(dtf);
			LocalDate loDate3 = LocalDate.of(2018,12,5);
			
			//copie de dates
			LocalDate loDate4 = LocalDate.from(loDate3);
			System.out.println(loDate4);
			  //Period __________________________________________________
            //représentation humaine d'une durée
            //exemple : 1 mois (qu'il y ait 28 ou 31jours)
            Period period1 = Period.ofMonths(3);
            
            //moins précis que duration
            Period period2 = Period.between(LocalDate.of(2018, Month.JULY, 28), LocalDate.of(2018, Month.SEPTEMBER, 3));
            System.out.println("period2(totalMonth) = " + period2.toTotalMonths());

            	//date sql => localDate
                        java.sql.Date d1sql = new java.sql.Date(10000);
                        Date d1Convertie = new Date(d1sql.getTime());
                        //Ou : 
                        Date d2Convertie = Date.from(Instant.ofEpochMilli(d1sql.getTime()));
                        
			//duration
			Duration duration1 = Duration.ofDays(5);
	        Duration duration2 = Duration.of(15,  ChronoUnit.DAYS);
	        
	        
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
