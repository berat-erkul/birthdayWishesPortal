package beraterkul.birthdaywishesportal.repository;

import beraterkul.birthdaywishesportal.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    //Crud and more

    User getById(long id);
    User getByFirstName(String firstName);
    User save(User user);
    boolean existsByEmail(String email);
    void deleteById(Long id);

}
