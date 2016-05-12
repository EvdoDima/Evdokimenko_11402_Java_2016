package ru.kpfu.itis.service.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.models.UsersEntity;
import ru.kpfu.itis.rep.UserRep;
import ru.kpfu.itis.service.UserService;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by evdodima on 12/05/16.
 * 11-402
 */
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;


    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        UsersEntity userAccount = userService.getUserByLogin(username);

        if(userAccount == null) {
            throw new UsernameNotFoundException("user not found");
        }
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(userAccount.getRole().getUser_role().name()));

        return new User(username,userAccount.getPassword(),authorities);
    }

}