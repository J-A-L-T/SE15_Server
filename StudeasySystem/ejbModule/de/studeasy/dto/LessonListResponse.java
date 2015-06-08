package de.studeasy.dto;

import java.util.List;

import de.studeasy.common.ILessonListResponse;
import de.studeasy.common.ILessonTO;


public class LessonListResponse extends ReturncodeResponse implements ILessonListResponse {
	

	private static final long serialVersionUID = -8588591620795492047L;

	
	private List<ILessonTO> lessonList; 
	
	
	public List<ILessonTO> getLessonList() {
		return lessonList;
	}
	
	public void setLessonList(List<ILessonTO> lessonList) {
		this.lessonList = lessonList;
		
	}

	
	

	

}
