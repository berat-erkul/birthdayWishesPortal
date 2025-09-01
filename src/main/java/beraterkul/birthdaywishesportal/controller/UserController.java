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

    @GetMapping("/user/update/{mail}")
    public String update(@PathVariable("mail") String mail, Model model) {
        UserDTO userDTO = userService.findByEmail(mail);

        System.out.println("User found: " + userDTO.toString());

        model.addAttribute("user", userDTO);
        return "user/update";
    }

    @PostMapping("/user/update/{mail}")
    public String update(@PathVariable("mail") String mail, @ModelAttribute("user") UserDTO user, Model model) {

        model.addAttribute("user", userService.updateUser(user));

        userService.updateUser(user);
        return "redirect:/user/list";
    }

    //--------------------------------------------------------------------------
    @GetMapping("/user/delete/{mail}")
    public String delete(@PathVariable("mail") String mail, Model model) {
        userService.delete(mail);
        System.out.println("User with email " + mail + " deleted.");
        return "redirect:/user/list";
    }
    //--------------------------------------------------------------------------

    @GetMapping("/user/list")
    public String list(Model model) {
        model.addAttribute("users", userService.findAll());
        return "user/list";
    }





    //------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new UserDTO());
        return "user/login";
    }

    //------------------------------------------------------------------------------------

    @GetMapping("/welcome/admin")
    public String welcome() {

        return "welcome/admin";
    }

}