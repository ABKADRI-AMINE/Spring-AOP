package aspects;

import metier.Compte;
import metier.IMetierBanqueImpl;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PatchRetraitAspect {
    @Pointcut("execution(* metier.IMetierBanqueImpl.retirer(..))")
    public void pc1(){}
    @Around("pc1() && args(code,montant)")//recuperer les arguments de la méthode retirer
    public Object autourRetirer(long code,double montant,ProceedingJoinPoint proceedingJoinPoint, JoinPoint joinPoint) throws Throwable {
        IMetierBanqueImpl metierBanque=(IMetierBanqueImpl) proceedingJoinPoint.getTarget();
        Compte compte=metierBanque.consulter(code);
        if(compte.getSolde()<montant) throw new RuntimeException("Solde insuffisant");
         return proceedingJoinPoint.proceed();


    }
}
