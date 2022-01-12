package springboot.conduit.services;

import org.springframework.stereotype.Service;
import springboot.conduit.exception.InvalidRequestException;
import springboot.conduit.mapper.UserMapper;
import springboot.conduit.model.User;
import springboot.conduit.repositories.UserRepository;
import springboot.conduit.returndto.UserReturnDTO;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    public UserServiceImpl(UserMapper userMapper, UserRepository userRepository) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }

    @Override
    public UserReturnDTO createNewUser(User user) {
        return saveAndReturnDTO(user);
    }

    private UserReturnDTO saveAndReturnDTO(User user) {

        List<String> errors = new ArrayList<>();

        if(user.getEmail().isEmpty())
            errors.add("Email can't be blank");
        if(user.getUsername().isEmpty())
            errors.add("Username can't be blank");
        if(user.getPassword().isEmpty())
            errors.add("Password can't be blank");
        if(userRepository.findByEmail(user.getEmail()) != null)
            errors.add("The email already exists");
        if(userRepository.findByUsername(user.getUsername()) != null)
            errors.add("Username already exist");

        if(errors.size() > 0)
            throw new InvalidRequestException(errors);

        User savedUser = userRepository.save(user);

        return userMapper.userToUserReturnDTO(savedUser);

    }

}
