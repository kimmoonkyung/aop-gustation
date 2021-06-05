package com.example.aop.aop;

import com.example.aop.dto.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

@Aspect
@Component
public class DecodeAop {

    @Pointcut("execution(* com.example.aop.controller..*.*(..))")
    private void cut() {}

    @Pointcut("@annotation(com.example.aop.annotation.Decode)")
    private void enableDecode() {}

    // 디코딩해서 내보낼 거
    @Before("cut() && enableDecode()")
    public void before(JoinPoint joinPoint) throws UnsupportedEncodingException {
        Object[] args = joinPoint.getArgs();

        for (Object arg : args) {
            if (arg instanceof User) {
                User user = User.class.cast(arg);
                String email = user.getEmail();
                System.out.println("email : " + email);
                String base64Email = new String(Base64.getDecoder().decode(email), "UTF-8");
                System.out.println("email : " + base64Email);
                user.setEmail(base64Email);
            }
        }
    }

    // 인코딩해서 내보낼 것
    @AfterReturning(value = "cut() && enableDecode()", returning = "returnObj")
    public void afterReturn(JoinPoint joinPoint, Object returnObj){
        if (returnObj instanceof User) {
            User user = User.class.cast(returnObj);
            String email = user.getEmail();
            System.out.println("email : " + email);
            String encodeEmail = Base64.getEncoder().encodeToString(email.getBytes());
            System.out.println("email : " + encodeEmail);
            user.setEmail(encodeEmail);
        }

    }

}
