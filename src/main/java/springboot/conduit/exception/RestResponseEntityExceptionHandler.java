package springboot.conduit.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import springboot.conduit.model.User;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({InvalidRequestException.class})
    public ResponseEntity<Object> handleNotFoundException(InvalidRequestException exception, WebRequest request) {

        BodyError bodyError = new BodyError();
        bodyError.setBody(exception.getMessageList());
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrors(bodyError);

        return new ResponseEntity<>(errorResponse, new HttpHeaders(), HttpStatus.UNPROCESSABLE_ENTITY);

    }

}
