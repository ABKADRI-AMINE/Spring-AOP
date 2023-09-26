package ma.amine.aspects;

import ma.amine.service.SecurityContext;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component//pour déclarer une classe comme bean Spring
@EnableAspectJAutoProxy//pour activer les aspects Spring AOP au démarrage de l'application Spring
@Aspect//pour déclarer une classe comme aspect Spring
public class AuthorizationAspect {
    @Around(value = "@annotation(securedByAspect)", argNames = "pjp,securedByAspect")//pour déclarer un advice qui sera exécuté avant et apres  l'exécution de la méthode process de la classe MetierImpl
        public Object secure (ProceedingJoinPoint pjp, SecuredByAspect securedByAspect) throws Throwable//ProceedingJoinPoint est un objet qui permet d'exécuter la méthode process de la classe MetierImpl et de récupérer le résultat de son exécution
    {
String[] roles = securedByAspect.roles();//pour récupérer les rôles autorisés à accéder à la méthode process de la classe MetierImpl
boolean authorized = false;//pour vérifier si l'utilisateur courant a le droit d'accéder à la méthode process de la classe MetierImpl
        for (String r : roles) {
            if (SecurityContext.hasRole(r)) {
                authorized = true;
                break;
            }
        }
       if (authorized == true) {

               Object result = pjp.proceed();
               return result;
            }

                throw new RuntimeException("Unauthorized Access=>403 to access the resource"+pjp.getSignature());

    }
}
