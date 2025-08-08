package beraterkul.birthdaywishesportal.service.impl;

import beraterkul.birthdaywishesportal.dto.MessageDTO;
import beraterkul.birthdaywishesportal.service.MessageService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {


    @Override
    public List<MessageDTO> findAll() {
        return List.of();
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
    public List<MessageDTO> findBySentDateAfter(LocalDate date) {
        return List.of();
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
