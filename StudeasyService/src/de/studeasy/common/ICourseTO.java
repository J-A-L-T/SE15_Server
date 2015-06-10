package de.studeasy.common;

import java.io.Serializable;
import java.util.List;

public interface ICourseTO extends Serializable {
	
	public int getCourseID();
	
	public void setCourseID(int courseID);
	
	public int getGrade();
	
	public void setGrade(int grade);
	
	public char getDescriptor();
	
	public void setDescriptor(char descriptor);
	
	public ITeacherTO getClassTeacher();
	
	public void setClassTeacher(ITeacherTO classTeacher);
	
	public List<IPupilTO> getPupils();
	
	public void setPupils(List<IPupilTO> pupils);
	
	public List<ILessonTO> getLessons();
	
	public void setLessons(List<ILessonTO> list);

}
