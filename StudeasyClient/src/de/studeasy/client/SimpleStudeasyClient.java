package de.studeasy.client;

import java.util.List;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;

import de.studeasy.common.ILesson;
import de.studeasy.common.IStudeasyScheduleService;



public class SimpleStudeasyClient {
	
	private static IStudeasyScheduleService remoteSystem;
	

	public static void main(String[] args) {
	
		try {
			Context context = new InitialContext();
		       
		    //Lookup-String für eine EJB besteht aus: Name_EA/Name_EJB-Modul/Name_EJB-Klasse!Name_RemoteInterface
		    String lookupString = "ejb:StudeasyEAR/StudeasySystem/StudeasyScheduleService!de.studeasy.common.IStudeasyScheduleService";
		    remoteSystem = (IStudeasyScheduleService) context.lookup(lookupString);
	 	       
	 	    //Zeige, welche Referenz auf das Server-Objekt der Client erhalten hast:
	 	    System.out.println("Client hat folgendes Server-Objekt nach dem Lookup erhalten:");
	 	    System.out.println(remoteSystem.toString());
	 	    System.out.println();
	 	       
	 	    //Test-Szeanarien ausfuehren:
			szenarioMax();
			// szenarioJoe();		   	       
			// szenarioEmma();
			   
			}
			catch (Exception ex) {
			   	System.out.println(ex);
			}
		}
		
	
	 /**
     * Test-Szenario: Max meldet sich an und fragt seinen Stundenplan ab.
     */
	@SuppressWarnings("deprecation")
	private static void szenarioMax() {
		try {
		   System.out.println("============================================================");			
	       String sessionID = remoteSystem.login(2, "max1");
		   System.out.println("max hat sich angelemdet um seinen Stundenplan zu sehen");
		   
		   
		   List<ILesson> stunden = remoteSystem.getLessonsByDate(2,new Date(2011,05,28));
		   
		   int i =0;
		   while (i<stunden.size())
		   {
			   System.out.println(stunden.get(i));
			   i++;
		   }
		   remoteSystem.logout(sessionID);
		   System.out.println("Max hat sich abgemeldet.");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
		
		
		
		
		

	}

