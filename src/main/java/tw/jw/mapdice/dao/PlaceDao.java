package tw.jw.mapdice.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tw.jw.mapdice.domain.Place;

import java.util.List;

@Mapper
@Repository
public interface PlaceDao {
    void insert(Place place);
    boolean exists(String id);
    Place getById(String id);
    List<Place> getByIds(@Param("ids") List<String> ids);
}