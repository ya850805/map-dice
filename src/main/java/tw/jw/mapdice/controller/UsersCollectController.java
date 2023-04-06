package tw.jw.mapdice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tw.jw.mapdice.model.Response;
import tw.jw.mapdice.model.UserCollectCreateRequest;
import tw.jw.mapdice.service.UsersCollectService;
import tw.jw.mapdice.service.UsersService;

@RestController
@RequestMapping("/users-collect")
public class UsersCollectController {
    @Autowired
    private UsersCollectService service;

    @Autowired
    private UsersService usersService;

    @PostMapping("/create")
    public Response<Integer> create(@RequestBody UserCollectCreateRequest request) {
        String username =  (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Integer userId = usersService.getByName(username).getId();
        service.create(userId, request.getPlaceId());
        return Response.ok(1);
    }
}
