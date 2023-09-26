package ma.amine.service;

import ma.amine.aspects.Log;
import ma.amine.aspects.SecuredByAspect;
import org.springframework.stereotype.Service;

@Service//@service est une annotation qui permet de déclarer une classe comme service Spring cad une classe qui contient la logique métier de l'application
public class MetierImpl implements Imetier {
    @Override
    @Log//pour activer l'aspect LogAspect avant l'exécution de la méthode process de la classe MetierImpl
    @SecuredByAspect(roles={"ADMIN"})//pour activer l'aspect SecuredByAspect avant l'exécution de la méthode process de la classe MetierImpl
    public void process() {
        System.out.println("Business Process.....");
    }

    @Override
    @SecuredByAspect(roles={"ADMIN"})//pour activer l'aspect SecuredByAspect avant l'exécution de la méthode process de la classe MetierImpl

    public double compute() {
        double data = 78;
        System.out.println("Business Computing and returning " );
        return data;
    }
}
