package mir.project.massenger.exception;

import mir.project.massenger.model.ExceptionResponse;

public class DataNotFoundException extends Exception {

	private ExceptionResponse exceptionResponse;
	
	public DataNotFoundException() {
		
	}
	
	public DataNotFoundException(ExceptionResponse ex) {
		super();
		this.exceptionResponse = ex;	
	}

	public ExceptionResponse getExceptionResponse() {
		return exceptionResponse;
	}

	public void setExceptionResponse(ExceptionResponse exceptionResponse) {
		this.exceptionResponse = exceptionResponse;
	}
	
	
	
}
