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
 * @author Tobias Riegel
 *
 */
@Startup
@Singleton
public class DataBuilder {

	private static final Logger logger = Logger.getLogger(DataBuilder.class);

	private static int CourseID;

	@PersistenceContext
	private EntityManager em;

	@PostConstruct
	private void init() {
		ICourse klasse = em.find(Course.class, CourseID);
		if(klasse==null) {
			//Course noch nicht vorhanden, also neu anlegen mit Schülern, Lehrer, Unterricht, Fach und Hausaufgabe
			ITeacher albus = new Teacher("Dumbledore", "Albus", "test", 'm', new Course());
			klasse = new Course(1, 'a', albus);
			this.CourseID = klasse.getCourseID();
			albus.setCourse(klasse);			
			
			IPupil harry = new Pupil("Potter","Harry", "Hedwig", 'm', klasse);
			IPupil ron = new Pupil("Wesley", "Ron", "RW", 'm', klasse);
			IPupil lavander = new Pupil("Brown", "Lavender", "LB", 'w', klasse);
			IPupil hermine = new Pupil( "Granger", "Hermine","HG", 'w', klasse);
			IPupil parvati = new Pupil("Patil", "Parvati", "PP", 'm', klasse);
			IPupil seamus = new Pupil("Finnigan", "Seamus", "SF", 'm', klasse);
			IPupil neville = new Pupil("Longbottom", "Neville", "NL", 'm', klasse);
			IPupil dean = new Pupil("Thomas", "Dean", "DT", 'm', klasse);
			
			klasse.addNewPupil(harry);
			klasse.addNewPupil(ron);
			klasse.addNewPupil(lavander);
			klasse.addNewPupil(hermine);
			klasse.addNewPupil(parvati);
			klasse.addNewPupil(seamus);
			klasse.addNewPupil(neville);
			klasse.addNewPupil(dean);		
					
			IRoom room1 = new Room("D101");
			IRoom room2 = new Room("D102");
			
			ISubject mathe = new Subject("Mathe");
			
			ILesson lesson1 = new Lesson(1, new Date(2011,05,28), klasse, albus, mathe, room1);
			klasse.addNewLesson(lesson1);
			albus.addNewLesson(lesson1);
			room1.addNewLesson(lesson1);
			
			IHomework homework1 = new Homework("Arbeitsheft S.30 Aufgabe 4,5,6", lesson1);
			lesson1.addNewHomework(homework1);
			
			em.persist(klasse);
			logger.info("Neu angelegt " + klasse);
			em.persist(albus);
			logger.info("Neu angelegt " + albus);
			em.persist(klasse);
			logger.info("Neu angelegt " + klasse);
			em.persist(harry);
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
			em.persist(room1);
			logger.info("Neu angelegt " + room1);
			em.persist(room2);
			logger.info("Neu angelegt " + room2);
			em.persist(mathe);
			logger.info("Neu angelegt " + mathe);
			em.persist(lesson1);
			logger.info("Neu angelegt " + lesson1);
			em.persist(homework1);
			logger.info("Neu angelegt " + homework1);
		}
	}
}
