package de.studeasy.common;


public interface ILessonByIDResponse extends IReturncodeResponse {
	
	
	public ILessonTO getLesson();
	public void setLesson(ILessonTO lesson);
}
