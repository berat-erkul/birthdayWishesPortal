//ckage beraterkul.birthdaywishesportal.service;
//
//port beraterkul.birthdaywishesportal.dto.MessageDTO;
//port beraterkul.birthdaywishesportal.entity.Message;
//
//port java.time.LocalDate;
//port java.util.List;
//
//blic interface MessageService {
//  List<MessageDTO> findAll();
//  List<MessageDTO> findByUserId(Long id);
//  List<MessageDTO> findAllBySenderId(Long id);
//  List<MessageDTO> findBySentDateAfter(LocalDate date); //to fetch messages of "last one year"
//  MessageDTO getById(Long id);
//  MessageDTO save(MessageDTO message);
//
//