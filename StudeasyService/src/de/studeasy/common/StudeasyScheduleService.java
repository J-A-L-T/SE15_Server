package de.studeasy.common;

import java.rmi.Remote;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

/**
 * Dieses Interface definiert die Schnittstelle zwischen der Java app und dem Server.
 * Es wird von Remote abgeleitet, um Remote-Aufrufe vom Client zum Server zu ermoeglichen.
 * 
 * @author Prischep  
 */

public interface StudeasyScheduleService extends Remote {

	public static final String Interface_ID = "StudeasyService";
	
	/**
	 * Operation zum Einloggen mit Username und Password.
	 * @param personID
	 * @param password
	 * @return sessionID
	 */
	public String login(int personID, String password) ;
	
	public void logout(String sessionID) ;
	
	public boolean createHomework(int lessonID, String description);
	
	public boolean removeHomework(int homeworkID) ;
	
	public List<Lesson> getLessonsByDate(int personID, Date date);
	
	public Lesson findLessonById(int lessonID);
	
	public List<Lesson> getLessonsBySubject(int subjectID,int courseID, Date startDate, Date endDate);
	
	public List<Homework> getHomeworksForPupil(int personID, Date startDate, Date endDate);	
	
}
