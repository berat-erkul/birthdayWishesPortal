package beraterkul.birthdaywishesportal.service.impl;

import beraterkul.birthdaywishesportal.dto.UserDTO;
import beraterkul.birthdaywishesportal.entity.User;
import beraterkul.birthdaywishesportal.mapper.MapperUtil;
import beraterkul.birthdaywishesportal.repository.UserRepository;
import beraterkul.birthdaywishesportal.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final MapperUtil mapper;

    // ******************* - Using @Lazy to avoid circular dependency issues - *******************
    public UserServiceImpl(UserRepository userRepository, MapperUtil mapper, @Lazy UserService userService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.mapper = mapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDTO getById(long id) {
        return userRepository.findById(id)
                .map(user -> mapper.convert(user, UserDTO.class))
                .orElseThrow(() -> new EntityNotFoundException("User not found with id " + id));
    }

    @Override
    public UserDTO getByFirstName(String firstName) {
        return mapper.convert(userRepository.getByFirstName(firstName), UserDTO.class);
    }

    @Override
    public UserDTO save(UserDTO userDTO) {

        if(!existsByEmail(userDTO.getEmail())){
            User user = mapper.convert(userDTO, User.class);
            user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
            userRepository.save(user);
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

    @Override
    public List<UserDTO> findAllTeachers() {
        return userRepository.findAll().stream()
                .filter(user -> user.getRole() != null
                        && "TEACHER".equalsIgnoreCase(user.getRole().getValue()))
                .map(user -> mapper.convert(user, UserDTO.class))
                .collect(Collectors.toList());
    }



}