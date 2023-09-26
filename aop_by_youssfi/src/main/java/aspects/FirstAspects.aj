package aspects;

public aspect FirstAspects {
    pointcut pc1():execution(* test.Application.mainn(..));//creation du pointcut pc1 qui va intercepter l'execution de la methode main de la classe Application du package test et qui accepte n'importe quel type de retour et n'importe quel type de parametres
//before():pc1(){//creation du before advice qui va s'executer avant l'execution de la methode main de la classe Application du package test et qui accepte n'importe quel type de retour et n'importe quel type de parametres
//System.out.println("################################");
//    System.out.println("before main from aspect with aspectj syntax");
//    System.out.println("################################");
//}
//after():pc1(){//creation du after advice qui va s'executer apres l'execution de la methode main de la classe Application du package test et qui accepte n'importe quel type de retour et n'importe quel type de parametres
//System.out.println("################################");
//    System.out.println("after main from aspect with aspectj syntax");
//    System.out.println("################################");
//}
void around():pc1(){
    System.out.println("################################");
    System.out.println("before main from aspect with aspectj syntax");
    System.out.println("################################");
    //execution de l'operation du pointcut
    proceed();//execution de la methode main de la classe Application du package test
    System.out.println("################################");
    System.out.println("after main from aspect with aspectj syntax");
    System.out.println("################################");
}
}
