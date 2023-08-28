package com.test.paymenttracking.security;

import com.test.paymenttracking.entity.Users;
import com.test.paymenttracking.repository.UsersRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PostUserServiceImpl {

    private final UsersRepo usersRepo;

    private final PasswordEncoder passwordEncoder;

    @PostConstruct
    public void createPostUser() {
        Optional<Users> optionalUsers = usersRepo.findByUsername("testadmin");
        if (!optionalUsers.isPresent()) {
            Users users = new Users();
            users.setFirstname("testadmin");
            users.setLastname("testadmin");
            users.setUsername("testadmin");
            users.setRole("ADMIN");
            users.setPassword(passwordEncoder.encode("testadmin"));
            usersRepo.save(users);
        }

    }

}
