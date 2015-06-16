package de.studeasy.systeminterfaces;

import java.io.Serializable;
import java.util.List;

/**
 * Interface für die Course-Entity
 * @author Andreas Prischep
 *
 */
public interface ICourse extends Serializable {
	
	public int getCourseID();
	
	public void setCourseID(int courseID);
	
	public int getGrade();
	
	public void setGrade(int grade);
	
	public char getDescriptor();
	
	public void setDescriptor(char descriptor);
	
	public ITeacher getClassTeacher();
	
	public void setClassTeacher(ITeacher classTeacher);
	
	public List<IPupil> getPupils();
	
	public void setPupils(List<IPupil> pupils);
	
	public void addNewPupil(IPupil newPupil);
	
	public List<ILesson> getLessons();
	
	public void setLessons(List<ILesson> lessons);
	
	public void addNewLesson(ILesson newLesson);

}
