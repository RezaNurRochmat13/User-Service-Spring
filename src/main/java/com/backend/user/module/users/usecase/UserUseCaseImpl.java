package com.backend.user.module.users.usecase;

import com.backend.user.module.users.domain.Users;
import com.backend.user.module.users.repository.UserRepository;
import com.backend.user.util.ResourceNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserUseCaseImpl implements UserUseCase {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Users> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<Users> findUserById(Long id) {
        Optional<Users> usersOptional = Optional.ofNullable(userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Users not found with id " + id)));
        return usersOptional;
    }

    @Override
    public Users createNewUsers(Users usersPayload) {
        return userRepository.save(usersPayload);
    }

    @Override
    public Users updateUser(Long id, Users usersPayload) {
        Users usersFindById = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Users not found with id " + id));
        usersFindById.setUserName(usersPayload.getUserName());
        usersFindById.setUserAge(usersPayload.getUserAge());
        usersFindById.setUserAddress(usersPayload.getUserAddress());
        userRepository.save(usersFindById);
        return usersFindById;
    }

    @Override
    public Users deleteUser(Long id) {
        Users usersFindById = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Users not found with id " + id));
        userRepository.delete(usersFindById);
        return usersFindById;
    }
}
