package aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Scanner;

@Aspect
public class SecurityAspect {
    @Pointcut("execution(* test.Application.start(..))")
    public void startAppPointcut(){}
    @Around("startAppPointcut()")
    public void autourStart(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        Scanner scanner=new Scanner(System.in);
        System.out.println("Veuillez saisir le Username: ");
        String username=scanner.next();
        System.out.println("Veuillez saisir le Password: ");
        String password=scanner.next();
        if(username.equals("admin") && password.equals("1234")) {
            proceedingJoinPoint.proceed();
        }else {
            System.out.println("Accès refusé");
        }


    }
}
