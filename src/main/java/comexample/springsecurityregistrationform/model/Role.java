package comexample.springsecurityregistrationform.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ADMIN("ROLE_ADMIN"),
    USER("ROLE_USER");

    private String name;

    Role(String name) {
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return name;
    }
}
