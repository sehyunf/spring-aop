package com.app.aspect.aspect.sepect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
@Slf4j
public class ZeroDivision {

    @Around("@annotation(com.app.aspect.aspect.annotation.ZeroDivision)")
    public Double Around(ProceedingJoinPoint proceedingJoinPoint) {
        Double result = 0.0;

        try {
            result = (Double)proceedingJoinPoint.proceed();
        } catch (NumberFormatException e) {
            result = 0.0;
            log.info("잘못된 매개변수 값");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            log.info("결과");
        }

        return result;
    }
}
