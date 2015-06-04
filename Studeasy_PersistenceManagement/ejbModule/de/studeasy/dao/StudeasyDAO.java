package de.studeasy.dao;

import de.studeasy.common.ICourse;
import de.studeasy.common.IHomework;
import de.studeasy.common.ILesson;
import de.studeasy.common.IPerson;
import de.studeasy.common.IRoom;
import de.studeasy.common.ISubject;
import de.studeasy.entities.StudeasySession;

public class StudeasyDAO implements IStudeasyDAO {

	@Override
	public ICourse findCourseByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IHomework findCHomeworkByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean removeHomeworkByID(int homeworkID) {
		return false;
	}

	@Override
	public ILesson findLessonByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IPerson findPersonByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IRoom findRoomByID(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ISubject findSubjectByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudeasySession findSessionByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int createSession(IPerson user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void closeSession(int id) {
		// TODO Auto-generated method stub

	}

}
