package pl.sarchael.zenerius.users.model;

import lombok.*;
import pl.sarchael.zenerius.users.model.enums.Gender;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SignUpForm {
    @NotBlank(message = "Pole nie może być puste!")
    @Size(min = 8, message = "Login musi zawierać conajmniej 8 znaków")
    private String login;
    @NotBlank(message = "Pole nie może być puste!")
    @Size(min = 8, message = "Hasło musi zawierać conajmniej 8 znaków")
    private String password;
    @NotBlank(message = "Pole nie może być puste!")
    @Email(message = "Nieprawidłowy format email!")
    private String email;
    @NotNull(message = "Pole nie może być puste!")
    private Gender gender;

    public void setGender(String genderCode) {
        this.gender = Gender.getByCode(genderCode);
    }
}
