package de.studeasy.dao;

import javax.ejb.Local;
import de.studeasy.entities.StudeasySession;
import de.studeasy.systeminterfaces.ICourse;
import de.studeasy.systeminterfaces.IHomework;
import de.studeasy.systeminterfaces.ILesson;
import de.studeasy.systeminterfaces.IPerson;
import de.studeasy.systeminterfaces.IRoom;
import de.studeasy.systeminterfaces.ISubject;

@Local
public interface IStudeasyDAO {
	
	public ICourse findCourseByID(int id);
	
	public IHomework findHomeworkByID(int id);
	
	public boolean removeHomeworkByID(int homeworkID);
	
	public ILesson findLessonByID(int id);
	
	public IPerson findPersonByID(int id);
	
	public IRoom findRoomByID(String id);
	
	public ISubject findSubjectByID(int id);
	
	public StudeasySession findSessionByID(int id);
	
	public int createSession(IPerson user);
	
	public void closeSession(int id);
}
