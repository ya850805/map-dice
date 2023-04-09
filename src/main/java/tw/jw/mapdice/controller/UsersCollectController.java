package tw.jw.mapdice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tw.jw.mapdice.exception.MapDiceException;
import tw.jw.mapdice.model.Response;
import tw.jw.mapdice.model.UsersCollectCreateDeleteRequest;
import tw.jw.mapdice.service.UsersCollectService;
import tw.jw.mapdice.service.UsersService;

import javax.validation.Valid;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users-collect")
public class UsersCollectController {
    @Autowired
    private UsersCollectService service;

    @Autowired
    private UsersService usersService;

    @PostMapping("/create")
    public Response<Integer> create(@Valid @RequestBody UsersCollectCreateDeleteRequest request, BindingResult br) {
        if(br.hasErrors()) {
            String errorMessages = br.getAllErrors().stream().map(e -> e.getDefaultMessage()).collect(Collectors.joining(","));
            throw new MapDiceException(HttpStatus.INTERNAL_SERVER_ERROR.value(), errorMessages);
        }

        String username =  (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Integer userId = usersService.getByName(username).getId();
        service.create(userId, request.getPlaceId());
        return Response.ok(1);
    }

    @DeleteMapping("/delete")
    public Response<Integer> delete(@Valid @RequestBody UsersCollectCreateDeleteRequest request, BindingResult br) {
        if(br.hasErrors()) {
            String errorMessages = br.getAllErrors().stream().map(e -> e.getDefaultMessage()).collect(Collectors.joining(","));
            throw new MapDiceException(HttpStatus.INTERNAL_SERVER_ERROR.value(), errorMessages);
        }

        String username =  (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Integer userId = usersService.getByName(username).getId();
        service.delete(userId, request.getPlaceId());
        return Response.ok(1);
    }
}
