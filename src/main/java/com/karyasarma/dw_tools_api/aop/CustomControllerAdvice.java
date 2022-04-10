package com.karyasarma.dw_tools_api.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author Daniel Joi Partogi Hutapea
 */
@Component
@Aspect
public class CustomControllerAdvice
{
    @Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
    public void controllerBean() {}

    @Before("controllerBean()")
    public void logMethodCall(JoinPoint jp) {
        String methodName = jp.getSignature().getName();
        Object[] args = jp.getArgs();

        if(args!=null)
        {
            for(Object obj : args)
            {
                if(obj instanceof ValidatorRedisKey)
                {
                    ValidatorRedisKey validatorRedisKey = (ValidatorRedisKey) obj;
                    System.out.printf("[%s] ValidatorRedisKey: %s\n", methodName, validatorRedisKey.getName());
                }
            }
        }
    }
}