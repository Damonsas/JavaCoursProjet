package TpRPGAttribut;

public class Lalliance extends Personnage {
    public String metier;

    public Lalliance(String name, String metier, int hp, int power){
        super(name, hp, power);
        this.metier = metier;
    }
}
