package me.junrup.projects.service;

import me.junrup.projects.exception.AdException;
import me.junrup.projects.vo.CreateUserRequest;
import me.junrup.projects.vo.CreateUserResponse;

public interface IUserService {

    /**
     * Create User.
     * @param request
     * @return
     * @throws AdException
     */
    CreateUserResponse createUser(CreateUserRequest request)
        throws AdException;
}
