package springboot.conduit.services;

import springboot.conduit.model.User;
import springboot.conduit.returndto.UserReturnDTO;

public interface UserService {

    UserReturnDTO createNewUser(User user);

}
