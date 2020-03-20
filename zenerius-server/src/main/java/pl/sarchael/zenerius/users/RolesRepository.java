package pl.sarchael.zenerius.users;

import org.springframework.data.repository.CrudRepository;
import pl.sarchael.zenerius.users.entities.Role;

public interface RolesRepository extends CrudRepository<Role, Long> {
    public Role findByName(String name);
}
