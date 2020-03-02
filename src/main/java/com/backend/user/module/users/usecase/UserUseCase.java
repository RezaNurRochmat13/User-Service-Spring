package com.backend.user.module.users.usecase;

import com.backend.user.module.users.domain.Users;

import java.util.List;
import java.util.Optional;

public interface UserUseCase {
    List<Users> findAllUsers();
    Optional<Users> findUserById(Long id);
    Users createNewUsers(Users usersPayload);
    Users updateUser(Long id, Users usersPayload);
    Users deleteUser(Long id);
}
