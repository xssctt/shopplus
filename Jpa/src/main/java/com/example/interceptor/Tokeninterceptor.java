package com.example.interceptor;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.common.ThreadContxt;
import com.example.entity.Member;
import com.example.mapper.MemberMapper;
import com.example.service.impl.MemberServiceImpl;
import com.example.until.JwtUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//自定义拦截器
@Component
public class Tokeninterceptor implements HandlerInterceptor {


    @Resource
    MemberMapper memberMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //拦截器处理
        String token=request.getParameter("token");

        System.out.println(token);

        //token  userid
        if(token == null){
            throw new RuntimeException("token null");
        }


        Member member= JwtUtil.resolveJwt(token);

        ThreadContxt.setCruuser(member);
        System.out.println(member.toString());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
