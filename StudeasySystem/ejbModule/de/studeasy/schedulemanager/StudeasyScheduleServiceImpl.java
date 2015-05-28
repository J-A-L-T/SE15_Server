package de.studeasy.schedulemanager;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;
import java.util.logging.*;

import de.studeasy.entities.*;
import de.studeasy.common.StudeasyScheduleService;
import de.studeasy.registries.HomeworkRegistry;
import de.studeasy.registries.LessonRegistry;
import de.studeasy.registries.PersonRegistry;
import de.studeasy.session.UserSession;
import de.studeasy.session.SessionRegistry;


public class StudeasyScheduleServiceImpl implements StudeasyScheduleService {

	private static Logger jlog = Logger.getLogger(StudeasyScheduleServiceImpl.class.getPackage().getName());
	
	@Override
	public String login(int personID, String password)   {
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
	public void logout(String sessionID)   {
		UserSession session = SessionRegistry.getInstance().findSession(sessionID);
		if (session != null) {
			SessionRegistry.getInstance().removeSession(session);
			jlog.log(Level.FINE, session + " Logout erfolgreich.");
		}
		else {
			jlog.log(Level.INFO, session + " Logout fehlgeschlagen, da Session "+sessionID+" unbekannt.");
		}
	}

	@Override
	public boolean createHomework(int lessonID, String description) {
		try {
			Lesson lesson = LessonRegistry.getInstance().findLessonById(lessonID);
			
			Homework homework = new Homework();
			//bisher ist ID noch standardmäßig 1 (nacher GeneratedValue)
			homework.setHomeworkID(1);
			homework.setDescription(description);
			lesson.addHomework(homework);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	
	@Override
	public boolean removeHomework(int homeworkID) {
		try {
			HomeworkRegistry.getInstance().removeHomeworkById(homeworkID);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	@Override
	public List<Lesson> getLessonsByDate(int personID, Date date)
			  {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Lesson findLessonById(int lessonID)   {
		
		return null;
	}

	@Override
	public List<Lesson> getLessonsBySubject(int subjectID, int courseID,
			Date startDate, Date endDate)   {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Homework> getHomeworksForPupil(int personID, Date startDate,
			Date endDate)   {
		// TODO Auto-generated method stub
		return null;
	}

}
