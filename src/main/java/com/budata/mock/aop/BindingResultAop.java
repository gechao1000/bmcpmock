package com.budata.mock.aop;

import com.budata.mock.vo.R;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

/**
 * BindingResultAop class
 *
 * @author gexc
 * @date 2019/05/24
 */
@Aspect
@Component
public class BindingResultAop {

    @Pointcut("execution(* com.budata.mock.web.*.*(..))")
    public void aopMethod(){}


    @Around("aopMethod()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        BindingResult bindingResult = null;
        for (Object arg: joinPoint.getArgs()) {
            if (arg instanceof BindingResult) {
                bindingResult = (BindingResult)arg;
            }
        }
        if (bindingResult != null) {
            if (bindingResult.hasErrors()) {
                return R.fail(bindingResult.getFieldError().getDefaultMessage());
            }
        }
        return joinPoint.proceed();
    }
}
