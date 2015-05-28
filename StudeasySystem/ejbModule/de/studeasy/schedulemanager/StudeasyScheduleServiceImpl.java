package de.studeasy.schedulemanager;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;
import java.util.logging.*;

import de.studeasy.common.Homework;
import de.studeasy.common.Lesson;
import de.studeasy.common.Person;
import de.studeasy.common.StudeasyScheduleService;
import de.studeasy.registries.PersonRegistry;
import de.studeasy.session.UserSession;


public class StudeasyScheduleServiceImpl implements StudeasyScheduleService {

	private static Logger jlog = Logger.getLogger(StudeasyScheduleServiceImpl.class.getPackage().getName());
	
	@Override
	public String login(int personID, String password) throws RemoteException {
		String sessionID = null;
		Person person = PersonRegistry.getInstance().findPersonById(personID);
		if (person != null && person.getPassword().equals(password)) {
			UserSession newSession = new UserSession(person);
			sessionID = newSession.getSessionID();
			jlog.log(Level.FINE, newSession + " Login erfolgreich.");
		}
		else {
			jlog.log(Level.INFO, "Login fehlgeschlagen, da Person unbekannt oder Passwort falsch. personID="+personID);
		}
		return sessionID;
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
