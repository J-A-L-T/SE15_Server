package de.studeasy.schedulemanager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.*;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import de.studeasy.common.*;
import de.studeasy.registries.CourseRegistry;
import de.studeasy.registries.HomeworkRegistry;
import de.studeasy.registries.LessonRegistry;
import de.studeasy.registries.PersonRegistry;
import de.studeasy.registries.SubjectRegistry;
import de.studeasy.session.UserSession;
import de.studeasy.session.SessionRegistry;

/**
 * 
 * @author Tobias Riegel
 *
 */
@Stateless
@Remote(IStudeasyScheduleService.class)
public class StudeasyScheduleService implements IStudeasyScheduleService {

	private static Logger jlog = Logger.getLogger(StudeasyScheduleService.class.getPackage().getName());
	
	@Override
	public String login(int personID, String password)    {
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
	public void logout(String sessionID)  {
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
	public boolean createHomework(int lessonID, String description)  {
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
	public boolean removeHomework(int homeworkID)  {
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
	public List<de.studeasy.common.ILesson> getLessonsByDate(int personID, Date date)  {
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

	/** 
	 * Gibt eine Liste der Unterrichtsstunden in einem bestimmten Zeitraum
	 * für eine bestimmte Schulklasse in einem bestimmten Fach zurück.
	 * Die Liste ist leer, wenn in dem Zeitruam kein für die Schulklasse in dem Fach kein Unterricht ist.
	 * Wenn null zurückgeben wird, waren die Parameter falsch.
	 * Das startDate und endDate sind inklusive. Also Unterrichtsstunden die am 
	 * start- oder endDate stattfinden befinden sich in der zurückgegebenen Liste.
	 */
	@Override
	public List<ILesson> getLessonsBySubject(int subjectID, int courseID,
			Date startDate, Date endDate)   {
		ICourse course = CourseRegistry.getInstance().findCourseById(courseID);
		if(course!=null) {
			
			ArrayList<ILesson> lessons = course.getLessons();
			ArrayList<ILesson> dateLessons = new ArrayList<ILesson>();
						
			ISubject subject = SubjectRegistry.getInstance().findSubjectById(subjectID);
			
			if(subject!=null) {
				for(int i = 0; i < lessons.size(); i++) {
					//Entspricht das übergebene Fach dem Fach des Lesson-Objektes aus der Liste?
					//Ist das Datum zwischen startDate und endDate?
					if( (lessons.get(i).getSubject().getSubjectID() == subject.getSubjectID()) &&
						isDateBetween(lessons.get(i).getDate(), startDate, endDate)) {
						
						dateLessons.add(lessons.get(i));
					}
				}
				return dateLessons;
			}
			else
				return null;
		}
		else
			return null;
	}

	/**
	 * Gibt eine Liste von Hausaufgaben für einen bestimmten Schüler zu einem bestimmten Zeitraum zurück.
	 * Die Liste ist leer, wenn dieser Schüler zu diesem Zeitraum keine Hausaufgaben hat.
	 * Es wird null zurückgegeben, wenn die personID nicht zu einem Schüler gehört.
	 */
	@Override
	public List<IHomework> getHomeworksForPupil(int personID, Date startDate,
			Date endDate)   {
		IPerson person = PersonRegistry.getInstance().findPersonById(personID);
		
		if(person instanceof IPupil) {
			IPupil pupil = (IPupil) person;
			
			ArrayList<ILesson> lessons = pupil.getCourse().getLessons();
			ArrayList<IHomework> homeworks = new ArrayList<IHomework>();
			
			for(int i = 0; i < lessons.size(); i++) {
				if(isDateBetween(lessons.get(i).getDate(), startDate, endDate)) {
					
					for(int j = 0; j < lessons.get(i).getHomeworks().size(); j++) {
						homeworks.add(lessons.get(i).getHomeworks().get(j));
					}
				}
			}
			return homeworks;
		}
		else
			return null;
	}
	
	private boolean isDateBetween(Date when, Date startDate, Date endDate) {
		if( !(when.before(startDate)) && !(when.after(endDate)) ) {
			return true;
		}
		else
			return false;
	}

}
