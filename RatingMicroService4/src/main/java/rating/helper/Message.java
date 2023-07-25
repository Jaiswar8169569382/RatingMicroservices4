package rating.helper;

import org.springframework.http.HttpStatus;

public class Message {

   private String message;
   private HttpStatus status;
   private boolean success;
   
public Message(String message, HttpStatus status, boolean success) {
	super();
	this.message = message;
	this.status = status;
	this.success = success;
}

public Message() {
	super();
	// TODO Auto-generated constructor stub
}

public Message(HttpStatus status, boolean success) {
	super();
	this.status = status;
	this.success = success;
}

public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}

public HttpStatus getStatus() {
	return status;
}

public void setStatus(HttpStatus status) {
	this.status = status;
}

public boolean isSuccess() {
	return success;
}

public void setSuccess(boolean success) {
	this.success = success;
}
   
   
}
