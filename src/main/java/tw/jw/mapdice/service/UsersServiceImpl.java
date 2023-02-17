package tw.jw.mapdice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tw.jw.mapdice.dao.UsersDao;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    UsersDao usersDao;

    @Override
    public Integer create(String name, String password) {
        return usersDao.create(name, password);
    }
}
