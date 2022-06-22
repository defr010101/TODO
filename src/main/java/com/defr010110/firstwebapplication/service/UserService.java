package com.defr010110.firstwebapplication.service;

import com.defr010110.firstwebapplication.entity.UserEntity;
import com.defr010110.firstwebapplication.exception.UserAlreadyExistException;
import com.defr010110.firstwebapplication.exception.UserNotFoundException;
import com.defr010110.firstwebapplication.model.User;
import com.defr010110.firstwebapplication.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public UserEntity registration(UserEntity user) throws UserAlreadyExistException {
        if (userRepo.findByUsername(user.getUsername()) != null) {
            throw new UserAlreadyExistException("Пользователь с таким именем уже существует");
        }
        return userRepo.save(user);
    }

    public User findOne(Long id) throws UserNotFoundException {
        UserEntity user = userRepo.findById(id).get();
        if (user == null) {
            throw new UserNotFoundException("Пользователь не найден");
        }
        return User.toModel(user);
    }

    public Long deleteUser(Long id) {
        userRepo.deleteById(id);
        return id;
    }
}
