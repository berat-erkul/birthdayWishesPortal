package beraterkul.birthdaywishesportal.service;

import beraterkul.birthdaywishesportal.dto.MessageDTO;
import beraterkul.birthdaywishesportal.entity.Message;

import java.time.LocalDate;
import java.util.List;

public interface MessageService {
    List<MessageDTO> findAll();
    List<MessageDTO> findByUserId(Long id);
    List<MessageDTO> findAllBySenderId(Long id);
    List<MessageDTO> findBySentDateAfter(LocalDate date); //to fetch messages of "last one year"
    MessageDTO getById(Long id);
    MessageDTO save(MessageDTO message);
}
