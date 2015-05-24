package de.studeasy.common;

import java.io.Serializable;

public interface Teacher extends Serializable {

	public int getPersonID();
	public void setPersonID(int personID);
	public String getName();
	public void setName(String name);
	public String getFirstname();
	public void setFirstname(String firstname);
	public char getGender();
	public void setGender(char gender);
}
