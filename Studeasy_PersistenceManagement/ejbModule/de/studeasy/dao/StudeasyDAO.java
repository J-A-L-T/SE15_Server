package de.studeasy.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.studeasy.entities.*;
import de.studeasy.systeminterfaces.ICourse;
import de.studeasy.systeminterfaces.IHomework;
import de.studeasy.systeminterfaces.ILesson;
import de.studeasy.systeminterfaces.IPerson;
import de.studeasy.systeminterfaces.IRoom;
import de.studeasy.systeminterfaces.ISubject;

/**
 * Das StudeasyDAO ist eine Stateless Session Bean, die
 * sich um den Zugriff auf die Datenbank kümmert.
 * @author Tobias Riegel
 *
 */
@Stateless
public class StudeasyDAO implements IStudeasyDAO {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public ICourse findCourseByID(int id) {
		return em.find(Course.class, id);
	}

	@Override
	public IHomework findHomeworkByID(int id) {
		return em.find(Homework.class, id);
	}
	
	public boolean removeHomeworkByID(int homeworkID) {
		IHomework homework = findHomeworkByID(homeworkID);
		
		if (homework!=null) {
			em.remove(homework);
			return true;
		}
		else
			return false;
	}

	@Override
	public ILesson findLessonByID(int id) {
		return em.find(Lesson.class, id);
	}

	@Override
	public IPerson findPersonByID(int id) {
		return em.find(Person.class, id);
	}

	@Override
	public IRoom findRoomByID(String id) {
		return em.find(Room.class, id);
	}

	@Override
	public ISubject findSubjectByID(int id) {
		return em.find(Subject.class, id);
	}

	@Override
	public StudeasySession findSessionByID(int id) {
		return em.find(StudeasySession.class, id);
	}

	@Override
	public int createSession(IPerson user) {
		StudeasySession newSession = new StudeasySession(user);
		em.persist(newSession);
		return newSession.getId();
	}

	@Override
	public void closeSession(int id) {
		StudeasySession session = em.find(StudeasySession.class, id);
		em.remove(session);
	}

}
