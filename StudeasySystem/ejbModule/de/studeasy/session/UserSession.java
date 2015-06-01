package de.studeasy.session;

import de.studeasy.common.IPerson;
import de.studeasy.util.IdGenerator;

public class UserSession {
	
	private final String sessionID;
	private final IPerson user;
	
	public UserSession(IPerson user) {
		this.sessionID = String.valueOf(IdGenerator.getFreeID());
		this.user = user;
		SessionRegistry.getInstance().addSession(this);
	}

	public String getSessionID() {
		return sessionID;
	}

	public IPerson getUser() {
		return user;
	}
	
	@Override
	public String toString() {
		return "["+this.sessionID+","+this.getUser().getPersonID()+"]";
	}
		
}
