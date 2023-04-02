package tw.jw.mapdice.service;

import java.util.List;

public interface UserCollectService {
    void create(Integer userId, String placeId);
    void delete(Integer userId, String placeId);
    List<String> findByUserId(Integer userId);
}
