package com.example.demox.service;
import com.example.demox.entity.User;
import com.example.demox.model.Role;
import com.example.demox.model.UserDto;
import com.example.demox.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class UserService {
    private UserRepository userRepository;
    private ModelMapper modelMapper;

    @Autowired
    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }
    public void saveUser(UserDto userDto)throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String newDateFormat=sdf.format(new Date());
        userDto.getUserDetails().setJoinDate(sdf.parse(newDateFormat));
        userDto.setRole(Role.ROLE_USER);
        User userToSave=modelMapper.map(userDto, User.class);
        userRepository.save(userToSave);

    }
}
