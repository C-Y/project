package com.it.utils;

import com.it.domain.SysLog;
import com.it.service.ISysLogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.Date;

@Component//创建对象注入IOC容器
@Aspect//创建切面
public class LogAop {
    //注入request对象(需要配置监听器)
    @Autowired
    private HttpServletRequest request;
    //注入service
    @Autowired
    private ISysLogService sysLogService;

    //pjp连接点参数,作用,可以获取当前执行的方法信息(目标对象、方法名称、参数、返回值..)
   // @Around("execution(* com.it.controller.*.*(..))")//切入点表达式
   @Around("execution(* com.it.controller.*.*(..))")
    public Object arount(ProceedingJoinPoint pjp){

        try {
            //执行controller中的处理请求方法之前
            //获取参数
            Object[] args = pjp.getArgs();//获取方法参数
            //获取方法名称(包含类名称)
            //pjp.getTarget()//获取目标对象
            //pjp.getSignature().getName();//方法名称
            String methodName = pjp.getSignature().toLongString();
            //获取用户名称
            SecurityContext securityContext = SecurityContextHolder.getContext();
            Authentication authentication = securityContext.getAuthentication();
            User user = (User) authentication.getPrincipal();
            //通过request对象获取ip
            String ip = request.getRemoteAddr();
            //放行,调用controller中的处理请求方法
            Object methodReturnValue = pjp.proceed(args);

            //记录日志
            SysLog sysLog = new SysLog();
            sysLog.setIp(ip);
            sysLog.setMethod(methodName);
            sysLog.setUsername(user.getUsername());
            sysLog.setVisitTime( new Date());

            sysLogService.save(sysLog);

            //执行 controller中的处理请求方法之后
            return methodReturnValue;
        } catch (Throwable e) {
            e.printStackTrace();
            return null;
        }
    }
}
