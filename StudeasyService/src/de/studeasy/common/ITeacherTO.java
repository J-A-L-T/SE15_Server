package de.studeasy.common;

import java.util.List;

public interface ITeacherTO extends IPersonTO {

	public ICourseTO getCourse();
	public void setCourse(ICourseTO course);
	public List<ILessonTO> getLessons();
	public void setLessons(List<ILessonTO> list);
}
