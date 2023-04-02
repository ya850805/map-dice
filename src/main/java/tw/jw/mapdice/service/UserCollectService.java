package tw.jw.mapdice.service;

public interface UserCollectService {
    void create(Integer userId, String placeId);
    void delete(Integer userId, String placeId);
}
