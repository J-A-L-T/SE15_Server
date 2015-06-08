package de.studeasy.common;

public interface IHomeworkTO {
	
	public int getHomeworkID();
	public void setHomeworkID(int homeworkID);
	public String getDescription();
	public void setDescription(String description);
	public ILesson getLesson();
	public void setLesson(ILesson lesson);

}
