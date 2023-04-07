package tw.jw.mapdice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import tw.jw.mapdice.dao.PlaceDao;
import tw.jw.mapdice.dao.UsersCollectDao;
import tw.jw.mapdice.dao.UsersDao;
import tw.jw.mapdice.exception.MapDiceException;
import tw.jw.mapdice.service.UsersCollectService;
import tw.jw.mapdice.service.UsersService;

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
    public void delete(Integer userId, String placeId) {
        dao.delete(userId, placeId);
    }

    @Override
    public List<String> findByUserId(Integer userId) {
        return dao.findByUserId(userId);
    }
}
