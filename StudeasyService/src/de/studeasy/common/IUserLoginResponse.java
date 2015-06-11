package de.studeasy.common;

public interface IUserLoginResponse extends IReturncodeResponse {
	
	public int getSessionID();
	
	public void setSessionID(int sessionID);

}
