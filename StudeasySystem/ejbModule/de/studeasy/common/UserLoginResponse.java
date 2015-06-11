package de.studeasy.common;


public class UserLoginResponse extends ReturncodeResponse {
	
	private static final long serialVersionUID = -3173158325918408228L;
	
	private int sessionID;
	
	public UserLoginResponse() {
	}

	public int getSessionID() {
		return sessionID;
	}

	public void setSessionID(int sessionID) {
		this.sessionID = sessionID;
	}

	

}
