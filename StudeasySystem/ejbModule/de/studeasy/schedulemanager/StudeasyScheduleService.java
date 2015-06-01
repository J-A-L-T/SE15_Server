package de.studeasy.schedulemanager;

import java.rmi.RemoteException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.*;

import de.studeasy.common.*;
import de.studeasy.registries.HomeworkRegistry;
import de.studeasy.registries.LessonRegistry;
import de.studeasy.registries.PersonRegistry;
import de.studeasy.session.UserSession;
import de.studeasy.session.SessionRegistry;


public class StudeasyScheduleService implements IStudeasyScheduleService {

	private static Logger jlog = Logger.getLogger(StudeasyScheduleService.class.getPackage().getName());
	
	@Override
	public String login(int personID, String password)   {
		String sessionID = null;
		IPerson person = PersonRegistry.getInstance().findPersonById(personID);
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
			ILesson lesson = LessonRegistry.getInstance().findLessonById(lessonID);
			lesson.addHomework(description);
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

	/**
	 * Gibt eine Liste der Unterrichtsstunden an einem bestimmten Tag
	 * für eine bestimmte Person zurück.
	 * Die Liste ist leer, wenn an dem Tag kein für die Person kein Unterricht ist.
	 * Wenn null zurückgeben wird, waren die Parameter falsch.
	 */
	@Override
	public List<de.studeasy.common.ILesson> getLessonsByDate(int personID, Date date) {
		ArrayList<ILesson> dateLessons = new ArrayList<ILesson>();
		ArrayList<ILesson> lessons = null;
		IPerson person = PersonRegistry.getInstance().findPersonById(personID);
		if(person instanceof IPupil) {
			IPupil pupil = (IPupil) person;
			lessons = pupil.getCourse().getLessons();	
		}
		else if(person instanceof ITeacher) {
			ITeacher teacher = (ITeacher) person;
			lessons = teacher.getLessons();
		}
		
		if(lessons!=null) {
			for(int i = 0; i < lessons.size(); i++) {
				if(lessons.get(i).getDate().equals(date))
					dateLessons.add(lessons.get(i));
			}
		}
		else 
			dateLessons=null;
			
		return dateLessons;
	}

	@Override
	public ILesson findLessonById(int lessonID)   {
		return LessonRegistry.getInstance().findLessonById(lessonID);
	}

	@Override
	public List<ILesson> getLessonsBySubject(int subjectID, int courseID,
			Date startDate, Date endDate)   {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IHomework> getHomeworksForPupil(int personID, Date startDate,
			Date endDate)   {
		// TODO Auto-generated method stub
		return null;
	}

}
