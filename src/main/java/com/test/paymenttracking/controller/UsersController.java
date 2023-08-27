package com.test.paymenttracking.controller;

import com.test.paymenttracking.commons.CustomResponse;
import com.test.paymenttracking.dto.UsersDto;
import com.test.paymenttracking.service.UsersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
@Slf4j
public class UsersController {

    @Autowired
    private UsersService usersService;

    @PostMapping(value = "")
    public CustomResponse<?> addUser(@RequestBody UsersDto usersDto) {
        try {
            return new CustomResponse<>(this.usersService.save(usersDto), HttpStatus.OK);

        } catch (Exception e) {
            log.error(e.getClass().getName() + " in " + e.getStackTrace()[0].getFileName() + " in line "
                    + e.getStackTrace()[0].getLineNumber(),e);
            return new CustomResponse<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "list")
    public CustomResponse<?> list() {
        try {
            return new CustomResponse<>(this.usersService.findAllUser(), HttpStatus.OK);

        } catch (Exception e) {
            log.error(e.getClass().getName() + " in " + e.getStackTrace()[0].getFileName() + " in line "
                    + e.getStackTrace()[0].getLineNumber(),e);
            return new CustomResponse<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "{userId}")
    public CustomResponse<?> getDetail(@PathVariable int userId) {
        try {
            return new CustomResponse<>(this.usersService.findById(userId), HttpStatus.OK);

        } catch (Exception e) {
            log.error(e.getClass().getName() + " in " + e.getStackTrace()[0].getFileName() + " in line "
                    + e.getStackTrace()[0].getLineNumber(),e);

            return new CustomResponse<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "{userId}")
    public CustomResponse<?> updateUser(@PathVariable int userId, @RequestBody UsersDto usersDto) {
        try {
            return new CustomResponse<>(this.usersService.update(userId,usersDto), HttpStatus.OK);

        } catch (Exception e) {
            log.error(e.getClass().getName() + " in " + e.getStackTrace()[0].getFileName() + " in line "
                    + e.getStackTrace()[0].getLineNumber(),e);
            return new CustomResponse<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "{userId}")
    public CustomResponse<?> deleteUser(@PathVariable int userId) {
        try {
            return new CustomResponse<>(this.usersService.delete(userId), HttpStatus.OK);

        } catch (Exception e) {
            log.error(e.getClass().getName() + " in " + e.getStackTrace()[0].getFileName() + " in line "
                    + e.getStackTrace()[0].getLineNumber(),e);
            return new CustomResponse<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
