package beraterkul.birthdaywishesportal.service.impl;

import beraterkul.birthdaywishesportal.dto.UserDTO;
import beraterkul.birthdaywishesportal.entity.User;
import beraterkul.birthdaywishesportal.mapper.MapperUtil;
import beraterkul.birthdaywishesportal.repository.UserRepository;
import beraterkul.birthdaywishesportal.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final MapperUtil mapper;

    // ******************* - Using @Lazy to avoid circular dependency issues - *******************
    public UserServiceImpl(UserRepository userRepository, MapperUtil mapper, @Lazy UserService userService) {
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

        System.out.println("---------------------------------------");
        System.out.println("/USER/SAVE POST METHOD CALLED");
        System.out.println("---------------------------------------");

        if(!existsByEmail(userDTO.getEmail())){
            userRepository.save(mapper.convert(userDTO, User.class));
        }else{
            //throw new RuntimeException("User with email " + userDTO.getEmail() + " already exists.");
        }
        return userDTO;
    }

    @Override
    public UserDTO findByEmail(String email) {
        return mapper.convert(userRepository.findByEmail(email), UserDTO.class);
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    @Transactional  //-----**********------
    public void delete(String mail) {
        User user = userRepository.findByEmail(mail);
        if (user != null) {
            user.setDeleted(true);

            user.setEmail(user.getEmail() + "-" + user.getId()); // Optional: make email unique again

            userRepository.save(user); // güvenli olması için ekle
        }
    }

    @Override
    public boolean updateUser(UserDTO userDTO) {
        if(!userRepository.existsById(userDTO.getId())){
            System.out.println("User does not exist");
            return false;
        }

        User user = mapper.convert(userDTO, User.class);
        userRepository.save(user);
        System.out.println("User updated successfully: " + userDTO.getEmail());
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
