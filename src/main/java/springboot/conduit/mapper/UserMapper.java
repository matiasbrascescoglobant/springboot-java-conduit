package springboot.conduit.mapper;

import org.mapstruct.Mapper;
import springboot.conduit.dto.UserDTO;
import springboot.conduit.model.User;
import org.mapstruct.factory.Mappers;
import springboot.conduit.returndto.UserReturnDTO;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO userToUserDTO(User user);

    UserReturnDTO userToUserReturnDTO(User user);

}
