package springboot.conduit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.conduit.model.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    User findByUsername(String username);

}
