package beraterkul.birthdaywishesportal.controller;

import beraterkul.birthdaywishesportal.dto.MessageDTO;
import beraterkul.birthdaywishesportal.service.impl.MessageServiceImpl;
import beraterkul.birthdaywishesportal.service.impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MessageController {

    private final MessageServiceImpl messageService;
    private final UserServiceImpl userService;

    public MessageController(MessageServiceImpl messageService, UserServiceImpl userService) {
        this.messageService = messageService;
        this.userService = userService;
    }

    @GetMapping("/message/list")
    public String listMessages(Model model) {
        model.addAttribute("messageDTOs", messageService.findAll());
        return "message/list";
    }

    //------ Teacher Part --------

    @GetMapping("/message/last")
    public String lastMessages(Model model) {
        model.addAttribute("messages", messageService.findLastMessages());
        return "message/last-list";
    }

    @GetMapping("/message/reply/{messageID}")
    public String replyMessage(@PathVariable Long messageID, Model model) {
        model.addAttribute("message", messageService.getById(messageID));
        return "message/reply";
    }

    //---------------*****************--------------------
    @PostMapping("/message/reply/{id}/send")
    public String sendMessageReply (@PathVariable String id, Model model){
        // findMessageById(id).setReplyToMessage(new Message("4", new UserDTO("Seda", "Canbazoğlu"), null, "Reply to message with id: " + id, LocalDate.now(), null));

        return "redirect:message/last";
        //createReply(Message reply, String id);
    }

    //----- Maybe I will use this later to create a reply -----
    @GetMapping("/message/create/{studentID}")
    public String createMessage(@PathVariable("studentID") Long id, Model model) {
        MessageDTO messageDTO = new MessageDTO();

        model.addAttribute("message", messageDTO);
        model.addAttribute("teachers", userService.findAllTeachers());

        return "message/create";
    }

    @PostMapping("/message/create/{studentID}/send")
    public String sendMessage(@PathVariable("studentID") Long id, @ModelAttribute MessageDTO messageDTO, Model model) {
        messageDTO.setSender(userService.getById(id)); //if could not find user by id, it will throw an exception
        messageDTO.setReceiver(userService.getByFirstName("Seda"));
        messageService.save(messageDTO);

        return "redirect:/message/list/" + id;
    }

    @GetMapping("/message/list/{id}")
    public String listMessagesById(@PathVariable("id") Long id, Model model) {
        model.addAttribute("messageDTOs", messageService.findAllBySenderId(id));
        model.addAttribute("user",userService.getById(id));

        System.out.println("Messages for user with ID: " + id);
        System.out.println("Messages: " + messageService.findAllBySenderId(id).stream().toList());

        return "message/list";
    }


}