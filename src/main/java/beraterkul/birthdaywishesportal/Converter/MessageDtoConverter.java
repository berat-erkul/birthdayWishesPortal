//package beraterkul.birthdaywishesportal.Converter;
//
//import beraterkul.birthdaywishesportal.dto.UserDTO;
//import beraterkul.birthdaywishesportal.service.UserService;
//import org.springframework.core.convert.converter.Converter;
//
//public class MessageDtoConverter implements Converter<String, UserDTO> {
//
//    private final UserService userService;
//
//    public MessageDtoConverter(UserService userService) {
//        this.userService = userService;
//    }
//
//    @Override
//    public UserDTO convert(String source) {
//        return userService.getByFirstName(source); //We should use more specific identifier like ID or email in a real application
//    }
//
//}