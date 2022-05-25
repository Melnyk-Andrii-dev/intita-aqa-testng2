package org.intita.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Optional;

@Aspect
public class SafariFixAspect {

    @Pointcut("@annotation(org.intita.annotations.SafariUnstable)")
    public void waitForSafari() {
    }

    @After("waitForSafari()")
    public void test(JoinPoint joinPoint) {
        Object originalObject = null;
        Optional<Method> originalMethod = Optional.empty();
        try {
            originalObject = joinPoint.getThis().getClass().newInstance();
            originalMethod = Arrays.stream(joinPoint.getThis().getClass()
                            .getSuperclass()
                            .getSuperclass()
                            .getMethods())
                    .filter(method -> method.getName().equalsIgnoreCase("waitForSafariOriginal"))
                    .findFirst();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (originalMethod.isPresent()) {
                originalMethod.get().invoke(originalObject);
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
