package de.studeasy.util;

import java.util.Date;

/**
 * 
 * @author Tobias Riegel
 *
 */
public class DateStringConverter {
	
	@SuppressWarnings("deprecation")
	public static Date makeStringToDate(String date) {
		int day, month, year;
		//führende 0 abfangen beim Tag
		if(date.charAt(0)!='0')
			day = Integer.parseInt(date.substring(0, 2));
		else
			day = Integer.parseInt(date.substring(1, 2));
		
		//führende 0 abfangen beim Monat
		if(date.charAt(2)!='0')
			month = Integer.parseInt(date.substring(2, 4));
		else
			month = Integer.parseInt(date.substring(3, 4));
		
		year = Integer.parseInt(date.substring(4));
		
		Date d = new Date(year-1900, month-1, day);
		return d;
	}
	
	//String dann "ttmmjjjj"
	@SuppressWarnings("deprecation")
	public static String makeDateToString(Date date) {
		String day, month, year, d;
		
		day = "" + date.getDate();
		//+1 da Januar als 0, Februar als 1 usw abgespeichert wird
		month = "" + (date.getMonth()+1);
		//Das Jahr wird als year-1900 abgespeichert 
		year = "" + (date.getYear()+1900);
		
		//Führende 0 einfügen
		if(day.length()==1)
			day = "0" + day;
		if(month.length()==1)
			month = "0" + month;
		
		d = day + month + year;
		return d;
	}
}
