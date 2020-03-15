package pl.sarchael.zenerius.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.sarchael.zenerius.users.entities.User;
import pl.sarchael.zenerius.users.UsersRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Qualifier("userDetailService")
public class ZeneriusUserDetailsService implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = usersRepository.findByLogin(s);

        if (user == null)
            throw new UsernameNotFoundException("User not found");

        List<SimpleGrantedAuthority> roles = new ArrayList<>();
        user.getRoles().stream().forEach(x -> roles.add(new SimpleGrantedAuthority(x.getName())));

        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), roles);
    }
}
