package com.jackeyj.sms.interceptor;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jackeyj.sms.common.utils.JWTUtils;
import com.jackeyj.sms.common.utils.Result;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author jiyaofei
 */
public class JwtInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Result result = Result.fail();

        String token = request.getHeader("token");
        try {
            JWTUtils.verify(token);
            return true;
        } catch (SignatureVerificationException e) {
            result.put("msg", "无效签名");
            e.printStackTrace();
        } catch (TokenExpiredException e){
            result.put("msg", "token过期");
            e.printStackTrace();
        } catch (AlgorithmMismatchException e){
            result.put("msg", "token算法不一致");
            e.printStackTrace();
        } catch (Exception e){
            result.put("msg", "token无效");
            e.printStackTrace();
        }

        String json = new ObjectMapper().writeValueAsString(result);
        response.setContentType("application/json; charset=UTF-8");
        response.getWriter().write(json);
        response.sendRedirect("/");
        return false;
    }
}
