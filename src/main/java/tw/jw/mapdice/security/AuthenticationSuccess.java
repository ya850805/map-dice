package tw.jw.mapdice.security;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import tw.jw.mapdice.model.Response;
import tw.jw.mapdice.utils.JwtUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthenticationSuccess implements AuthenticationSuccessHandler {
    @Autowired
    private Gson gson;

    @Autowired
    private JwtUtils jwtUtils;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        Response<String> res = Response.ok("login success!");
        response.setContentType("application/json;charset=utf-8");
        response.setHeader(jwtUtils.getHeader(), jwtUtils.generateToken(authentication.getName()));
        response.getWriter().write(gson.toJson(res));
    }
}
