package com.test.paymenttracking.service;

import com.test.paymenttracking.dto.UsersDto;
import com.test.paymenttracking.entity.Users;
import com.test.paymenttracking.repository.UsersRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsersService {

    private final UsersRepo usersRepo;

    public Users save(UsersDto dto) {
        Users users = new Users();
        users.setFirstname(dto.getFirstname());
        users.setLastname(dto.getLastname());
        users.setContactInfo(dto.getContactInfo());
        users.setRole(dto.getRole());
        users.setCreatedDate(LocalDateTime.now());
        return usersRepo.save(users);
    }

    public Users update(int userId, UsersDto dto) {
        Users users = findById(userId);
        return usersRepo.save(users);

    }

    public Users findById(int id) {
        Optional<Users> optionalUsers = usersRepo.findById(id);
        if (optionalUsers.isPresent()) {
            return optionalUsers.get();
        }
        throw new RuntimeException("User with id " + id + " not found");
    }

    public List<Users> findByRole(String role) {
        return usersRepo.findByRole(role);
    }

    public String delete(int userId) {
        Users user = findById(userId);
        usersRepo.delete(user);
        return "Successfully Deleted";
    }

    public List<Users> findAllUser() {
        return usersRepo.findAll();
    }
}
