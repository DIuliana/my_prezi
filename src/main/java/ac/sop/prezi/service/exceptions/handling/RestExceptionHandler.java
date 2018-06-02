package ac.sop.prezi.service.exceptions.handling;

import ac.sop.prezi.service.exceptions.ApiError;
import ac.sop.prezi.service.exceptions.EntityNotFoundException;
import ac.sop.prezi.service.exceptions.InvalidInputException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;


@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler({EntityNotFoundException.class})
    protected ResponseEntity<Object> handleEntityNotFound(EntityNotFoundException ex) {

        ApiError apiError = new ApiError(NOT_FOUND, ex);

        return new ResponseEntity<>(apiError, apiError.getStatus());
    }

    @ExceptionHandler({InvalidInputException.class})
    protected ResponseEntity<Object> handleInvalidInput(InvalidInputException ex) {

        ApiError apiError = new ApiError(BAD_REQUEST, ex);

        return new ResponseEntity<>(apiError, apiError.getStatus());
    }


}