package springboot.conduit.exception;

import lombok.Data;

@Data
public class ErrorResponse {

    private BodyError errors;

}
