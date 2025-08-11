package beraterkul.birthdaywishesportal.service.impl;

import beraterkul.birthdaywishesportal.dto.MessageDTO;
import beraterkul.birthdaywishesportal.dto.UserDTO;
import beraterkul.birthdaywishesportal.entity.Message;
import beraterkul.birthdaywishesportal.enums.UserRole;
import beraterkul.birthdaywishesportal.mapper.MapperUtil;
import beraterkul.birthdaywishesportal.repository.MessageRepository;
import beraterkul.birthdaywishesportal.repository.UserRepository;
import beraterkul.birthdaywishesportal.service.MessageService;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;


@Service
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;
    private final MapperUtil mapper;
    private final UserRepository userRepository;

    public MessageServiceImpl(MessageRepository messageRepository, MapperUtil mapper, UserRepository userRepository) {
        this.messageRepository = messageRepository;
        this.mapper = mapper;
        this.userRepository = userRepository;
    }

    @Override
    public List<MessageDTO> findAll() {
        List<Message> messages = messageRepository.findAll();
        return messages.stream().map(
                        message -> mapper.convert(message, MessageDTO.class))
                .toList();
    }

    @Override //I don't think this is needed, but let's keep it for now
    public List<MessageDTO> findByUserId(Long id) {
        return List.of();
    }

    @Override
    public List<MessageDTO> findAllBySenderId(Long id) {
        UserDTO user = mapper.convert(userRepository.getById(id), UserDTO.class);

        System.out.println("Role in DTO: " + user.getRole());
        System.out.println("Type: " + user.getRole().getClass());

        if(user.getRole().getValue().equalsIgnoreCase(UserRole.STUDENT.getValue())){
            List<Message> messages = messageRepository.findAllBySender_Id(id);
            return messages.stream().map(message -> mapper.convert(message, MessageDTO.class)).toList();
        }

        List<Message> messages = messageRepository.findAll();
        return messages.stream().map(message -> mapper.convert(message, MessageDTO.class)).toList();
    }

    @Override
    public List<MessageDTO> findLastMessages() {
        //find messages sent in the last one year
        LocalDate oneYearAgo = LocalDate.now().minusYears(1);
        List<Message> lastMessages = messageRepository.findBySentDateAfter(oneYearAgo);
        return lastMessages.stream().map(message -> mapper.convert(message, MessageDTO.class)).toList();
    }

    @Override
    public MessageDTO getById(Long id) {
        return mapper.convert(messageRepository.getById(id), MessageDTO.class);
    }

    @Override
    public MessageDTO save(MessageDTO message) {
        messageRepository.save(mapper.convert(message, Message.class));
        // We'll set date etc here

        return message;
    }

}