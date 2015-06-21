package de.studeasy.dao;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.logging.Logger;

import de.studeasy.entities.Course;
import de.studeasy.entities.Homework;
import de.studeasy.entities.Lesson;
import de.studeasy.entities.Pupil;
import de.studeasy.entities.Room;
import de.studeasy.entities.Subject;
import de.studeasy.entities.Teacher;
import de.studeasy.systeminterfaces.ICourse;
import de.studeasy.systeminterfaces.IHomework;
import de.studeasy.systeminterfaces.ILesson;
import de.studeasy.systeminterfaces.IPupil;
import de.studeasy.systeminterfaces.IRoom;
import de.studeasy.systeminterfaces.ISubject;
import de.studeasy.systeminterfaces.ITeacher;

/**
 * Der DataBuilder ist eine Singelton Session Bean und wird bei dem Start des
 * Servers aufgerufen, um Testdaten zu erzeugen.
 * 
 * @author Tobias Riegel, Andreas Prischep
 *
 */
@Startup
@Singleton
public class DataBuilder {

	private static final Logger logger = Logger.getLogger(DataBuilder.class);
	
	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("deprecation")
	@PostConstruct
	private void init() {
		if(em.find(Teacher.class, 111111)==null) {
			
			ICourse klasse1 = new Course(1, 'a');
			
			//Course noch nicht vorhanden, also neu anlegen mit Schülern, Lehrer, Unterricht, Fach und Hausaufgabe
			ITeacher albus = new Teacher(111111, "Dumbledore", "Albus", "ad", 'm');	
			ITeacher mcgonagall = new Teacher(158792, "McGonagall", "Minerva", "mm", 'w');			
			ITeacher snape = new Teacher(136661, "Snape", "Severus", "ss", 'm');
			
			IPupil harry = new Pupil(259007, "Potter","Harry", "Hedwig", 'm', klasse1);
			IPupil ron = new Pupil(267891, "Wesley", "Ron", "rw", 'm', klasse1);
			IPupil lavander = new Pupil(257631,"Brown", "Lavender", "lb", 'w', klasse1);
			IPupil hermine = new Pupil(276431, "Granger", "Hermine","hg", 'w', klasse1);
			IPupil parvati = new Pupil(294631, "Patil", "Parvati", "pp", 'm', klasse1);
			IPupil seamus = new Pupil(289643, "Finnigan", "Seamus", "sf", 'm', klasse1);
			IPupil neville = new Pupil(246792, "Longbottom", "Neville", "nl", 'm', klasse1);
			IPupil dean = new Pupil(256791, "Thomas", "Dean", "dt", 'm', klasse1);
			
			klasse1.addNewPupil(harry);
			klasse1.addNewPupil(ron);
			klasse1.addNewPupil(lavander);
			klasse1.addNewPupil(hermine);
			klasse1.addNewPupil(parvati);
			klasse1.addNewPupil(seamus);
			klasse1.addNewPupil(neville);
			klasse1.addNewPupil(dean);		
					
			IRoom room1 = new Room("D101");
			IRoom room2 = new Room("D102");
			IRoom room3 = new Room("D103");
			
			ISubject spanisch = new Subject(1, "Spanisch");
			ISubject deutsch = new Subject(2, "Deutsch");
			ISubject religion = new Subject(3, "Religion");
			ISubject mathe = new Subject(4, "Mathe");
			ISubject physik = new Subject(5, "Physik");
			ISubject chemie = new Subject(6, "Chemie");
			ISubject sport = new Subject(7, "Sport");
			ISubject englisch = new Subject(8, "Englisch");
			ISubject info = new Subject(9, "Info");
			ISubject biologie = new Subject(10, "Biologie");	
			
			//---------------------------------DAY1----------------------------------------------
			
			ILesson lesson11 = new Lesson(1, new Date(2015-1900,5,22), klasse1, albus, mathe, room1);
			klasse1.addNewLesson(lesson11);
			albus.addNewLesson(lesson11);
			room1.addNewLesson(lesson11);
			
			ILesson lesson12 = new Lesson(2, new Date(2015-1900,5,22), klasse1, albus, deutsch, room1);
			klasse1.addNewLesson(lesson12);
			albus.addNewLesson(lesson12);
			room1.addNewLesson(lesson12);
			
			ILesson lesson14 = new Lesson(4, new Date(2015-1900,5,22), klasse1, mcgonagall, spanisch, room1);
			klasse1.addNewLesson(lesson14);
			mcgonagall.addNewLesson(lesson14);
			room1.addNewLesson(lesson14);
			
			ILesson lesson15 = new Lesson(5, new Date(2015-1900,5,22), klasse1, mcgonagall, biologie, room2);
			klasse1.addNewLesson(lesson15);
			mcgonagall.addNewLesson(lesson15);
			room2.addNewLesson(lesson15);
			
			ILesson lesson16 = new Lesson(6, new Date(2015-1900,5,22), klasse1, mcgonagall, biologie, room2);
			klasse1.addNewLesson(lesson16);
			mcgonagall.addNewLesson(lesson16);
			room2.addNewLesson(lesson16);
			

			//---------------------------------DAY2----------------------------------------------
			ILesson lesson21 = new Lesson(1, new Date(2015-1900,5,23), klasse1, mcgonagall, englisch, room1);
			klasse1.addNewLesson(lesson21);
			mcgonagall.addNewLesson(lesson21);
			room1.addNewLesson(lesson21);
			
			ILesson lesson22 = new Lesson(2, new Date(2015-1900,5,23), klasse1, albus, mathe, room1);
			klasse1.addNewLesson(lesson22);
			albus.addNewLesson(lesson22);
			room1.addNewLesson(lesson22);
			
			ILesson lesson23 = new Lesson(3, new Date(2015-1900,5,23), klasse1, mcgonagall, chemie, room2);
			klasse1.addNewLesson(lesson23);
			mcgonagall.addNewLesson(lesson23);
			room2.addNewLesson(lesson23);
			
			ILesson lesson25 = new Lesson(5, new Date(2015-1900,5,23), klasse1, albus, physik, room2);
			klasse1.addNewLesson(lesson25);
			albus.addNewLesson(lesson25);
			room2.addNewLesson(lesson25);
			
			ILesson lesson26 = new Lesson(6, new Date(2015-1900,5,23), klasse1, snape, info, room1);
			klasse1.addNewLesson(lesson26);
			snape.addNewLesson(lesson26);
			room1.addNewLesson(lesson26);
			
			//---------------------------------DAY3----------------------------------------------
			ILesson lesson31 = new Lesson(1, new Date(2015-1900,5,24), klasse1, mcgonagall, chemie, room2);
			klasse1.addNewLesson(lesson31);
			mcgonagall.addNewLesson(lesson31);
			room1.addNewLesson(lesson31);
			
			ILesson lesson32 = new Lesson(2, new Date(2015-1900,5,24), klasse1, albus, deutsch, room1);
			klasse1.addNewLesson(lesson32);
			albus.addNewLesson(lesson32);
			room1.addNewLesson(lesson32);
			
			ILesson lesson33 = new Lesson(3, new Date(2015-1900,5,24), klasse1, mcgonagall, biologie, room2);
			klasse1.addNewLesson(lesson33);
			mcgonagall.addNewLesson(lesson33);
			room2.addNewLesson(lesson33);
			
			ILesson lesson34 = new Lesson(4, new Date(2015-1900,5,24), klasse1, snape, sport, room3);
			klasse1.addNewLesson(lesson34);
			snape.addNewLesson(lesson34);
			room3.addNewLesson(lesson34);
			
			ILesson lesson35 = new Lesson(5, new Date(2015-1900,5,24), klasse1, mcgonagall, englisch, room1);
			klasse1.addNewLesson(lesson35);
			mcgonagall.addNewLesson(lesson35);
			room1.addNewLesson(lesson35);
			
			ILesson lesson36 = new Lesson(6, new Date(2015-1900,5,24), klasse1, snape, religion, room1);
			klasse1.addNewLesson(lesson36);
			snape.addNewLesson(lesson36);
			room1.addNewLesson(lesson36);
			//---------------------------------DAY4----------------------------------------------
			
			ILesson lesson43 = new Lesson(3, new Date(2015-1900,5,25), klasse1, mcgonagall, englisch, room1);
			klasse1.addNewLesson(lesson43);
			mcgonagall.addNewLesson(lesson43);
			room1.addNewLesson(lesson43);
			
			ILesson lesson44 = new Lesson(4, new Date(2015-1900,5,23), klasse1, snape, info, room1);
			klasse1.addNewLesson(lesson44);
			snape.addNewLesson(lesson44);
			room1.addNewLesson(lesson44);
			
			ILesson lesson45 = new Lesson(5, new Date(2015-1900,5,22), klasse1, mcgonagall, spanisch, room1);
			klasse1.addNewLesson(lesson45);
			mcgonagall.addNewLesson(lesson45);
			room1.addNewLesson(lesson45);
			
			ILesson lesson46 = new Lesson(6, new Date(2015-1900,5,23), klasse1, albus, physik, room2);
			klasse1.addNewLesson(lesson46);
			albus.addNewLesson(lesson46);
			room2.addNewLesson(lesson46);
			
			//---------------------------------DAY5----------------------------------------------
			ILesson lesson51 = new Lesson(1, new Date(2015-1900,5,24), klasse1, mcgonagall, biologie, room2);
			klasse1.addNewLesson(lesson51);
			mcgonagall.addNewLesson(lesson51);
			room2.addNewLesson(lesson51);
			
			ILesson lesson52 = new Lesson(2, new Date(2015-1900,5,23), klasse1, albus, mathe, room1);
			klasse1.addNewLesson(lesson52);
			albus.addNewLesson(lesson52);
			room1.addNewLesson(lesson52);
			
			ILesson lesson53 = new Lesson(3, new Date(2015-1900,5,24), klasse1, albus, deutsch, room1);
			klasse1.addNewLesson(lesson53);
			albus.addNewLesson(lesson53);
			room1.addNewLesson(lesson53);
			
			ILesson lesson54 = new Lesson(4, new Date(2015-1900,5,24), klasse1, snape, sport, room3);
			klasse1.addNewLesson(lesson54);
			snape.addNewLesson(lesson54);
			room3.addNewLesson(lesson54);
			
			ILesson lesson55 = new Lesson(5, new Date(2015-1900,5,24), klasse1, snape, religion, room1);
			klasse1.addNewLesson(lesson55);
			snape.addNewLesson(lesson55);
			room1.addNewLesson(lesson55);
			
			//--------------------------------------Homework----------------------------------------
			IHomework homework1 = new Homework("Arbeitsheft S.30 Aufgabe 4,5,6", lesson11);
			lesson11.addNewHomework(homework1);
			
			//LOGDATEN
			
			//-----TEACHER-----
			logger.info("TEACHER werden angelegt ----------------------");
			em.persist(albus);
			logger.info("Neu angelegt " + albus);
			em.persist(seamus);
			logger.info("Neu angelegt " + seamus);
			//-----klasse1-----
			logger.info("klasse1 wird angelegt ----------------------");
			em.persist(klasse1);
			logger.info("Neu angelegt " + klasse1);
			
			//-----PUPIL-----
			logger.info("PUPIL werden angelegt ----------------------");
			logger.info("Neu angelegt " + harry);
			em.persist(ron);
			logger.info("Neu angelegt " + ron);
			em.persist(lavander);
			logger.info("Neu angelegt " + lavander);
			em.persist(hermine);
			logger.info("Neu angelegt " + hermine);
			em.persist(parvati);
			logger.info("Neu angelegt " + parvati);
			em.persist(seamus);
			logger.info("Neu angelegt " + seamus);
			em.persist(neville);
			logger.info("Neu angelegt " + neville);
			em.persist(dean);
			logger.info("Neu angelegt " + dean);
			
			
			//-----ROOM-----
			logger.info("ROOM werden angelegt ----------------------");
			em.persist(room1);
			logger.info("Neu angelegt " + room1);
			em.persist(room2);
			logger.info("Neu angelegt " + room2);
			em.persist(room3);
			logger.info("Neu angelegt " + room3);
			
			//-----SUBJEKT-----
			logger.info("SUBJEKT werden angelegt ----------------------");
			em.persist(mathe);
			logger.info("Neu angelegt " + mathe);
			em.persist(deutsch);
			logger.info("Neu angelegt " + deutsch);
			em.persist(spanisch);
			logger.info("Neu angelegt " + spanisch);
			em.persist(biologie);
			logger.info("Neu angelegt " + biologie);
			em.persist(info);
			logger.info("Neu angelegt " + info);
			em.persist(englisch);
			logger.info("Neu angelegt " + englisch);
			em.persist(chemie);
			logger.info("Neu angelegt " + chemie);
			em.persist(physik);
			logger.info("Neu angelegt " + physik);
			em.persist(sport);
			logger.info("Neu angelegt " + sport);
			em.persist(religion);
			logger.info("Neu angelegt " + religion);
			//-----LESSON-DAY1-----
			logger.info("LESSON DAY1 werden angelegt ----------------------");
			em.persist(lesson11);
			logger.info("Neu angelegt " + lesson11);
			
			em.persist(lesson12);
			logger.info("Neu angelegt " + lesson12);
			em.persist(lesson14);
			logger.info("Neu angelegt " + lesson14);
			em.persist(lesson15);
			logger.info("Neu angelegt " + lesson15);
			em.persist(lesson16);
			logger.info("Neu angelegt " + lesson16);
			
			//-----LESSON-DAY2-----
			logger.info("LESSON DAY2 werden angelegt ----------------------");
			em.persist(lesson21);
			logger.info("Neu angelegt " + lesson21);
			em.persist(lesson22);
			logger.info("Neu angelegt " + lesson22);
			em.persist(lesson23);
			logger.info("Neu angelegt " + lesson23);
			em.persist(lesson25);
			logger.info("Neu angelegt " + lesson25);
			em.persist(lesson26);
			logger.info("Neu angelegt " + lesson26);
			
			//-----LESSON-DAY3-----
			logger.info("LESSON DAY3 werden angelegt ----------------------");
			em.persist(lesson31);
			logger.info("Neu angelegt " + lesson31);
			em.persist(lesson32);
			logger.info("Neu angelegt " + lesson32);
			em.persist(lesson33);
			logger.info("Neu angelegt " + lesson33);
			em.persist(lesson34);
			logger.info("Neu angelegt " + lesson34);
			em.persist(lesson35);
			logger.info("Neu angelegt " + lesson35);
			em.persist(lesson36);
			logger.info("Neu angelegt " + lesson36);
			
			//-----LESSON-DAY4-----
			logger.info("LESSON DAY4 werden angelegt ----------------------");
			em.persist(lesson43);
			logger.info("Neu angelegt " + lesson43);
			em.persist(lesson44);
			logger.info("Neu angelegt " + lesson44);
			em.persist(lesson45);
			logger.info("Neu angelegt " + lesson45);
			em.persist(lesson46);
			logger.info("Neu angelegt " + lesson46);
			
			//-----LESSON-DAY5-----
			logger.info("LESSON DAY5 werden angelegt ----------------------");
			em.persist(lesson51);
			logger.info("Neu angelegt " + lesson51);
			em.persist(lesson52);
			logger.info("Neu angelegt " + lesson52);
			em.persist(lesson53);
			logger.info("Neu angelegt " + lesson53);
			em.persist(lesson54);
			logger.info("Neu angelegt " + lesson54);
			em.persist(lesson55);
			logger.info("Neu angelegt " + lesson55);
			
			//-----HOMEWORK-----
			logger.info("HOMEWORK werden angelegt ----------------------");
			em.persist(homework1);
			logger.info("Neu angelegt " + homework1);
		}
		
		
		
	}
}
