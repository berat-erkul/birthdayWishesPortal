package beraterkul.birthdaywishesportal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageDTO {

    // private Long id;
    private UserDTO sender;
    private UserDTO receiver;
    private String content;
    private LocalDate sentDate;
    private MessageDTO replyToMessageDTO;

}
