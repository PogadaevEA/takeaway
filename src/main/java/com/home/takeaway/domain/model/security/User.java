package com.home.takeaway.domain.model.security;

import lombok.*;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Entity
@Table(name = "users")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    private String id;

    private String name;
    private String surname;
    private String middleName;
    private String phone;

    /**
     * Password's hash-sum
     */
    @ToString.Exclude
    private String password;

    /**
     * Not encoded password - temporary field
     */
    @ToString.Exclude
    private String passwordTemp;
    private String creator;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Role role;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created = new Date();

    public String getFIO() {
        return Stream.of(this.getSurname(), this.getName(), this.getMiddleName())
                .filter(value -> !StringUtils.isEmpty(value))
                .collect(Collectors.joining(" "));
    }
}