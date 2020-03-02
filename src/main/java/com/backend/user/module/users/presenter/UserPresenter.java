package com.backend.user.module.users.presenter;

import com.backend.user.module.users.domain.Users;
import com.backend.user.module.users.usecase.UserUseCaseImpl;
import com.backend.user.util.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/")
public class UserPresenter {

    @Autowired
    private UserUseCaseImpl userUseCase;

    @Autowired
    private BaseResponse baseResponse;

    @GetMapping("users")
    @ResponseStatus(HttpStatus.OK)
    public BaseResponse getAllUsers() {
        List<Users> usersList = userUseCase.findAllUsers();
        baseResponse.setStatus(HttpStatus.OK);
        baseResponse.setResult(usersList);
        return baseResponse;
    }

    @GetMapping("user/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BaseResponse getSingleUser(@PathVariable Long id) {
        Optional<Users> usersOptional = userUseCase.findUserById(id);
        baseResponse.setStatus(HttpStatus.OK);
        baseResponse.setResult(usersOptional);
        return baseResponse;
    }

    @PostMapping("user")
    @ResponseStatus(HttpStatus.CREATED)
    public BaseResponse createNewUser(@RequestBody Users usersPayload) {
        Users usersCreate = userUseCase.createNewUsers(usersPayload);
        baseResponse.setStatus(HttpStatus.CREATED);
        baseResponse.setResult(usersCreate);
        return baseResponse;
    }

    @PutMapping("user/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BaseResponse updateUser(
            @PathVariable Long id,
            @RequestBody Users usersPayload) {
        Users usersUpdate = userUseCase.updateUser(id, usersPayload);
        baseResponse.setStatus(HttpStatus.OK);
        baseResponse.setResult(usersUpdate);
        return baseResponse;
    }

    @DeleteMapping("user/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BaseResponse deleteUser(@PathVariable Long id) {
        Users usersDelete = userUseCase.deleteUser(id);
        baseResponse.setStatus(HttpStatus.OK);
        baseResponse.setResult(usersDelete);
        return baseResponse;
    }
}
