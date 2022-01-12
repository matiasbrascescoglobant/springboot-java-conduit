package springboot.conduit.exception;

import lombok.Data;

import java.util.List;

@Data
public class BodyError {

    private List<String> body;

}
