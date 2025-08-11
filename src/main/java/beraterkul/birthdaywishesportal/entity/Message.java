package beraterkul.birthdaywishesportal.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "messages")
public class Message extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "sender_id",nullable = false)
    private User sender;

    @ManyToOne
    @JoinColumn(name = "reciever_id",nullable = false)
    private User receiver;

    @Column(nullable = true)
    private String content;

    @Column(nullable = true)
    private LocalDate sentDate;

    @ManyToOne
    @JoinColumn(nullable = true)
    private Message replyToMessageDTO;

}
