package de.studeasy.dao;

import javax.ejb.Local;
import de.studeasy.common.*;

@Local
public interface IStudeasyDAO {
	
	public ICourse findCourseByID(int id);
	
	public IHomework findCHomeworkByID(int id);
	
	public ILesson findLessonByID(int id);
	
	public IPerson findPersonByID(int id);
	
	public IRoom findRoomByID(String id);
	
	public ISubject findSubjectByID(int id);
}
