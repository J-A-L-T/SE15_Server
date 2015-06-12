package de.studeasy.systeminterfaces;

/**
 * Exception für einen invaliden Login
 * Fehler-Code ist 20
 * @author Andreas Prischep
 *
 */
public class InvalidLoginException extends StudeasyException {

	private static final long serialVersionUID = 8759021636475023682L;
	private static final int CODE = 20;

	public InvalidLoginException(String message) {
		super(CODE, message);
	}

}
