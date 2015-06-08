package de.studeasy.dto;

import de.studeasy.common.ILessonByIDResponse;
import de.studeasy.common.ILessonTO;


public class LessonByIDResponse extends ReturncodeResponse implements ILessonByIDResponse {
	

	private static final long serialVersionUID = 370515707812705415L;

	private ILessonTO lesson;

	public ILessonTO getLesson() {
		return lesson;
	}

	public void setLesson(ILessonTO lesson) {
		this.lesson = lesson;
	}

	

}
