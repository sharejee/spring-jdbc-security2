package com.mkyong.domain.services.impl;

import com.mkyong.domain.models.SecUser;
import com.mkyong.domain.repositories.SecUserRepository;
import com.mkyong.domain.services.SecUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
Create By: Ron Rith
Create Date: 2/12/2018
*/
@Service("secUserService")
public class SecUserServiceImpl implements SecUserService {
    @Autowired
    private SecUserRepository secUserRepository;

    public List<SecUser> getAllUsers() {
        return (List<SecUser>) secUserRepository.getAllUsers();
    }

    public SecUser getUserById(String username) {
        return null;
    }

    public void saveUser(SecUser secUser) {

    }

    public void updateUser(SecUser secUser, String username) {

    }
}
