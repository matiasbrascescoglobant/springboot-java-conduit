package springboot.conduit.exception;

import lombok.Getter;

import java.util.List;

@Getter
public class InvalidRequestException extends RuntimeException {

    private List<String> messageList;
    public InvalidRequestException(List<String> messages) {
        messageList = messages;
    }

}
