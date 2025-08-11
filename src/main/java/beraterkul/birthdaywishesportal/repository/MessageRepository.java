package beraterkul.birthdaywishesportal.repository;

import beraterkul.birthdaywishesportal.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    List<Message> findAll();
    List<Message> findAllByReceiver_Id(Long id);
    List<Message> findAllBySender_Id(Long id);
    List<Message> findBySentDateAfter(LocalDate date); //to fetch messages of "last one year"
    List<Message> findBySentDateBefore(LocalDate date); //**************************
    Message getById(Long id);
    Message save(Message message);

}
