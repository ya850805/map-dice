package tw.jw.mapdice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tw.jw.mapdice.dao.PlaceDao;
import tw.jw.mapdice.dao.UsersCollectDao;
import tw.jw.mapdice.dao.UsersDao;
import tw.jw.mapdice.exception.MapDiceException;
import tw.jw.mapdice.service.UsersCollectService;

import java.util.List;
import java.util.Objects;

@Service
public class UsersCollectServiceImpl implements UsersCollectService {

    @Autowired
    private UsersCollectDao dao;

    @Autowired
    private UsersDao usersDao;

    @Autowired
    private PlaceDao placeDao;

    @Override
    @Transactional
    public void create(Integer userId, String placeId) {
        if(Objects.isNull(usersDao.getById(userId))) {
            throw new MapDiceException(HttpStatus.INTERNAL_SERVER_ERROR.value(), "user is not exist");
        }

        if(Objects.isNull(placeDao.getById(placeId))) {
            throw new MapDiceException(HttpStatus.INTERNAL_SERVER_ERROR.value(), "place is not exist");
        }

        dao.create(userId, placeId);
    }

    @Override
    @Transactional
    public void delete(Integer userId, String placeId) {
        if(Objects.isNull(dao.get(userId, placeId))) {
            throw new MapDiceException(HttpStatus.INTERNAL_SERVER_ERROR.value(), "users collect is not exist");
        }
        dao.delete(userId, placeId);
    }

    @Override
    public List<String> findByUserId(Integer userId) {
        return dao.findByUserId(userId);
    }
}
