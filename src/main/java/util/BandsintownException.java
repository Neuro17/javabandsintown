package util;

import java.io.Serializable;

public class BandsintownException  extends Exception implements Serializable {
	
	private String message;
	
	public BandsintownException(String m){
		message=m;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String mess) {
		this.message = mess;
	}

}
