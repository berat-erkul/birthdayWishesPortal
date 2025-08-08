package beraterkul.birthdaywishesportal.dto;


import beraterkul.birthdaywishesportal.enums.UserRole;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor

@Data
@Getter
@Setter
public class UserDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private LocalDate birthday;
    private UserRole role;

}
