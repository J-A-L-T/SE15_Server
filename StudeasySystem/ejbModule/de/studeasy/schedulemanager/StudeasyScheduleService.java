package de.studeasy.schedulemanager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remove;
import javax.ejb.Stateless;
import javax.jws.WebService;

import org.jboss.logging.Logger;
import org.jboss.ws.api.annotation.WebContext;

import de.studeasy.common.*;
import de.studeasy.dao.IStudeasyDAO;
import de.studeasy.entities.Homework;
import de.studeasy.entities.StudeasySession;
import de.studeasy.systeminterfaces.ICourse;
import de.studeasy.systeminterfaces.IHomework;
import de.studeasy.systeminterfaces.ILesson;
import de.studeasy.systeminterfaces.IPerson;
import de.studeasy.systeminterfaces.IPupil;
import de.studeasy.systeminterfaces.ISubject;
import de.studeasy.systeminterfaces.ITeacher;
import de.studeasy.systeminterfaces.InvalidLoginException;
import de.studeasy.systeminterfaces.NoSessionException;
import de.studeasy.systeminterfaces.StudeasyException;
import de.studeasy.util.DtoAssembler;

/**
 * Der StudeasyScheduleService stellt eine Statless Session Bean dar,
 * die den eigentlichen Kern des Server-Systems darstellt.
 * Hier ist die Hauptlogik implementiert und somit greift der Client
 * auf die Methoden dieses Services zu, um an seine gewünschten Daten zu kommen.
 * 
 * @author Tobias Riegel & Andreas Prischep
 *
 */

@Stateless
@WebService
@WebContext(contextRoot="/studeasy")  //Proprietaere Annotation um in der URL für den Webservice den Namen des EJB-Moduls loszuwerden.
public class StudeasyScheduleService implements IStudeasyScheduleService {
	
	private static final Logger logger = Logger.getLogger(StudeasyScheduleService.class);

		
	@EJB(beanName = "StudeasyDAO", beanInterface = de.studeasy.dao.IStudeasyDAO.class)
	private IStudeasyDAO dao;
	
	@EJB
	private DtoAssembler dto;
	
	private StudeasySession getSession(int sessionID) throws NoSessionException {
		StudeasySession session = dao.findSessionByID(sessionID);
		if (session==null)
			throw new NoSessionException("Bitte zunächst ein Login durchführen.");
		else
			return session;
	}
//-----------------------------------------------Login-------------------------------------------------	
	@Override
	public UserLoginResponse login(int personID, String password){
		
		
			UserLoginResponse response = new UserLoginResponse();
		
		try{
			IPerson user = this.dao.findPersonByID(personID);
			int sessionID;
			if (user != null && user.getPassword().equals(password)) {
				sessionID = dao.createSession(user);
				logger.info("Login erfolgreich. Session=" + sessionID);
				response.setSessionID(sessionID);
			}
			else {
				logger.info("Login fehlgeschlagen, da Person unbekannt oder Passwort falsch. personID="+personID);
				throw new InvalidLoginException("Login fehlgeschlagen, da Kunde unbekannt oder Passwort falsch.");
			}
		}
		catch(StudeasyException e) {
			response.setReturnCode(e.getErrorCode());
			response.setMessage(e.getMessage());	
		}
		return response;
}	

//--------------------------------------------LogOut------------------------------------------------
	@Override
	@Remove
	public ReturncodeResponse logout(int sessionID){
		dao.closeSession(sessionID);
		ReturncodeResponse response = new ReturncodeResponse();
		logger.info("Session=" + sessionID +" Logout erfolgreich.");
		return response;
	}

	
	
	//---------------------------CREATE HOMEWORK------------------------------------------------------------
	/**
	 * Legt eine neue Hausaufgabe für eine bestimmtest Fach an.
	 * Mit der sessionID wird auf Berechtigung geprüft.
	 * Wenn der User kein Lehrer ist, wird keine Hausaufgabe erzeugt und im BooleanResponse der Error-Code 30 gesetzt.
	 */
	@Override
	public BooleanResponse createHomework(int sessionID, int lessonID, String description)  {
		
		BooleanResponse response = new BooleanResponse();
		IPerson user = dao.findPersonByID(dao.findSessionByID(sessionID).getUserID());
		
		if(user instanceof ITeacher) {
			ILesson lesson = dao.findLessonByID(lessonID);
			IHomework homework = new Homework(description, lesson);
			lesson.addNewHomework(homework);
			response.setSuccessfull(true);
		}
		else {
			response.setSuccessfull(false);
			response.setMessage("Der angemeldete User ist keine Lehrer und darf somit keine Hausaufgaben anlegen.");
			response.setReturnCode(30);
		}
		return response;
	}
	//---------------------------REMOVE HOMEWORK------------------------------------------------------------
	/**
	 * Löscht eine Hausaufgabe.
	 * Mit der sessionID wird auf Berechtigung geprüft.
	 * Wenn der User kein Lehrer ist, wird die Hausaufgabe nicht gelöscht und im BooleanResponse der Error-Code 30 gesetzt.
	 */
	@Override
	public BooleanResponse removeHomework(int sessionID, int homeworkID)  {
		BooleanResponse response = new BooleanResponse();
		boolean successfull = false;
		IPerson user = dao.findPersonByID(dao.findSessionByID(sessionID).getUserID());
		
		if(user instanceof ITeacher) {
			successfull = dao.removeHomeworkByID(homeworkID);
		}
		else {
			response.setMessage("Der angemeldete User ist keine Lehrer und darf somit keine Hausaufgaben anlegen.");
			response.setReturnCode(30);
		}
			
		response.setSuccessfull(successfull);
		return response;
	}
	
//-----------------------------------------------LESSON BY DATE----------------------------------------
	/**
	 * Gibt eine Liste der Unterrichtsstunden an einem bestimmten Tag
	 * für eine bestimmte Person zurück.
	 * Die Liste ist leer, wenn an dem Tag kein für die Person kein Unterricht ist.
	 */
	
	@Override
	public LessonListResponse getLessonsByDate(int sessionID, Date date)  {
		
		LessonListResponse response = new LessonListResponse();	
		
		List<ILesson> dateLessons = new ArrayList<ILesson>();
		List<ILesson> lessons = null;

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
				
		}
		catch (StudeasyException e) {
			response.setReturnCode(e.getErrorCode());
			response.setMessage(e.getMessage());
		}
		response.setLessonList(dto.makeLessonDTO(dateLessons));
		return response;
	}
	
	
	
//-----------------------------------Lesson By ID --------------------------------------------------
	
	@Override
	public LessonByIDResponse findLessonById(int lessonID){
		
		LessonByIDResponse response = new LessonByIDResponse(); 
	
		response.setLesson(dto.makeLessonDTO(dao.findLessonByID(lessonID)));

		return response;
	}

	
	
//---------------------------------GET LESSON BYSUBJECT---------------------------------------------	
	
	/** 
	 * Gibt eine Liste der Unterrichtsstunden in einem bestimmten Zeitraum
	 * für eine bestimmte Schulklasse in einem bestimmten Fach zurück.
	 * Die Liste ist leer, wenn in dem Zeitraum für die Schulklasse in dem Fach kein Unterricht ist.
	 * Das startDate und endDate sind inklusive. Also Unterrichtsstunden die am 
	 * start- oder endDate stattfinden befinden sich in der zurückgegebenen Liste.
	 */
	@Override
	public LessonListResponse getLessonsBySubject(int subjectID, int courseID,
			Date startDate, Date endDate)   {
		
			LessonListResponse response = new LessonListResponse();	
		
			ICourse course = dao.findCourseByID(courseID);
			if(course!=null) {
				
				List<ILesson> lessons = course.getLessons();
				List<ILesson> dateLessons = new ArrayList<ILesson>();
							
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
					response.setLessonList(dto.makeLessonDTO(dateLessons));
					
				}
				else
					response.setLessonList(null);
			}
			else
				response.setLessonList(null);
			
			return response;
		
	}
	

	
//------------------------------------------GET HOMEWORK FOR PUPIL------------------------------------------
	/**
	 * Gibt eine Liste von Hausaufgaben für einen bestimmten Schüler zu einem bestimmten Zeitraum zurück.
	 * Die Liste ist leer, wenn dieser Schüler zu diesem Zeitraum keine Hausaufgaben hat.
	 * Wenn der angemeldete User kein Schüler ist wird im HomeworkListResponse der Error-Code auf 30 gesetzt.
	 */
	@Override
	public HomeworkListResponse getHomeworksForPupil(int sessionID, Date startDate,
			Date endDate)   {
		
		HomeworkListResponse response = new HomeworkListResponse();
		try {
			StudeasySession session = getSession(sessionID);
			IPerson person = dao.findPersonByID(session.getUserID());
			
			if(person instanceof IPupil) {
				IPupil pupil = (IPupil) person;
				
				List<ILesson> lessons = pupil.getCourse().getLessons();
				List<IHomework> homeworks = new ArrayList<IHomework>();
				
				for(int i = 0; i < lessons.size(); i++) {
					if(isDateBetween(lessons.get(i).getDate(), startDate, endDate)) {
						
						for(int j = 0; j < lessons.get(i).getHomeworks().size(); j++) {
							homeworks.add(lessons.get(i).getHomeworks().get(j));
						}
					}
				}
				
				response.setHomeworkList(dto.makeHomeworkDTO(homeworks));
				}
			else {
				response.setHomeworkList(null);
				response.setMessage("Der angemeldete User ist keine Schüler.");
				response.setReturnCode(30);
			}
			
		}
		catch (StudeasyException e) {
			response.setHomeworkList(null);
			response.setReturnCode(e.getErrorCode());
			response.setMessage(e.getMessage());
		}
		return response;
	}
	
//---------------------------------IS USER TEACHER-----------------------------------------------------
	
	public BooleanResponse isUserTeacher(int sessionID) {
		
		BooleanResponse response = new BooleanResponse();
		
		try{
			StudeasySession session = getSession(sessionID);
			IPerson person = dao.findPersonByID(session.getUserID());
			
			if(person instanceof ITeacher) {
				response.setSuccessfull(true);
			}
			else {
				response.setSuccessfull(false);
			}
		}
		catch (StudeasyException e) {
			response.setSuccessfull(false);
			response.setReturnCode(e.getErrorCode());
			response.setMessage(e.getMessage());
		}
		return response;
	}
	
//---------------------------------IS DATE BETWEEN-----------------------------------------------------
	private boolean isDateBetween(Date when, Date startDate, Date endDate) {
		if( !(when.before(startDate)) && !(when.after(endDate)) ) {
			return true;
		}
		else
			return false;
	}

}
