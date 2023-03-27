package tw.jw.mapdice.service;

import tw.jw.mapdice.domain.Users;

public interface UsersService {
    Integer create(String email, String name, String password);
    Users getByEmail(String email);
    Users getByName(String name);
    void updatePassword(String uuid, String password);
}
