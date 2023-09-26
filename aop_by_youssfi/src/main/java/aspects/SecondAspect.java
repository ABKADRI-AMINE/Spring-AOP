package aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class SecondAspect {
    @Pointcut("execution(* test.*.mainn(..))")//Pointcut expression qui permet de définir un point de jointure sur la méthode main  du package test
    public void pc1(){}
//    @Before("pc1()")//Advice qui s'exécute avant le point de jointure pc1
//    public void beforeMain(){
//        System.out.println("*****************");
//        System.out.println("Before main from Aspect with class syntax");
//        System.out.println("*****************");
//    }
//    @After("pc1()")//Advice qui s'exécute après le point de jointure pc1
//    public void afterMain(){
//        System.out.println("*****************");
//        System.out.println("After main from Aspect with class syntax");
//        System.out.println("*****************");
//    }
    @Around("pc1()")//Advice qui s'exécute autour du point de jointure pc1
    public void aroundMain(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        System.out.println("*****************");
        System.out.println("Before main from Aspect with class syntax");
        System.out.println("*****************");
        //execution de la méthode main
        proceedingJoinPoint.proceed();
        System.out.println("*****************");
        System.out.println("After main from Aspect with class syntax");
        System.out.println("*****************");
    }
}
