package ac.sop.prezi.service.exceptions;

import org.springframework.beans.factory.annotation.Autowired;

public class InvalidInputException extends Exception {

    private String message;

    public InvalidInputException(String message) {
        this.message = message;
    }

    @Autowired
    public String getMessage(){
        return message;
    }
}
