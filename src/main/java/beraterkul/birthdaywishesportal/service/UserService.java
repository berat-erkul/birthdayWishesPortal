package beraterkul.birthdaywishesportal.service;

import beraterkul.birthdaywishesportal.dto.UserDTO;
import java.util.List;

public interface UserService {

    UserDTO getById(long id);
    UserDTO getByFirstName(String firstName);
    UserDTO save(UserDTO user);
    UserDTO findByEmail(String email);
    boolean existsByEmail(String email);
    void delete(String mail);
    boolean updateUser(UserDTO userDTO);
    List<UserDTO> findAll();
}
