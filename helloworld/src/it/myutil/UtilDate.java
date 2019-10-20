package it.myutil;

import java.time.*;
import java.time.format.*;

/* GESTIRE LE ECCEZIONI DEL PARSE!!!*/

public class UtilDate {
		
	public final static String DATE_TIME_FORMAT = "dd/MM/yyyy HH:mm";
	public final static String DATE_FORMAT = "dd/MM/yyyy";
	public final static String TIME_FORMAT = "HH:mm";
	
	public final static String PARSE_EXCEPTION = "[ATTENZIONE] Dato inserito in un formato non corretto!";
		
	public static LocalDateTime setDataOra(String MSG){
		String s = InputDati.leggiStringaNonVuota(MSG+" ("+DATE_TIME_FORMAT+") ");
		DateTimeFormatter dtformat = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT);
		LocalDateTime date = null;
	
		try{
			date = LocalDateTime.parse(s, dtformat);
		}
		catch(DateTimeParseException dtp){
			System.out.println(PARSE_EXCEPTION);
			setDataOra(MSG);
		}
		
		
		return date;
		
	}
	
	public static LocalDate setData(String MSG_ORA){
		
		String s = InputDati.leggiStringaNonVuota(MSG_ORA +" ("+DATE_FORMAT+") ");
		
		DateTimeFormatter dformat = DateTimeFormatter.ofPattern(DATE_FORMAT);
		LocalDate date = null;
		
		try{
			date = LocalDate.parse(s, dformat);
		}
		catch(DateTimeParseException dtp){
			System.out.println("[ParseException]");
			setData(MSG_ORA);
		}
		

		return date;
	}
	
	public static LocalTime setOra(String MSG_ORA){
		
		
		String s = InputDati.leggiStringaNonVuota(MSG_ORA+" ("+TIME_FORMAT+") ");
		
		DateTimeFormatter tformatter = DateTimeFormatter.ofPattern(TIME_FORMAT);
		LocalTime time = null;
		
		try{
			time = LocalTime.parse(s, tformatter);	
		}
		catch(DateTimeParseException e){
			System.out.println(PARSE_EXCEPTION);
			setOra(MSG_ORA);
		}

		return time;
	}
	
	//DA RIFARE
	public static void StampaDataOra(LocalDateTime data){
		DateTimeFormatter dtformat = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT);
		System.out.println(data.format(dtformat));
	}

	public static String toStringDateTime(LocalDateTime data){
		DateTimeFormatter dtformat = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT);
		return data.format(dtformat);
	}
	
	public static String toStringDate(LocalDate data){
		DateTimeFormatter dformat = DateTimeFormatter.ofPattern(DATE_FORMAT);
		return data.format(dformat);
	}
}


