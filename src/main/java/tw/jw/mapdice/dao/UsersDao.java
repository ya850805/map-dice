package tw.jw.mapdice.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import tw.jw.mapdice.domain.Users;

@Mapper
@Repository
public interface UsersDao {
    Integer create(String email, String name, String password);
    Users getByEmail(String email);
    Users getByName(String name);
    void updatePassword(String email, String password);
}