package de.studeasy.common;

import java.util.Date;



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
	public IUserLoginResponse login(int personID, String password) ;
	
	public IReturncodeResponse logout(int sessionId);
	
	public IReturncodeResponse createHomework(int sessionID, int lessonID, String description)  ;
	
	public IBooleanResponse removeHomework(int sessionID, int homeworkID)  ;// auch ReturncodeResonse
	
	public ILessonListResponse getLessonsByDate(int sessionID, Date date);
	
	public ILessonByIDResponse findLessonById(int lessonID);
	
	public ILessonListResponse getLessonsBySubject(int subjectID,int courseID, Date startDate, Date endDate) ;
	
	public IHomeworkListResponse getHomeworksForPupil(int sessionID, Date startDate, Date endDate) ;	
	
}
