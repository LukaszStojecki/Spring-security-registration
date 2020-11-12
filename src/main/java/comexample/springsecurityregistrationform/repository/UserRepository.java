package comexample.springsecurityregistrationform.repository;

import comexample.springsecurityregistrationform.model.Role;
import comexample.springsecurityregistrationform.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByUsername(String name);
    boolean existsUserByUsername(String username);

}
