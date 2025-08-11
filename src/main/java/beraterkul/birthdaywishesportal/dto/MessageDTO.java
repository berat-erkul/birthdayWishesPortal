package beraterkul.birthdaywishesportal.dto;

import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageDTO {

    private Long id;
    private UserDTO sender;
    private UserDTO receiver;
    private String content;
    private LocalDate sentDate;
    private MessageDTO replyToMessageDTO;
}
