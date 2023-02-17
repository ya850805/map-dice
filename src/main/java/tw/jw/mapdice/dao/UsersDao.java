package tw.jw.mapdice.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import tw.jw.mapdice.domain.Users;

@Mapper
@Repository
public interface UsersDao {
    Integer create(String name, String password);
    Users getByName(String name);
}