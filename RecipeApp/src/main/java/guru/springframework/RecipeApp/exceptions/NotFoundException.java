package guru.springframework.RecipeApp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.ALREADY_REPORTED)
public class NotFoundException extends RuntimeException{
	  public NotFoundException() {
	        super();
	    }

	    public NotFoundException(String message) {
	        super(message);
	    }

	    public NotFoundException(String message, Throwable cause) {
	        super(message, cause);
	    }
}
