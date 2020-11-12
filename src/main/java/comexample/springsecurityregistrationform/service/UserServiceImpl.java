package comexample.springsecurityregistrationform.service;

import comexample.springsecurityregistrationform.model.Role;
import comexample.springsecurityregistrationform.model.User;
import comexample.springsecurityregistrationform.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService{


    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void addNewUser(User user) {
//            if (userRepository.existsUserByUsername(user.getUsername())){
//                throw new Exception("User already exists");
//            } else {
                user.setPassword(passwordEncoder.encode(user.getPassword()));
                user.setRoles(user.getRoles());
                userRepository.save(user);
//            }

    }
}
