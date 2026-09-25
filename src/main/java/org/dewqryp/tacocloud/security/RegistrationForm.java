package org.dewqryp.tacocloud.security;

import lombok.Data;
import org.dewqryp.tacocloud.data.User;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
public class RegistrationForm {
    private String username;
    private String password;
    private String fullName;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String phoneNumber;

    public User toUser(PasswordEncoder passwordEncoder) {
        return new User(username, passwordEncoder.encode(password), fullName, city, state, zip, phoneNumber);
    }

}
