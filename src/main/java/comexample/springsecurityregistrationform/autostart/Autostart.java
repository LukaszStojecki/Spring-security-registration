package comexample.springsecurityregistrationform.autostart;

import comexample.springsecurityregistrationform.model.Role;
import comexample.springsecurityregistrationform.model.User;
import comexample.springsecurityregistrationform.repository.UserRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class Autostart {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;


    public Autostart(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;

    }

    @EventListener(ApplicationReadyEvent.class)
    public void addUserAndRole() {

        User admin = new User();
        admin.setUsername("Administrator");
        admin.setPassword(passwordEncoder.encode("admin1"));
        admin.setRoles(Role.ADMIN);

        User user = new User();
        user.setUsername("User");
        user.setPassword(passwordEncoder.encode("user123"));
        user.setRoles(Role.USER);

        userRepository.save(user);
        userRepository.save(admin);
    }


}
