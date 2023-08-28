package com.test.paymenttracking.service;

import com.test.paymenttracking.dto.LoginDto;
import com.test.paymenttracking.entity.Users;
import com.test.paymenttracking.repository.UsersRepo;
import com.test.paymenttracking.security.UserDetailsImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AuthenticationService {

    @Autowired
    AuthenticationManager authenticationManager;


    public UserDetailsImpl login(LoginDto loginDto) {

        UsernamePasswordAuthenticationToken authenticationTokenRequest = new
                UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword());
        try {
            Authentication authentication = this.authenticationManager.authenticate(authenticationTokenRequest);
            SecurityContext securityContext = SecurityContextHolder.getContext();
            securityContext.setAuthentication(authentication);

            /*HttpSession session = httpServletRequest.getSession(true);
            session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, securityContext);*/

            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
            log.info("Logged in user: {}", userDetails);
            return userDetails;

        } catch (BadCredentialsException ex) {
            throw ex;
        }
    }
}
