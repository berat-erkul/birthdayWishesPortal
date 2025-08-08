package beraterkul.birthdaywishesportal.controller;

import beraterkul.birthdaywishesportal.dto.UserDTO;
import beraterkul.birthdaywishesportal.service.impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
        return "redirect:/user/list";
    }

    //********************************
    @GetMapping("/user/update/{id}")
    public String update(@PathVariable("id") Long id, Model model) {


        return "user/update"; // Aynı form, ama dolu haliyle
        // findByUserID(String id)
    }

    //********************************
    @PostMapping("/user/update/{id}")
    public String update(@PathVariable("id") String id, @ModelAttribute("user") UserDTO userDTO, Model model) {



        return "user/list";
        // updateUserByID(UserDTO userDTO, String id)
    }

    //********************************
    @GetMapping("/user/delete/{id}")
    public String delete(@PathVariable("id") String id, Model model) {



        return "user/list";
        // deleteUserByID(String id)
    }


    @GetMapping("/user/list")
    public String list(Model model) {
        model.addAttribute("users", userService.findAll());
        return "user/list";
    }


}
