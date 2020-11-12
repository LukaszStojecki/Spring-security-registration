package comexample.springsecurityregistrationform.controller;

import comexample.springsecurityregistrationform.model.Role;
import comexample.springsecurityregistrationform.model.User;
import comexample.springsecurityregistrationform.repository.UserRepository;
import comexample.springsecurityregistrationform.service.UserDetailsServiceImpl;
import comexample.springsecurityregistrationform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import javax.validation.Valid;


@Controller
public class ApiController {

//    @GetMapping("/admin")
//    public String adminDetails() {
//
//        return "admin";
//    }

    private UserService userService;

    @Autowired
    public ApiController(UserService userService) {
        this.userService = userService;

    }

    @GetMapping("/")
    public String showMainPage(Principal principal, Model model) {
        if (principal != null){
            model.addAttribute("username", principal.getName());
        } else{
            model.addAttribute("username", "Unknown");
        }

        return "index";
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @GetMapping("/sign-up")
    public String getSignUpForm(Model model) {
        model.addAttribute("user", new User());
        return "sign-up";
    }

    @PostMapping("/register")
    public String saveUserSignUpForm(User user){

        userService.addNewUser(user);
        System.out.println(user);
        return "redirect:/login";
    }

}
