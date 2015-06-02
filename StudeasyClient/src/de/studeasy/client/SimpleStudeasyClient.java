package de.studeasy.client;

import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.Set;
import java.util.Date;

import de.studeasy.common.ILesson;
import de.studeasy.common.IPupil;
import de.studeasy.common.IStudeasyScheduleService;



public class SimpleStudeasyClient {
	
	private static IStudeasyScheduleService remoteSystem;
	

	public static void main(String[] args) {
	
		try {
			   //In der folgenden Zeile wird ein SecurityManager gesetzt. Das ist erforderlich, wenn Klassendefinitionen
			   //vom Server geladen werden sollen. In unserem Beispiel sind das die Klassen KundeImpl und KontoImpl.
			   System.setSecurityManager(new RMISecurityManager());
			   
			   //Hole eine Referenz auf die Java RMI Registry
			   Registry registry = LocateRegistry.getRegistry();
		       System.out.println("Registry geladen: "+ registry);
		    	
			   //Frage die Registry nach einem Remote-Objekt fuer die Schnittstelle 'OnlineBankingSystem'
	 	       //remoteSystem = (XbankOnlineService)registry.lookup(XbankOnlineService.INTERFACE_ID);
	 	       
	 	       //Zeige, welche Referenz auf das Server-Objekt der Client erhalten hast:
	 	       System.out.println("Client hat folgendes Server-Objekt von der RMI-Registry erhalten:");
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
		   while (i<=stunden.size())
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

