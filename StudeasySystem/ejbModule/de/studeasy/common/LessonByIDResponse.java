package de.studeasy.common;

/**
 * 
 * LessonByIDResponse wird vom message system benutzt um lessons zurückzugeben
 * @author Andreas Prischep
 *
 */


public class LessonByIDResponse extends ReturncodeResponse {

	private static final long serialVersionUID = 370515707812705415L;

	private LessonTO lesson;

	public LessonTO getLesson() {
		return lesson;
	}

	public void setLesson(LessonTO lesson) {
		this.lesson = lesson;
	}

	

}
