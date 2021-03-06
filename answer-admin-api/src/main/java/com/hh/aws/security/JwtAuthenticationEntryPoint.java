package com.hh.aws.security;

import com.alibaba.fastjson.JSON;
import com.hh.aws.bean.ResponseData;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

   @Override
   public void commence(HttpServletRequest request,
                        HttpServletResponse response,
                        AuthenticationException authException) throws IOException {
      // This is invoked when user tries to access a secured REST resource without supplying any credentials
      // We should just send a 401 Unauthorized response because there is no 'login page' to redirect to
      // Here you can place any message you want
      ResponseData responseData = new ResponseData();
      responseData.setCode("300");
      responseData.setMsg("请先登录!");
      response.setContentType("application/json; charset=utf-8");
      response.getWriter().write(JSON.toJSONString(responseData));
//      response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.getMessage());
   }
}
