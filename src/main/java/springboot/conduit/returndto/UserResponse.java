package springboot.conduit.returndto;

import lombok.Data;

import javax.persistence.Column;
@Data
public class UserResponse {

    private String email;

    private String token;

    private String username;

    private String bio;

    private String image;

}
