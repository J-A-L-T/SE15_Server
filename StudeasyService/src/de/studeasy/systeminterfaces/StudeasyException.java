package de.studeasy.systeminterfaces;

/**
 * Superklasse für die InvalidLoginException und die NoSessionException
 * @author Andreas Prischep
 *
 */
public class StudeasyException extends Exception {

	private static final long serialVersionUID = -1658425297634781761L;

	private int errorCode;
	
	public StudeasyException(int errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

}
