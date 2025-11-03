package TpRPGAttribut;


import java.util.ArrayList;

public class Equipe {
    ArrayList<Personnage> personnages = new ArrayList<>();

    public void addPersonnage(Personnage personnage){
        personnages.add(personnage);
    }

    public Personnage getNextAlive(){
        for (Personnage p : personnages){
            if (!p.isDead()) return p;
        }
        return null;
    }
    public boolean hasAlive(){
        return getNextAlive() != null;
    }
}

