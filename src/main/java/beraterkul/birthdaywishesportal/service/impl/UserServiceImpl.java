package beraterkul.birthdaywishesportal.service.impl;

import beraterkul.birthdaywishesportal.dto.UserDTO;
import beraterkul.birthdaywishesportal.entity.User;
import beraterkul.birthdaywishesportal.repository.UserRepository;
import beraterkul.birthdaywishesportal.service.UserService;
import org.springframework.stereotype.Service;
import com.cydeo.mapper.MapperUtil;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final MapperUtil mapper;

    public UserServiceImpl(UserRepository userRepository, MapperUtil mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Override
    public UserDTO getById(long id) {
        return null;
    }

    @Override
    public UserDTO getByFirstName(String firstName) {
        return null;
    }

    @Override
    public UserDTO save(UserDTO userDTO) {
        userRepository.save(mapper.convert(userDTO, User.class));
        return userDTO;
    }

    @Override
    public boolean existsByEmail(String email) {
        return false;
    }

    @Override
    public void deleteById(Long id) {

    }
}
