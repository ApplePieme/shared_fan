package com.applepieme.filter;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录状态拦截器
 * 客户端在未拥有登录态时无法请求部分路径
 *
 * @author applepieme
 * @date 2021/6/23 0:48
 */
public class LoginFilter implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        if (token == null) {
            return false;
        }
        return token.equals(request.getSession().getAttribute("token"));
    }
}
