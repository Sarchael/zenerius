package pl.sarchael.zenerius.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import pl.sarchael.zenerius.users.entities.User;
import pl.sarchael.zenerius.users.model.SignUpForm;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Arrays;
import java.util.HashSet;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private RolesRepository rolesRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(5);

    @GetMapping("/my")
    public ResponseEntity<User> getLoggedUser(Principal principal) {
        User myUser = usersRepository.findByLogin(principal.getName());
        return myUser != null ? ResponseEntity.ok(myUser) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Void> signUp(@Valid @RequestBody SignUpForm signUpForm) {
        User existingUser = usersRepository.findByLogin(signUpForm.getLogin());
        if (existingUser != null)
            return ResponseEntity.status(HttpStatus.CONFLICT).build();

        User user = User.builder()
                .email(signUpForm.getEmail())
                .gender(signUpForm.getGender())
                .login(signUpForm.getLogin())
                .active(true)
                .emailConfirmed(false)
                .password(passwordEncoder.encode(signUpForm.getPassword()))
                .roles(new HashSet(Arrays.asList(rolesRepository.findByName("ROLE_USER"))))
                .build();

        usersRepository.save(user);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
