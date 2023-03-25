package tw.jw.mapdice.controller;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tw.jw.mapdice.exception.MapDiceException;
import tw.jw.mapdice.model.Response;
import tw.jw.mapdice.model.UsersCreateRequest;
import tw.jw.mapdice.service.MailService;
import tw.jw.mapdice.service.UsersService;
import tw.jw.mapdice.utils.JwtUtils;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.util.Objects;
import java.util.stream.Collectors;

@RequestMapping("/users")
@RestController
public class UserController {
    @Autowired
    private UsersService usersService;

    @Autowired
    private MailService mailService;

    @Autowired
    private JwtUtils jwtUtils;

    @GetMapping("/{jwt}")
    public Response<String> getLoginUserName(@PathVariable("jwt") String jwt) {
        if(StringUtils.isBlank(jwt)) {
            throw new MapDiceException(HttpStatus.INTERNAL_SERVER_ERROR.value(), "jwt is invalid");
        }

        Claims claims = jwtUtils.getClaimByToken(jwt);
        if(jwtUtils.isTokenExpired(claims)) {
            throw new JwtException("token is expired...");
        } else {
            return Response.ok(claims.getSubject());
        }
    }

    @PostMapping("/create")
    public Response<Integer> create(@RequestBody @Valid UsersCreateRequest users, BindingResult br) {
        if(br.hasErrors()) {
            String errorMessages = br.getAllErrors().stream().map(e -> e.getDefaultMessage()).collect(Collectors.joining(","));
            throw new MapDiceException(HttpStatus.INTERNAL_SERVER_ERROR.value(), errorMessages);
        }

        int result = usersService.create(users.getEmail(), users.getName(), users.getPassword());
        return Response.ok(result);
    }

    @PostMapping("/forgotPwd/{email}")
    public Response<Integer> forgotPwd(@PathVariable("email") String email) throws MessagingException {
        mailService.sendForgotPassword(email);
        return Response.ok(1);
    }
}
