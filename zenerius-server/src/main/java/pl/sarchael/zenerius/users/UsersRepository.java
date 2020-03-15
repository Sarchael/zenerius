package pl.sarchael.zenerius.users;

import org.springframework.data.repository.CrudRepository;
import pl.sarchael.zenerius.users.entities.User;

public interface UsersRepository extends CrudRepository<User, Long> {
    public User findByLogin(String login);
}
