package beraterkul.birthdaywishesportal.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "messages")
public class Message extends BaseEntity{

    @ManyToOne
    @JoinColumn(nullable = false)
    private User sender;

    @ManyToOne
    @JoinColumn(nullable = false)
    private User receiver;

    @Column(nullable = true)
    private String content;

    @Column(nullable = true)
    private LocalDate sentDate;

    @ManyToOne
    @JoinColumn(nullable = true)
    private Message replyToMessageDTO;

}
