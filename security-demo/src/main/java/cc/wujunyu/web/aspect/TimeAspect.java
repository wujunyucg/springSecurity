package cc.wujunyu.web.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 切片 记录服务时间
 */
@Aspect
@Component
public class TimeAspect {

    @Around("execution(* cc.wujunyu.web.controller.UserController.*(..))")
    public Object handlerControllerMethod(ProceedingJoinPoint joinPoint) throws Throwable {
//        System.out.println("time aspect start");
        long start = new Date().getTime();
        //方法的参数
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
//            System.out.println("arg is " + arg);
        }
        Object object = joinPoint.proceed();
//        System.out.println("time aspect: " + (new Date().getTime() - start));
//        System.out.println("time aspect finish");
        return object;
    }
}
