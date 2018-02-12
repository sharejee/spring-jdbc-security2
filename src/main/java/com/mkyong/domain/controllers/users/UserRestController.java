package com.mkyong.domain.controllers.users;

import com.mkyong.domain.models.SecUser;
import com.mkyong.domain.services.SecUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
Create By: Ron Rith
Create Date: 2/12/2018
*/
@RestController
@RequestMapping(value = "/api/users")
public class UserRestController {
   /* AbstractApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
    SecUserService secUserService = (SecUserService) context.getBean("secUserService");*/
   @Autowired
   private SecUserService secUserService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getAllUsers() {
        List<SecUser> secUsers =  (List<SecUser>) secUserService.getAllUsers();
        if(secUsers!=null){
            return new ResponseEntity<Object>(new CustomMessageType("data",2222,secUsers),HttpStatus.OK);
        }
        return new ResponseEntity<Object>(new CustomMessageType("no data",9999,secUsers),HttpStatus.NO_CONTENT);
    }
}
