package beraterkul.birthdaywishesportal.service;

import beraterkul.birthdaywishesportal.dto.UserDTO;
import beraterkul.birthdaywishesportal.entity.User;

import java.util.List;

public interface UserService {

    UserDTO getById(long id);
    UserDTO getByFirstName(String firstName);
    UserDTO save(UserDTO user);
    boolean existsByEmail(String email);
    void deleteById(Long id);
    boolean updateUser(UserDTO userDTO);
    List<UserDTO> findAll();
}
