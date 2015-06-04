package de.studeasy.dao;

import javax.ejb.Local;

import de.studeasy.common.*;
import de.studeasy.entities.StudeasySession;

@Local
public interface IStudeasyDAO {
	
	public ICourse findCourseByID(int id);
	
	public IHomework findCHomeworkByID(int id);
	
	public boolean removeHomeworkByID(int homeworkID);
	
	public ILesson findLessonByID(int id);
	
	public IPerson findPersonByID(int id);
	
	public IRoom findRoomByID(String id);
	
	public ISubject findSubjectByID(int id);
	
	public StudeasySession findSessionByID(int id);
	
	public int createSession(IPerson user);
	
	public void closeSession(int id);
}
