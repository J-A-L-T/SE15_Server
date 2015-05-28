package de.studeasy.session;

import de.studeasy.common.Person;
import de.studeasy.util.IdGenerator;

public class UserSession {
	
	private final String sessionID;
	private final Person user;
	
	public UserSession(Person user) {
		this.sessionID = String.valueOf(IdGenerator.getFreeID());
		this.user = user;
		SessionRegistry.getInstance().addSession(this);
	}

	public String getSessionID() {
		return sessionID;
	}

	public Person getUser() {
		return user;
	}
	
	@Override
	public String toString() {
		return "["+this.sessionID+","+this.getUser().getPersonID()+"]";
	}
		
}
