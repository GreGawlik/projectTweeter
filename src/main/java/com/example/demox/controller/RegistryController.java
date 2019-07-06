package com.example.demox.controller;

import com.example.demox.entity.User;
import com.example.demox.model.UserDto;
import com.example.demox.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;

@Controller
public class RegistryController {
@Autowired
    private UserService userService;
    @GetMapping("/registration")
    public String addUser(Model model){
         model.addAttribute("userToInsert", new UserDto());
         return "registration";
    }

    @PostMapping("/registeruser")
    public String addUser(@ModelAttribute UserDto userDto)throws ParseException{
      userService.saveUser(userDto);
        return "userSaveResult";

}
}