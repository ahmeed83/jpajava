package jpajava.domain;

import lombok.Data;
import lombok.Generated;

import javax.persistence.*;

@Data
@Entity
@Table(name = "MESSAGE")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;
    @Column(name = "TEXT")
    private String text;

    public Message() {
    }

    public Message(final String text) {
        this.text = text;
    }
}
