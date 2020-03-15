package pl.sarchael.zenerius.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sarchael.zenerius.users.entities.User;

import java.security.Principal;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersRepository usersRepository;

    @GetMapping("/my")
    public ResponseEntity<User> getLoggedUser(Principal principal) {
        User myUser = usersRepository.findByLogin(principal.getName());
        return myUser != null ? ResponseEntity.ok(myUser) : ResponseEntity.notFound().build();
    }
}
