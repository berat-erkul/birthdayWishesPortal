package beraterkul.birthdaywishesportal.service.impl;

import beraterkul.birthdaywishesportal.dto.MessageDTO;
import beraterkul.birthdaywishesportal.entity.Message;
import beraterkul.birthdaywishesportal.mapper.MapperUtil;
import beraterkul.birthdaywishesportal.repository.MessageRepository;
import beraterkul.birthdaywishesportal.service.MessageService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

import static java.util.Arrays.stream;

@Service
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;
    private final MapperUtil mapper;

    public MessageServiceImpl(MessageRepository messageRepository, MapperUtil mapper) {
        this.messageRepository = messageRepository;
        this.mapper = mapper;
    }

    @Override
    public List<MessageDTO> findAll() {
        List<Message> messages = messageRepository.findAll();
        return messages.stream().map(
                        message -> mapper.convert(message, MessageDTO.class))
                .toList();
    }

    @Override
    public List<MessageDTO> findByUserId(Long id) {
        return List.of();
    }

    @Override
    public List<MessageDTO> findAllBySenderId(Long id) {
        return List.of();
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
        return null;
    }

    @Override
    public MessageDTO save(MessageDTO message) {
        return null;
    }

}