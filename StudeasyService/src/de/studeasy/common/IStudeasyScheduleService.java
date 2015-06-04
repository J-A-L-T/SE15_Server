package de.studeasy.common;

import java.util.Date;
import java.util.List;

/**
 * Dieses Interface definiert die Schnittstelle zwischen der Java app und dem Server.
 * Es wird von Remote abgeleitet, um Remote-Aufrufe vom Client zum Server zu ermoeglichen.
 * 
 * @author Prischep  
 */

public interface IStudeasyScheduleService {

	public static final String INTERFACE_ID = "IStudeasyScheduleService";
	
	/**
	 * Operation zum Einloggen mit Username und Password.
	 * @param personID
	 * @param password
	 * @return boolean successful 
	 * @throws InvalidLoginException 
	 */
	public int login(int personID, String password) throws InvalidLoginException ;
	
	public void logout(int sessionId) throws NoSessionException  ;
	
	public boolean createHomework(int sessionID, int lessonID, String description)  ;
	
	public boolean removeHomework(int sessionID, int homeworkID)  ;
	
	public List<ILesson> getLessonsByDate(int sessionID, Date date) ;
	
	public ILesson findLessonById(int lessonID) ;
	
	public List<ILesson> getLessonsBySubject(int subjectID,int courseID, Date startDate, Date endDate) ;
	
	public List<IHomework> getHomeworksForPupil(int sessionID, Date startDate, Date endDate) ;	
	
}
