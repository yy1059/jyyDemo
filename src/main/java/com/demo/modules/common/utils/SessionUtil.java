package com.demo.modules.common.utils;

import com.demo.modules.common.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;


@Slf4j
public class SessionUtil {

    /**
     * 设置当前登录用户
     *
     * @param request 请求
     * @param user    user
     */
    public static void setCurrentUser(HttpServletRequest request, User user) {
        request.getSession().setAttribute(Const.CURRENT_USER, user);
    }

    /**
     * 设置当前登录用户
     */
    public static void removeSession(HttpServletRequest request, String key) {
        request.getSession().removeAttribute(key);
    }

    /**
     * 获取当前登录用户
     *
     * @return User
     */
    public static User getCurrentUser() {
        User user = (User) getSession().getAttribute(Const.CURRENT_USER);
        return user;
    }


    /**
     * 获取当前 session
     *
     * @return HttpSession
     */
    public static HttpSession getSession() {
        HttpSession session;
        session = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest().getSession();
        return session;
    }

}
