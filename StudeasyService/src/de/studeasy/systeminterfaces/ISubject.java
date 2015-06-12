package de.studeasy.systeminterfaces;

import java.io.Serializable;

/**
 * Interface für die Subject-Entity
 * @author Andreas Prischep
 *
 */
public interface ISubject extends Serializable {
	
	public int getSubjectID();
	public void setSubjectID(int subjectID);
	public String getDescription();
	public void setDescription(String description);

}
