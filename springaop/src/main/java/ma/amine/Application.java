package ma.amine;

import ma.amine.service.Imetier;
import ma.amine.service.SecurityContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(value = {"ma.amine"})//pour scanner les classes annotées par @Service
public class Application {
    public static void main(String[] args) {
        try{
            SecurityContext.authenticate("root","1234",new String[]{"ADMIN"});//pour simuler l'authentification de l'utilisateur
            ApplicationContext applicationContext=new AnnotationConfigApplicationContext(Application.class);//pour charger le contexte Spring
            Imetier metier=applicationContext.getBean(Imetier.class);//pour récupérer l'instance de la classe MetierImpl
            System.out.println("******************************");
            System.out.println(metier.getClass().getName());
            System.out.println("******************************");
            metier.process();//pour invoquer la méthode process de la classe MetierImpl
            System.out.println("RESULT: "+metier.compute());//pour invoquer la méthode compute de la classe MetierImpl
        }
catch (Exception e){
    System.out.println(e.getMessage());
}
    }
}
