package de.studeasy.dto;

import java.util.List;

import de.studeasy.common.*;

public class TeacherTO extends PersonTO implements ITeacherTO {
	
	private static final long serialVersionUID = 2405076137604996925L;

	
	private ICourseTO course;
	
	
	private List<ILessonTO> lessons;


	public ICourseTO getCourse() {
		return course;
	}


	public void setCourse(ICourseTO course) {
		this.course = course;
	}


	public List<ILessonTO> getLessons() {
		return lessons;
	}


	public void setLessons(List<ILessonTO> lessons) {
		this.lessons = lessons;
	}
	
}
