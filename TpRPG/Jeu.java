package TpRPG;

public class Jeu {

    public static void play(Attaquant a1, Attaquant a2) {

        boolean hordeStart = Attaquant.attaque();
        Attaquant attacker = hordeStart ? a1 : a2;
        Attaquant defender = hordeStart ? a2 : a1;

        while (!a1.isDead() && !a2.isDead()) {

            if (attacker.attack()) {
                int dmg = (int)(Math.random() * attacker.power) + 1;
                defender.looseHP(dmg);
            }

            if (defender.isDead()) {
                break;
            }

            Attaquant temp = attacker;
            attacker = defender;
            defender = temp;
        }

        System.out.println("Gagnant : " + (a1.isDead() ? a2.name : a1.name));
    }
}

