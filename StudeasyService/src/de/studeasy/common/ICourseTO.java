package de.studeasy.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public interface ICourseTO extends Serializable {
	
	public int getCourseID();
	
	public void setCourseID(int courseID);
	
	public int getGrade();
	
	public void setGrade(int grade);
	
	public char getDescriptor();
	
	public void setDescriptor(char descriptor);
	
	public ITeacher getClassTeacher();
	
	public void setClassTeacher(ITeacher classTeacher);
	
	public List<IPupil> getPupils();
	
	public void setPupils(ArrayList<IPupil> pupils);
	
	public List<ILesson> getLessons();
	
	public void setLessons(ArrayList<ILesson> lessons);

}
