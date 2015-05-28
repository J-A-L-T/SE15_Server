package de.studeasy.schedulemanager;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import de.studeasy.common.Homework;
import de.studeasy.common.Lesson;
import de.studeasy.common.StudeasyScheduleService;

public class StudeasyScheduleServiceImpl implements StudeasyScheduleService {

	@Override
	public String login(int personID, String password) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void logout(int personID) throws RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean createHomework(int lessonID, String description)
			throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Lesson> getLessonsByDate(int personID, Date date)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Lesson findLessonById(int lessonID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Lesson> getLessonsBySubject(int subjectID, int courseID,
			Date startDate, Date endDate) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Homework> getHomeworksForPupil(int personID, Date startDate,
			Date endDate) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
