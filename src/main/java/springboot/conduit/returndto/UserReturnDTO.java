package springboot.conduit.returndto;

import lombok.Data;
import springboot.conduit.model.User;

import javax.persistence.Column;

@Data
public class UserReturnDTO {

    private UserResponse user;

}
