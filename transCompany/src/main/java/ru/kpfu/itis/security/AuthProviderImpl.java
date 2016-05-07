package ru.kpfu.itis.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ru.kpfu.itis.models.UserRoleEntity;
import ru.kpfu.itis.models.UsersEntity;
import ru.kpfu.itis.models.enums.UserRole;
import ru.kpfu.itis.rep.UserRep;

import java.util.ArrayList;
import java.util.List;

public class AuthProviderImpl implements AuthenticationProvider {

    

    @Autowired
    UserRep userRepository;

    static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public static BCryptPasswordEncoder getEncoder() {
        return encoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email = authentication.getName();

        UsersEntity user = userRepository.findOneByLogin(email);

        if (user == null) {
            throw new UsernameNotFoundException("user not found");
        }

        String password = authentication.getCredentials().toString();

        if (!encoder.matches(password, user.getPassword())) {
            System.out.println("password");
            throw new BadCredentialsException("invalid password");
        }

        return authenticate(user);

    }

    public Authentication authenticate(UsersEntity user) {
        List<GrantedAuthority> authorities = new ArrayList<>();

        authorities.add(new SimpleGrantedAuthority(user.getRole().getUser_role().toString()));
        return new UsernamePasswordAuthenticationToken(user, null, authorities);
    }



    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }
}