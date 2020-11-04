package comexample.springsecurityregistrationform.security;


import comexample.springsecurityregistrationform.service.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private UserDetailsServiceImpl userDetailsService;

    public SecurityConfig(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);

//        auth.inMemoryAuthentication()
//                .withUser("user").password(passwordEncoder().encode("user1")).roles("USER")
//                .and()
//                .withUser("admin").password(passwordEncoder().encode("admin1")).roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http.authorizeRequests()
               .antMatchers("/admin").hasRole("ADMIN")
               .antMatchers("/user").hasAnyRole("USER","ADMIN")
               .antMatchers("/").permitAll()
               .and()
               .formLogin()
               .and()
               .logout().logoutSuccessUrl("/good bye");

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
