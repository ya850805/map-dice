package tw.jw.mapdice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tw.jw.mapdice.dao.UsersCollectDao;
import tw.jw.mapdice.service.UserCollectService;

@Service
public class UserCollectServiceImpl implements UserCollectService {

    @Autowired
    private UsersCollectDao dao;

    @Override
    public void create(Integer userId, String placeId) {
        dao.create(userId, placeId);
    }
}
