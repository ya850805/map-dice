package tw.jw.mapdice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import tw.jw.mapdice.dao.UsersDao;
import tw.jw.mapdice.domain.Users;
import tw.jw.mapdice.service.UsersService;

import java.util.ArrayList;


@Service
public class UsersServiceImpl implements UsersService, UserDetailsService {
    @Autowired
    private UsersDao usersDao;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    public Integer create(String name, String password) {
        return usersDao.create(name, encoder.encode(password));
    }

    @Override
    public Users getByName(String name) {
        return usersDao.getByName(name);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = usersDao.getByName(username);
        return new User(username, users.getPassword(), new ArrayList<>());
    }
}
