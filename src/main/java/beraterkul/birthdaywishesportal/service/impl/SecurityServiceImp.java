package beraterkul.birthdaywishesportal.service.impl;

import beraterkul.birthdaywishesportal.entity.User;
import beraterkul.birthdaywishesportal.entity.UserPrincipal;
import beraterkul.birthdaywishesportal.mapper.MapperUtil;
import beraterkul.birthdaywishesportal.service.SecurityService;
import beraterkul.birthdaywishesportal.service.UserService;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecurityServiceImp implements SecurityService {

    private  final UserService userService;
    private final MapperUtil mapper;

    public SecurityServiceImp(UserService userService, MapperUtil mapper) {
        this.userService = userService;
        this.mapper = mapper;
    }

    // SecurityServiceImp sınıfında
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = mapper.convert(userService.findByEmail(email), User.class);
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                List.of(new SimpleGrantedAuthority(user.getRole().getValue())) // "ROLE_" prefix'ini kaldırın
        );
    }

}