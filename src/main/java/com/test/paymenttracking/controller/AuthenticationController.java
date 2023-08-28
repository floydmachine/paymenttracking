package com.test.paymenttracking.controller;

import com.test.paymenttracking.commons.CustomResponse;
import com.test.paymenttracking.dto.LoginDto;
import com.test.paymenttracking.service.AuthenticationService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/api/authenticate")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping(value = "/login",produces = "application/json")
    public CustomResponse<?> login(@RequestBody LoginDto loginDto) {
        try {
            return new CustomResponse<>(this.authenticationService.login(loginDto), HttpStatus.OK);

        } catch (Exception e) {
            log.error(e.getClass().getName() + " in " + e.getStackTrace()[0].getFileName() + " in line "
                    + e.getStackTrace()[0].getLineNumber(), e);
            return new CustomResponse<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/login")
    public String test() {
        return "test";
    }
}
