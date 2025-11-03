package TpRPGAttribut;

public class Main {
    public static void main(String[] args){

        LaHorde Torgal = new LaHorde("Torgal", "orc", 24, 20);
        LaHorde ChoGall = new LaHorde("Chogall", "ogres", 30, 20);
        Lalliance Anduin = new Lalliance("Anduin", "chevalier", 24, 18);
        Lalliance Alleria = new Lalliance("Alleria", "elf", 44, 10);

        Equipe Horde = new Equipe();
        Horde.addPersonnage(Torgal);
        Horde.addPersonnage(ChoGall);


        Equipe Alliance = new Equipe();
        Alliance.addPersonnage(Anduin);
        Alliance.addPersonnage(Alleria);

        Gameplay.play(Horde, Alliance);
    }
}
