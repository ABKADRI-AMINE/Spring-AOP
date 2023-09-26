package metier;

public class Compte {
    private long code;
    private double solde;

    public Compte(long code, double solde) {
        this.code = code;
        this.solde = solde;
    }

    public Compte() {
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    @Override
    public String toString() {
        return "Compte{" +
                "code=" + code +
                ", solde=" + solde +
                '}';
    }
}
