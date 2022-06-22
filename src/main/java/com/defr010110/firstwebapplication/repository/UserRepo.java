package com.defr010110.firstwebapplication.repository;

import com.defr010110.firstwebapplication.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);
}
