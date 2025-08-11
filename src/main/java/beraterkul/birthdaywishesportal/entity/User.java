package beraterkul.birthdaywishesportal.entity;

import beraterkul.birthdaywishesportal.enums.UserRole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "users")
@Where(clause = "deleted = false")
public class User extends BaseEntity {

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = true)
    private LocalDate birthday; //0404

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRole role;

}
