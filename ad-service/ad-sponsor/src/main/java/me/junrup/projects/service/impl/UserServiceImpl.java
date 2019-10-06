package me.junrup.projects.service.impl;

import lombok.extern.slf4j.Slf4j;
import me.junrup.projects.constant.Constants;
import me.junrup.projects.dao.AdUserRepository;
import me.junrup.projects.entity.AdUser;
import me.junrup.projects.exception.AdException;
import me.junrup.projects.service.IUserService;
import me.junrup.projects.utils.CommonUtils;
import me.junrup.projects.vo.CreateUserRequest;
import me.junrup.projects.vo.CreateUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
public class UserServiceImpl implements IUserService {

    private final AdUserRepository userRepository;

    @Autowired
    public UserServiceImpl(AdUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public CreateUserResponse createUser(CreateUserRequest request) throws AdException {
        if (!request.validate()) {
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAM_ERROR);
        }

        AdUser oldUser = userRepository.findByUsername(request.getUsername());
        if (oldUser != null) {
            throw new AdException(Constants.ErrorMsg.SAME_NAME_ERROR);
        }

        AdUser newUser = userRepository.save(new AdUser(request.getUsername(),
                CommonUtils.md5(request.getUsername())));
        return new CreateUserResponse(
                newUser.getId(), newUser.getUsername(), newUser.getToken(),
                newUser.getCreateTime(), newUser.getUpdateTime()
        );
    }
}
