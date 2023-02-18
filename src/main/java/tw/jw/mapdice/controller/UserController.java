package tw.jw.mapdice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tw.jw.mapdice.exception.MapDiceException;
import tw.jw.mapdice.model.Response;
import tw.jw.mapdice.model.UsersCreateRequest;
import tw.jw.mapdice.service.UsersService;

@RequestMapping("/users")
@RestController
public class UserController {
    @Autowired
    private UsersService usersService;

    @PostMapping("/create")
    public Response<Integer> create(@RequestBody UsersCreateRequest users) {
        if(usersService.getByName(users.getName()) != null) {
            throw new MapDiceException(HttpStatus.INTERNAL_SERVER_ERROR.value(), "user already exists");
        }
        int result = usersService.create(users.getName(), users.getPassword());
        return Response.ok(result);
    }
}
