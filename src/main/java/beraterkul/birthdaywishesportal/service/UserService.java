package beraterkul.birthdaywishesportal.service;

import beraterkul.birthdaywishesportal.dto.UserDTO;
import beraterkul.birthdaywishesportal.entity.User;

public interface UserService {

    UserDTO getById(long id);
    UserDTO getByFirstName(String firstName);
    UserDTO save(UserDTO user);
    boolean existsByEmail(String email);
    void deleteById(Long id);
}
