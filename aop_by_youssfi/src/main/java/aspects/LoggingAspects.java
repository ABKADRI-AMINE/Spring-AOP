package aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

@Aspect
public class LoggingAspects {
    Logger logger = Logger.getLogger(LoggingAspects.class.getName());

    public LoggingAspects() throws IOException {
        logger.addHandler(new FileHandler("log.XML"));//création d'un fichier log.XML DE LOGGING ET JOURNALISATION DES MESSAGES
        logger.setUseParentHandlers(false);//désactivation de la console pour afficher les messages de log
    }

    long t1,t2;
    @Pointcut("execution(* metier.IMetierBanqueImpl.*(..))")
    public void pc1(){}
//    @Before("pc1()")
//    public void avant(JoinPoint joinPoint){
//        t1=System.currentTimeMillis();
//        logger.info("*****************");
//        logger.info("Avant execution de la méthode"+joinPoint.getSignature());
//    }
//    @After("pc1()")
//    public void apres(  JoinPoint JoinPoint){
//        logger.info("Après execution de la méthode"+JoinPoint.getSignature());
//        t2=System.currentTimeMillis();
//        logger.info("Durée d'execution de la méthode"+JoinPoint.getSignature()+" est "+(t2-t1)+" ms");
//        logger.info("*****************");
//    }
    @Around("pc1()")
    public Object autour(ProceedingJoinPoint proceedingJoinPoint,JoinPoint joinPoint) throws Throwable {
        t1=System.currentTimeMillis();
        logger.info("*****************");
        logger.info("Avant execution de la méthode"+proceedingJoinPoint.getSignature());
        Object result=proceedingJoinPoint.proceed();//faut retourner l'objet retourné par la méthode
        logger.info("Après execution de la méthode"+proceedingJoinPoint.getSignature());
        t2=System.currentTimeMillis();
        logger.info("Durée d'execution de la méthode"+proceedingJoinPoint.getSignature()+" est "+(t2-t1)+" ms");
        logger.info("*****************");
        return result;
    }
}
