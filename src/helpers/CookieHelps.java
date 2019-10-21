package helpers;

import filters.ProfileFilter;
import models.User;
import services.LoginService;
import services.TokenService;

import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookieHelps {
    private static TokenService service = new TokenService();
    private static LoginService loginService = new LoginService();

    public static User addCookie(ServletRequest request) {
        Cookie[] cookies = ((HttpServletRequest) request).getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("curr_user")) {
                    Integer id = Integer.valueOf(service.findToken(cookie.getValue()));
                    return loginService.findbyID(id);
                }
            }
        }
        return null;
    }
}
