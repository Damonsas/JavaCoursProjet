package TpRPGAttribut;

public class Gameplay {
    public static void play(Equipe e1, Equipe e2) {
        Personnage p1;
        Personnage p2;
        boolean hordeStart = Personnage.initiative();
        Personnage attaquant = hordeStart ? p1 : p2;
        Personnage defenseur = hordeStart ? p2 : p1;

        while (!p1.isDead() && !p2.isDead()) {

            if (attaquant.attaque()) {
                int dmg = (int) (Math.random() * attaquant.power) + 1;
                defenseur.looseHP(dmg);

                if (defenseur.isDead()) {
                    break;

                }
                Personnage temp = attaquant;
                attaquant = defenseur;
                defenseur = temp;
            }
        }
    }
}
