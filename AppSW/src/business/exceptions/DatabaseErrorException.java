package business.exceptions;

import javax.xml.ws.WebFault;

@WebFault
public class DatabaseErrorException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3463394785450285057L;
	
	private String faultCode;
	private String faultString;
	
	public DatabaseErrorException() {
		super("Error in database - Unable to retrieve data");
		this.setFaultString(getMessage());
		this.setFaultCode("500 Unable to retrieve data");
	}

	public String getFaultCode() {
		return faultCode;
	}

	public void setFaultCode(String faultCode) {
		this.faultCode = faultCode;
	}

	public String getFaultString() {
		return faultString;
	}

	public void setFaultString(String faultString) {
		this.faultString = faultString;
	}

}
