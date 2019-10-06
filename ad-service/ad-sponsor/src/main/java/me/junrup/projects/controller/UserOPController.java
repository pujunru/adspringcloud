package me.junrup.projects.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import me.junrup.projects.exception.AdException;
import me.junrup.projects.service.IUserService;
import me.junrup.projects.vo.CreateUserRequest;
import me.junrup.projects.vo.CreateUserResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class UserOPController {

    private final IUserService userService;

    public UserOPController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create/user")
    public CreateUserResponse createUser(@RequestBody CreateUserRequest request) throws AdException {
        log.info("ad-sponsor: createUser -> {}", JSON.toJSONString(request));
        return userService.createUser(request);
    }

}
