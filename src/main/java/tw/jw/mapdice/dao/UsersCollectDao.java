package tw.jw.mapdice.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import tw.jw.mapdice.domain.UsersCollect;

import java.util.List;

@Mapper
@Repository
public interface UsersCollectDao {
    void create(Integer userId, String placeId);
    void delete(Integer userId, String placeId);
    List<String> findByUserId(Integer userId);
}