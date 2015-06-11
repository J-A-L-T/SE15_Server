package de.studeasy.common;


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
