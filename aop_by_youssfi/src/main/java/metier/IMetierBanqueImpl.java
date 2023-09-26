package metier;

import java.util.HashMap;
import java.util.Map;

public class IMetierBanqueImpl implements IMetierBanque {
    //on utilise hashmap pour stocker les comptes bancaires de la banque le hashmap est une map qui contient les comptes bancaires de la banque avec comme clé le code du compte et comme valeur le compte bancaire
    private Map<Long,Compte> compteMap=new HashMap<>();//Map qui contient les comptes bancaires de la banque avec comme clé le code du compte et comme valeur le compte bancaire
    @Override
    public void addCompte(Compte cp) {
compteMap.put(cp.getCode(),cp);//Ajout du compte cp dans la map compteMap avec comme clé le code du compte et comme valeur le compte bancaire
    }

    @Override
    public void verser(long code, double montant) {
Compte compte = compteMap.get(code);//Récupération du compte bancaire à partir de son code dans la map compteMap et stockage dans la variable compte
compte.setSolde(compte.getSolde()+montant);//Ajout du montant versé au solde du compte
    }

    @Override
    public void retirer(long code, double montant) {
        Compte compte = compteMap.get(code);//Récupération du compte bancaire à partir de son code dans la map compteMap et stockage dans la variable compte
        compte.setSolde(compte.getSolde()-montant);
    }

    @Override
    public Compte consulter(long code) {
        return compteMap.get(code);//Récupération du compte bancaire à partir de son code dans la map compteMap et retour du compte bancaire
    }
}
