package beraterkul.birthdaywishesportal.service;

import beraterkul.birthdaywishesportal.dto.MessageDTO;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

public interface MessageService {
    List<MessageDTO> findAll();

    List<MessageDTO> findByUserId(Long id);

    List<MessageDTO> findAllBySenderId(Long id);

    List<MessageDTO> findLastMessages();

    MessageDTO getById(Long id);

    MessageDTO save(MessageDTO message);



}