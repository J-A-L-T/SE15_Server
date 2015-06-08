package de.studeasy.dto;

import de.studeasy.common.IBooleanResponse;

public class BooleanResponse extends ReturncodeResponse implements IBooleanResponse {

	
	private static final long serialVersionUID = 292317176289587801L;
	
	private boolean successfull;

	public boolean isSuccessfull() {
		return successfull;
	}

	public void setSuccessfull(boolean successfull) {
		this.successfull = successfull;
	}

	
	
	
}
