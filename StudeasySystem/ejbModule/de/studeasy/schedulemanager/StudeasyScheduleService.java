package de.studeasy.schedulemanager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.*;

import javax.ejb.EJB;
import javax.ejb.Remove;
import javax.ejb.Stateless;

import de.studeasy.common.*;
import de.studeasy.dao.IStudeasyDAO;
import de.studeasy.entities.StudeasySession;

/**
 * 
 * @author Tobias Riegel
 *
 */
@Stateless
public class StudeasyScheduleService implements IStudeasyScheduleService {

	private static Logger jlog = Logger.getLogger(StudeasyScheduleService.class.getPackage().getName());
	
	@EJB(beanName = "StudeasyDAO", beanInterface = de.studeasy.dao.IStudeasyDAO.class)
	private IStudeasyDAO dao;
	
	private StudeasySession getSession(int sessionID) throws NoSessionException {
		StudeasySession session = dao.findSessionByID(sessionID);
		if (session==null)
			throw new NoSessionException("Bitte zunächst ein Login durchführen.");
		else
			return session;
	}
	
	@Override
	public int login(int personID, String password) throws InvalidLoginException {
		IPerson user = this.dao.findPersonByID(personID);
		int sessionId;
		if (user != null && user.getPassword().equals(password)) {
			sessionId = dao.createSession(user);
			jlog.log(Level.FINE, "Login erfolgreich. Session=" + sessionId);
		}
		else {
			jlog.log(Level.INFO, "Login fehlgeschlagen, da Person unbekannt oder Passwort falsch. personID="+personID);
			throw new InvalidLoginException("Login fehlgeschlagen, da Kunde unbekannt oder Passwort falsch.");
		}
		return sessionId;
	}

	@Override
	@Remove
	public void logout(int sessionId) throws NoSessionException {
		dao.closeSession(sessionId);
		jlog.log(Level.FINE, "Logout erfolgreich.");
	}

	@Override
	public boolean createHomework(int sessionID, int lessonID, String description)  {
		//mit sessionID noch auf Berechtigung prüfen
		try {
			ILesson lesson = dao.findLessonByID(lessonID);
			lesson.addHomework(description);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	
	@Override
	public boolean removeHomework(int sessionID, int homeworkID)  {
		try {
			boolean successfull = dao.removeHomeworkByID(homeworkID);
			return successfull;
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
	public List<ILesson> getLessonsByDate(int sessionID, Date date)  {
		ArrayList<ILesson> dateLessons = new ArrayList<ILesson>();
		ArrayList<ILesson> lessons = null;
		try {
			StudeasySession session = getSession(sessionID);
			IPerson person = dao.findPersonByID(session.getUserID());
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
		catch(StudeasyException e) {
			return null;
		}
	}

	@Override
	public ILesson findLessonById(int lessonID)   {
		return dao.findLessonByID(lessonID);
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
			ICourse course = dao.findCourseByID(courseID);
			if(course!=null) {
				
				ArrayList<ILesson> lessons = course.getLessons();
				ArrayList<ILesson> dateLessons = new ArrayList<ILesson>();
							
				ISubject subject = dao.findSubjectByID(subjectID);
				
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
	public List<IHomework> getHomeworksForPupil(int sessionID, Date startDate,
			Date endDate)   {
		try {
			StudeasySession session = getSession(sessionID);
			IPerson person = dao.findPersonByID(session.getUserID());
			
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
		catch (StudeasyException e) {
			return null;
		}
	}
	
	private boolean isDateBetween(Date when, Date startDate, Date endDate) {
		if( !(when.before(startDate)) && !(when.after(endDate)) ) {
			return true;
		}
		else
			return false;
	}

}
