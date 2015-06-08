package de.studeasy.dao;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.logging.Logger;

import de.studeasy.common.ICourse;
import de.studeasy.common.IHomework;
import de.studeasy.common.ILesson;
import de.studeasy.common.IPupil;
import de.studeasy.common.IRoom;
import de.studeasy.common.ISubject;
import de.studeasy.common.ITeacher;
import de.studeasy.entities.Course;
import de.studeasy.entities.Homework;
import de.studeasy.entities.Lesson;
import de.studeasy.entities.Pupil;
import de.studeasy.entities.Room;
import de.studeasy.entities.Subject;
import de.studeasy.entities.Teacher;

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
			ITeacher anna = new Teacher("Musterfrau", "Anna", "test", 'w', new Course());
			klasse = new Course(7, 'a', anna);
			this.CourseID = klasse.getCourseID();
			anna.setCourse(klasse);			
			
			IPupil harry = new Pupil("Potter","Harry", "Hedwig", 'm', klasse);
			IPupil ron = new Pupil("Wesley", "Ron", "Hermine", 'w', klasse);
			klasse.addNewPupil(harry);
			klasse.addNewPupil(ron);
			
			IRoom room1 = new Room("D101");
			
			ISubject mathe = new Subject("Mathe");
			
			ILesson lesson1 = new Lesson(1, new Date(2011,05,28), klasse, anna, mathe, room1);
			klasse.addNewLesson(lesson1);
			anna.addNewLesson(lesson1);
			room1.addNewLesson(lesson1);
			
			IHomework homework1 = new Homework("Arbeitsheft S.30 Aufgabe 4,5,6", lesson1);
			lesson1.addNewHomework(homework1);
			
			em.persist(klasse);
			logger.info("Neu angelegt" + klasse);
			em.persist(anna);
			logger.info("Neu angelegt" + anna);
			em.persist(klasse);
			logger.info("Neu angelegt" + klasse);
			em.persist(harry);
			logger.info("Neu angelegt" + harry);
			em.persist(ron);
			logger.info("Neu angelegt" + ron);
			em.persist(room1);
			logger.info("Neu angelegt" + room1);
			em.persist(mathe);
			logger.info("Neu angelegt" + mathe);
			em.persist(lesson1);
			logger.info("Neu angelegt" + lesson1);
			em.persist(homework1);
			logger.info("Neu angelegt" + homework1);
		}
	}
}
