package comexample.springsecurityregistrationform.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class ApiController {

    @GetMapping("/admin")
    public String adminDetails(Authentication authentication) {

        String username = authentication.getName();
        return "Hello ADMIN: " + username;
    }

    @GetMapping("/user")
    public String userDetails(Authentication authentication) {

        String username = authentication.getName();
        return "Hello USER: " + username;
    }

    @GetMapping("/unknown")
    public String anyDetails(Authentication authentication) {
        if (authentication == null) {
            return "Hello, nobody logged yet";
        }

        String username = authentication.getName();
        return "Hello UNKNOWN: " + username;
    }

    @GetMapping("/good bye")
    public String sayBye(){
        return "good bye";
    }
}
