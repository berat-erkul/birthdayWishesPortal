package beraterkul.birthdaywishesportal.controller;

import beraterkul.birthdaywishesportal.dto.MessageDTO;
import beraterkul.birthdaywishesportal.dto.UserDTO;
import beraterkul.birthdaywishesportal.service.impl.MessageServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Controller
public class MessageController {

    private final MessageServiceImpl messageService;

    public MessageController(MessageServiceImpl messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/message/list")
    public String listMessages(Model model) {

        // model.addAttribute("messages", findAllMessages());
        UserDTO dummySender = new UserDTO();
        dummySender.setFirstName("Berat");
        dummySender.setLastName("Erkul");

        /* MessageDTO messageDTO = new MessageDTO("1", dummySender, null, "Hello World!", LocalDate.now(),
                new MessageDTO("2", dummySender, null, "Reply to Hello World!", LocalDate.now(), null));
        MessageDTO messageDTO2 = new MessageDTO("3", dummySender, null, "Second main message!", LocalDate.now(), null);
        List<MessageDTO> messageDTOS = Arrays.asList(messageDTO, messageDTO2);
        */
        //  model.addAttribute("messages", messageDTOS);

        return "message/list";
        // findAllMessages()
    }


    //------ Teacher Part --------

    // Geçici in-memory "db"
    private final Map<Long, MessageDTO> fakeDb = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);


    @GetMapping("/message/last")
    public String lastMessage(Model model) {

        // model.addAttribute("message", findLastMessages());

        UserDTO dummySender = new UserDTO();
        dummySender.setFirstName("Berat");
        dummySender.setLastName("Erkul");

        /* MessageDTO messageDTO = new MessageDTO("1", dummySender, null, "Saynur'a 200 TL", LocalDate.now(),
                new MessageDTO("2", dummySender, null, "Her ayın 20 sinde", LocalDate.now(), null));
        MessageDTO messageDTO2 = new MessageDTO("3", dummySender, null, "Veeeer!", LocalDate.now(), null);
        List<MessageDTO> messageDTOS = Arrays.asList(messageDTO, messageDTO2);

        model.addAttribute("messages", messageDTOS);
        */

        return "message/last-list";
        // findLastMessage()
    }


    @GetMapping("/message/reply/{messageID}")
    public String replyMessage(@PathVariable Long messageID, Model model) {
        //Message studentMessage = messageService.getMessageById(messageID); // kendi servisine göre değiştir
        //model.addAttribute("message", studentMessage);

        //if (studentMessage.getReplyToMessage() != null) {
        //    model.addAttribute("replyToContent", studentMessage.getReplyToMessage().getContent());
        //} else {
        //    model.addAttribute("replyToContent", null); // veya boş string
        //}

        return "message/reply"; // bu HTML dosyanın adı
    }

    @PostMapping("/message/reply/{id}/send")
    public String sendMessageReply (@PathVariable String id, Model model){


        // findMessageById(id).setReplyToMessage(new Message("4", new UserDTO("Seda", "Canbazoğlu"), null, "Reply to message with id: " + id, LocalDate.now(), null));

        return "redirect:message/last";
        //createReply(Message reply, String id);
    }

    @GetMapping("/message/create/{studentID}")
    public String createMessage(@PathVariable("studentID") String id, Model model) {

        // model.addAttribute("message", new Message().setSender(findByStudentId(id)));

        return "message/create";
    }

    @PostMapping("/message/create/{studentID}/send")
    public String sendMessage(@PathVariable("studentID") String id, @ModelAttribute MessageDTO messageDTO, Model model) {

        // saveMessage(message.setReceiver(findUserByFirstName("Seda")));

        return "redirect:/message/list/" + id;
    }


/*
    @GetMapping("/message/list/{id}")
    public String listMessagesById(@PathVariable("id") String id, Model model) {

        // model.addAttribute("messages", findAllMessagesById(id));


        return "message/list";
    }
*/

}
