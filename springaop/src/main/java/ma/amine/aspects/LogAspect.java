package ma.amine.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Aspect//pour déclarer une classe comme aspect Spring
@EnableAspectJAutoProxy//pour activer les aspects Spring AOP au démarrage de l'application Spring
public class LogAspect {
    Logger logger= Logger.getLogger(LogAspect.class.getName());
    //.. veut dire n'importe quel nombre de paramètres quel que soit leur profendeur
    @Around("@annotation(ma.amine.aspects.Log)")// advice qui sera exécuté avant et apres  l'exécution de la méthode process de la classe MetierImpl
    public Object log(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {//ProceedingJoinPoint est un objet qui permet d'exécuter la méthode process de la classe MetierImpl et de récupérer le résultat de son exécution
        long t1=System.currentTimeMillis();//pour récupérer le temps courant en millisecondes
        logger.info("From Logging Aspects: Before "+proceedingJoinPoint.getSignature());//pour afficher le nom de la méthode process de la classe MetierImpl
        Object result=proceedingJoinPoint.proceed();//pour exécuter la méthode process de la classe MetierImpl
        logger.info("From Logging Aspects: After "+proceedingJoinPoint.getSignature());
        long t2=System.currentTimeMillis();
        logger.info("Durée d'exécution  est "+(t2-t1)+" ms");
        return result;
    }
}
