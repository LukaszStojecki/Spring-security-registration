package comexample.springsecurityregistrationform.autostart;

import comexample.springsecurityregistrationform.model.Role;
import comexample.springsecurityregistrationform.model.User;
import comexample.springsecurityregistrationform.repository.UserRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class Autostart {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public Autostart(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;

        User user = new User();
        user.setUsername("Administrator");
        user.setPassword(passwordEncoder.encode("admin1"));
        user.setRoles(Role.ADMIN);
        userRepository.save(user);

    }




}
