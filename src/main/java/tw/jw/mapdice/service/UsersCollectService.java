package tw.jw.mapdice.service;

import java.util.List;

public interface UsersCollectService {
    void create(Integer userId, String placeId);
    void delete(Integer userId, String placeId);
    List<String> findByUserId(Integer userId);
}
