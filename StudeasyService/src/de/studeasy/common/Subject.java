package de.studeasy.common;

import java.io.Serializable;

public interface Subject extends Serializable {
	
	public int getSubjectID();
	public void setSubjectID(int subjectID);
	public String getDescription();
	public void setDescription(String description);

}
