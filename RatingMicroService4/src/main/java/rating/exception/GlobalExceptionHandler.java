package rating.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import rating.helper.Message;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(RatingNoFoundWithId.class)
	public ResponseEntity<Message> ratingNotFound(RatingNoFoundWithId ex)
	{
		Message sms = new Message();
		sms.setMessage(ex.getMessage());
		sms.setStatus(HttpStatus.NOT_FOUND);
		sms.setSuccess(true);
		
		return new ResponseEntity<Message>(sms,HttpStatus.NOT_FOUND);
	}
}
