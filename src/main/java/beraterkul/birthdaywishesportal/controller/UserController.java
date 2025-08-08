package beraterkul.birthdaywishesportal.controller;

import beraterkul.birthdaywishesportal.dto.UserDTO;
import beraterkul.birthdaywishesportal.service.impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/user/create")
    public String create(Model model) {
        model.addAttribute("user", new UserDTO());
        return "user/create";
    }

    @PostMapping("/user/create")
    public String create(@ModelAttribute("user") UserDTO userDTO, Model model) {

        userService.save(userDTO);
        model.addAttribute("users", userDTOS);


        return "user/list";
        // createUser()
    }


    @GetMapping("/user/update/{id}")
    public String update(@PathVariable("id") String id, Model model) {

        //We'll check if the user exists in our list
        //Then we'll present the form with the user's data

        return "user/update"; // Aynı form, ama dolu haliyle
        // findByUserID(String id)
    }

    @PostMapping("/user/update/{id}")
    public String update(@PathVariable("id") String id, @ModelAttribute("user") UserDTO userDTO, Model model) {



        return "user/list";
        // updateUserByID(UserDTO userDTO, String id)
    }

    @GetMapping("/user/delete/{id}")
    public String delete(@PathVariable("id") String id, Model model) {



        return "user/list";
        // deleteUserByID(String id)
    }



}
