package tw.jw.mapdice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tw.jw.mapdice.dao.UsersDao;
import tw.jw.mapdice.domain.Users;
import tw.jw.mapdice.exception.MapDiceException;
import tw.jw.mapdice.service.UsersService;

import java.util.ArrayList;
import java.util.Objects;


@Service
public class UsersServiceImpl implements UsersService, UserDetailsService {
    @Autowired
    private UsersDao usersDao;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    @Transactional
    public Integer create(String email, String name, String password) {
        if(!Objects.isNull(getByEmail(email))) {
            throw new MapDiceException(HttpStatus.INTERNAL_SERVER_ERROR.value(), "email already exists");
        }

        if(!Objects.isNull(getByName(name))) {
            throw new MapDiceException(HttpStatus.INTERNAL_SERVER_ERROR.value(), "username already exists");
        }

        return usersDao.create(email, name, encoder.encode(password));
    }

    @Override
    public Users getByEmail(String email) {
        return usersDao.getByEmail(email);
    }

    @Override
    public Users getByName(String name) {
        return usersDao.getByName(name);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = usersDao.getByName(username);
        return new User(users.getName(), users.getPassword(), new ArrayList<>());
    }
}
