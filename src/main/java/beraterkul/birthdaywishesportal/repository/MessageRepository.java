//package beraterkul.birthdaywishesportal.repository;
//
//import beraterkul.birthdaywishesportal.entity.Message;
//import beraterkul.birthdaywishesportal.entity.User;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import java.time.LocalDate;
//import java.util.List;
//
//@Repository
//public interface MessageRepository extends JpaRepository<Message, Long> {
//
//    List<Message> findAll();
//    List<Message> findByUser_Id(Long id);
//    List<Message> findAllBySenderId(Long id);
//    List<Message> findBySentDateAfter(LocalDate date); //to fetch messages of "last one year"
//    Message getById(Long id);
//    Message save(Message message);
//
//}
//