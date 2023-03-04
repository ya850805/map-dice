package tw.jw.mapdice.service;

import tw.jw.mapdice.domain.Users;

public interface UsersService {
    Integer create(String email, String name, String password);
    Users getByName(String name);
}
