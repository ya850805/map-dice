package tw.jw.mapdice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tw.jw.mapdice.dao.UsersCollectDao;
import tw.jw.mapdice.service.UserCollectService;

import java.util.List;

@Service
public class UserCollectServiceImpl implements UserCollectService {

    @Autowired
    private UsersCollectDao dao;

    @Override
    public void create(Integer userId, String placeId) {
        //TODO check user & place is exist
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
