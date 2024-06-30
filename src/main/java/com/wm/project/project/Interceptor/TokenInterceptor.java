package com.wm.project.project.Interceptor;

import com.wm.project.project.util.JwtUtil;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zyf
 * @since 2022/3/23 15:20
 */
public class TokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setCharacterEncoding("utf-8");
        String token = request.getHeader("access_token");
        //验证token是否正确
        if(token!=null){
            boolean verify = JwtUtil.verify(token);
            if(verify){
                return true;
            }
        }
        return false;
    }
}
