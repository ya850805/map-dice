package tw.jw.mapdice.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import tw.jw.mapdice.domain.Place;

@Mapper
@Repository
public interface PlaceDao {
    void insert(Place place);
    boolean exists(String id);
}