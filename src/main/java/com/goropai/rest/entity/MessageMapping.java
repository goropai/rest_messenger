package com.goropai.rest.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Objects;

@XmlRootElement
@Entity
@Table(name = "messenger_map")
public class MessageMapping implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @JoinColumn(name = "to_id")
    @ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private User to_id;

    @NotNull
    @JoinColumn(name = "from_id")
    @ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private User from_id;

    @NotNull
    @JoinColumn(name = "message_id")
    @ManyToOne(targetEntity = Message.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Message message_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getTo_id() {
        return to_id;
    }

    public void setTo_id(User to_id) {
        this.to_id = to_id;
    }

    public User getFrom_id() {
        return from_id;
    }

    public void setFrom_id(User from_id) {
        this.from_id = from_id;
    }

    public Message getMessage_id() {
        return message_id;
    }

    public void setMessage_id(Message message_id) {
        this.message_id = message_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageMapping that = (MessageMapping) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(to_id, that.to_id) &&
                Objects.equals(from_id, that.from_id) &&
                Objects.equals(message_id, that.message_id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, to_id, from_id, message_id);
    }

    @Override
    public String toString() {
        return "MessageMapping{" +
                "id=" + id +
                ", to_id=" + to_id +
                ", from_id=" + from_id +
                ", message_id=" + message_id +
                '}';
    }
}
