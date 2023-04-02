package tw.jw.mapdice.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import tw.jw.mapdice.domain.UsersCollect;

@Mapper
@Repository
public interface UsersCollectDao {
    void create(Integer userId, String placeId);
}