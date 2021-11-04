package com.constructWeek3.assure.service;

import com.constructWeek3.assure.AssureApplication;
import com.constructWeek3.assure.dto.UserDTO;
import com.constructWeek3.assure.entity.User;
import com.constructWeek3.assure.exception.UserExists;
import com.constructWeek3.assure.modelmapper.ModelMapperClass;
import com.constructWeek3.assure.repository.UserRepository;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ModelMapperClass modelMapperClass;

    static Logger logger = LoggerFactory.getLogger(AssureApplication.class);

    public Long addNewUser(UserDTO userDTO) {

        User user = modelMapperClass.modelMapper()
                .map(userDTO, new TypeToken<User>() {}.getType());

        List<User> userList = userRepository.findAll();

//        logger.info(String.valueOf(userDTO.getUserEmail()) + " " + userDTO.getUserName());

        for(User i : userList){
            if(i.getUserEmail().equals(user.getUserEmail())){
                throw new UserExists("Email Already Registered");
            }
//            logger.info(String.valueOf(i));
        }

        userRepository.save(user);

        return user.getUserId();
    }
}
