package com.mkyong.domain.controllers.users;

import com.mkyong.domain.models.SecUser;
import com.mkyong.domain.services.SecUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
Create By: Ron Rith
Create Date: 2/12/2018
*/
@RestController
public class UserRestController {
   @Autowired
   public SecUserService secUserService;

    @RequestMapping(value = "/api/users",method = RequestMethod.GET)
    public List<SecUser> getAllUsers() {
        List<SecUser> secUsers =  (List<SecUser>) secUserService.getAllUsers();
        return secUsers;
    }
}
