package ma.amine.aspects;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)//pour que l'annotation SecuredByAspect soit disponible au moment de l'exécution
@Target(ElementType.METHOD)//pour que l'annotation SecuredByAspect soit applicable sur les méthodes (et pas sur les classes
public @interface SecuredByAspect {//pour déclarer une annotation SecuredByAspect qui sera utilisée pour activer l'aspect SecuredByAspect avant l'exécution de la méthode process de la classe MetierImpl
    String[] roles();
}
