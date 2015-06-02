package de.studeasy.schedulemanager;

import java.util.ArrayList;


import java.util.Date;
import java.util.logging.Logger;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;

import de.studeasy.common.*;
import de.studeasy.entities.Course;
import de.studeasy.entities.Homework;
import de.studeasy.entities.Lesson;
import de.studeasy.entities.Pupil;
import de.studeasy.entities.Room;
import de.studeasy.entities.Subject;
import de.studeasy.entities.Teacher;

public class StudeasyScheduleSystemMain {

	private static Logger jlog =  Logger.getLogger(StudeasyScheduleSystemMain.class.getPackage().getName());
	
	/**
	 * Diese Main-Methode startet den Server-Teil des StudeasyServices
	 * @param args
	 */
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		//erzeuge ein paar Beispieldaten zu Teacher und Pupil die verwendeten Konstruktoren registrieren die 
		//erzeugten Objekte in zentralen Registries, sodass sie bei spaeteren Client-Requests wiedergefunden 
		//werden koennen.
		
		System.setSecurityManager(new RMISecurityManager());
		
		
		
		Course klasse = new Course();
		Homework homework1 = new Homework();
		Lesson lesson1 = new Lesson();
		Pupil max = new Pupil();
		Pupil moriz = new Pupil();
		Room room1 = new Room();
		Subject mathe = new Subject();
		Teacher anna = new Teacher();
		
		
		
		ArrayList<IPupil> pupils = new ArrayList<IPupil>();
		
		pupils.add(max);
		pupils.add(moriz);
		
		ArrayList<ILesson> lessons = new ArrayList<ILesson>();	
		
		lessons.add(lesson1);
		
		//Course "Klasse"
		klasse.setClassTeacher(anna);
		klasse.setCourseID(1);
		klasse.setGrade(7);        //Grade + Descriptor ergeben die KLassenbezeichnung
		klasse.setDescriptor('a');
		klasse.setLessons(lessons);
		klasse.setPupils(pupils);
		
		
		//Homework
		homework1.setDescription("Arbeitsheft S.30 Aufgabe 4,5,6");
		homework1.setHomeworkID(1);
		homework1.setLesson(lesson1);
				
				
		//Lessson genaue Stunde im
		lesson1.setRoom(room1);
		lesson1.setTeacher(anna);
		lesson1.setCourse(klasse);
		lesson1.setDate(new Date(2011,05,28) );
		lesson1.setLessonHour(1);
		lesson1.setSubject(mathe);
		lesson1.setLessonID(1);
		
		
				
		//Pupil
		max.setCourse(klasse);
		max.setFirstname("Max");
		max.setGender('m');
		max.setName("Mustermann");
		max.setPassword("Max1");
		max.setPersonID(2);
		moriz.setCourse(klasse);
		moriz.setFirstname("moriz");
		moriz.setGender('m');
		moriz.setName("Mustermann");
		moriz.setPassword("moriz1");
		moriz.setPersonID(3);
		
		
		//Room
		room1.setRoomID("D101");
		room1.setLessons(lessons);
		
		
		//Subject das Fach
		mathe.setDescription("Mathe");
		mathe.setSubjectID(1);
		
				
		//Teacher
		anna.setPersonID(7);
		anna.setName("Musterfrau");
		anna.setFirstname("Anna");
		anna.setGender('w');
		anna.setCourse(klasse);
		anna.setLessons(lessons);
		anna.setPassword("test");
		anna.setPersonID(1);
		
		
		try {
			//starte die Java RMI Registry:
	    	Registry registry = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
	    	jlog.log(Level.FINE, "Registry gestartet: "+ registry);
	    	
	    	//lass Java zum Remote-Objekt StudeasyScheduleServiceImpl die fuer die Netzwerkkommunikation erforderlichen Stub und Skeleton generieren:
	    	StudeasyScheduleService studeasyServiceStub = (StudeasyScheduleService) UnicastRemoteObject.exportObject(new StudeasyScheduleService(),0);
		
	    	//veroeffentliche das vorbereitete Remote-Objekt und einer eindeutigen ID in der Registry:
	    	registry.rebind(StudeasyScheduleService.INTERFACE_ID, studeasyServiceStub);
	    	jlog.log(Level.FINE, "Interface in Registry angemeldet. Warte auf Requests...");
		}
	catch (RemoteException ex) {
	    jlog.log(Level.SEVERE, ex.getMessage(), ex);
	}		
				
		

	}

}
