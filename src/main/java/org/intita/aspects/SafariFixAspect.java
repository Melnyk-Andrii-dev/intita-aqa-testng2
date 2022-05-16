package org.intita.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.intita.pages.AbstractPage;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

@Aspect
public class SafariFixAspect {

    //    @Pointcut("execute(public * org.intita.pages..*.*(..))")
//    public void anyMethod(){
//    }
    @Pointcut("@annotation(org.intita.annotations.SafariUnstable)")
    public void waitForSafari() {
    }

    @After("waitForSafari()")
    public void test(JoinPoint joinPoint) {
        System.out.println("!!!!!!HELLO ASPECT!!!!!!");
        Object originalObject = null;
        Optional<Method> originalMethod = Optional.empty();
        try {
//            originalMethod = joinPoint.getThis().getClass()
//                    .getSuperclass()
//                    .getSuperclass()
//                    .getDeclaredMethod("waitForSafariOriginal",  null);
            System.out.println("METHODS!!!!");
            originalObject = joinPoint.getThis().getClass().newInstance();
            originalMethod = Arrays.stream(joinPoint.getThis().getClass()
                    .getSuperclass()
                    .getSuperclass()
                    .getMethods())
                    .filter(method -> method.getName().equalsIgnoreCase("waitForSafariOriginal"))
                    .findFirst();
            System.out.println("METHODS!!!!");
//            System.out.println(Arrays.toString(methods));
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
