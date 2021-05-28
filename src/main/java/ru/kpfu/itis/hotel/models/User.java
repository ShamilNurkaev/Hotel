package ru.kpfu.itis.hotel.models;

import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author Shamil Nurkaev @nshamil
 * 11-903
 * Sem 1
 */

//@Data
@Getter
@Setter
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_hotel")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String hashPassword;

    @Enumerated(value = EnumType.STRING)
    private State state;
    @Enumerated(value = EnumType.STRING)
    private Role role;
    @ToString.Exclude
    @Nullable
    @OneToMany(mappedBy = "user")
    private List<Room> rooms;

    public boolean isActive() {
        return this.state == State.ACTIVE_STATE;
    }

    public boolean isBanned() {
        return this.state == State.BANNED_STATE;
    }

    public boolean isAdmin() {
        return this.role == Role.ADMIN_ROLE;
    }

    public enum State {
        ACTIVE_STATE, BANNED_STATE
    }

    public enum Role {
        USER_ROLE, ADMIN_ROLE
    }


}
