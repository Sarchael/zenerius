package pl.sarchael.zenerius.users.entities;

import lombok.*;
import org.springframework.util.StringUtils;
import pl.sarchael.zenerius.users.model.enums.Gender;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String login;
    private String password;
    private String email;
    private Boolean active;
    private Boolean emailConfirmed;

    @Transient
    private Gender gender;

    @Basic
    @Column(name = "gender")
    private String genderBasic;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles",
               joinColumns = @JoinColumn(name = "user_id"),
               inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @PostLoad
    private void genderFromBasic() {
        if (!StringUtils.isEmpty(this.genderBasic))
            this.gender = Gender.getByCode(this.genderBasic);
    }

    @PrePersist
    private void basicFromGender() {
        if (this.gender != null)
            this.genderBasic = this.gender.getCode();
    }
}
