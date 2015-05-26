package de.studeasy.common;

import java.io.Serializable;
import java.util.ArrayList;

import de.studeasy.entities.Lesson;
import de.studeasy.entities.Pupil;
import de.studeasy.entities.Teacher;

public interface Course extends Serializable {
	
	public int getCourseID();
	
	public void setCourseID(int courseID);
	
	public int getGrade();
	
	public void setGrade(int grade);
	
	public char getDescriptor();
	
	public void setDescriptor(char descriptor);
	
	public Teacher getClassTeacher();
	
	public void setClassTeacher(Teacher classTeacher);
	
	public ArrayList<Pupil> getPupils();
	
	public void setPupils(ArrayList<Pupil> pupils);
	
	public ArrayList<Lesson> getLessons();
	
	public void setLessons(ArrayList<Lesson> lessons);

}
