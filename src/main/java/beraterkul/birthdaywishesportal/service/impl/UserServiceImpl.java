package beraterkul.birthdaywishesportal.service.impl;

import beraterkul.birthdaywishesportal.dto.UserDTO;
import beraterkul.birthdaywishesportal.entity.User;
import beraterkul.birthdaywishesportal.mapper.MapperUtil;
import beraterkul.birthdaywishesportal.repository.UserRepository;
import beraterkul.birthdaywishesportal.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


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
        if(!existsByEmail(userDTO.getEmail())){
            userRepository.save(mapper.convert(userDTO, User.class));
        }else{
            //throw new RuntimeException("User with email " + userDTO.getEmail() + " already exists.");
        }
        return userDTO;
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public boolean updateUser(UserDTO userDTO) {
        if(!userRepository.existsById(userDTO.getId())){
            return false; // User does not exist
        }

        User user = mapper.convert(userDTO, User.class);
        userRepository.save(user);
        return true;
    }

    @Override
    public List<UserDTO> findAll() {
        System.out.println("Finding all users...");
        List<User> users = userRepository.findAll();
        System.out.println("Total users found: " + users.size());

        return users.stream()
                .map(user -> mapper.convert(user, UserDTO.class))
                .collect(Collectors.toList());

    }

}
