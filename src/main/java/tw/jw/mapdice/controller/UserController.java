package tw.jw.mapdice.controller;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tw.jw.mapdice.exception.MapDiceException;
import tw.jw.mapdice.model.Response;
import tw.jw.mapdice.model.UsersCreateRequest;
import tw.jw.mapdice.service.UsersService;
import tw.jw.mapdice.utils.JwtUtils;

@RequestMapping("/users")
@RestController
public class UserController {
    @Autowired
    private UsersService usersService;

    @Autowired
    private JwtUtils jwtUtils;

    @GetMapping("/{jwt}")
    public Response<String> getLoginUserName(@PathVariable("jwt") String jwt) {
        Claims claims = jwtUtils.getClaimByToken(jwt);
        if(jwtUtils.isTokenExpired(claims)) {
            throw new JwtException("token is expired...");
        } else {
            return Response.ok(claims.getSubject());
        }
    }

    @PostMapping("/create")
    public Response<Integer> create(@RequestBody UsersCreateRequest users) {
        if(usersService.getByName(users.getName()) != null) {
            throw new MapDiceException(HttpStatus.INTERNAL_SERVER_ERROR.value(), "user already exists");
        }
        int result = usersService.create(users.getName(), users.getPassword());
        return Response.ok(result);
    }
}
