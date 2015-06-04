package de.studeasy.common;

public class NoSessionException extends Exception {

	private static final long serialVersionUID = -1201698533694759093L;

	public NoSessionException() {
		
	}

	public NoSessionException(String message) {
		super(message);
		
	}

	public NoSessionException(Throwable cause) {
		super(cause);
		
	}

	public NoSessionException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public NoSessionException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

}
