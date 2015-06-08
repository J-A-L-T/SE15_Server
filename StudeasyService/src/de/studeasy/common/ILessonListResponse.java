package de.studeasy.common;

import java.util.List;

public interface ILessonListResponse extends IReturncodeResponse  {
	
	public List<ILessonTO> getLessonList();
	
	public void setLessonList(List<ILessonTO> lessonList); 

}
