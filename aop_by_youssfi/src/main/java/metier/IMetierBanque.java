package metier;

public interface IMetierBanque {
     void addCompte(Compte cp);
     void verser(long code, double montant);
     void retirer(long code, double montant);
        Compte consulter(long code);
}
