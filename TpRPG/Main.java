package TpRPG;


public class Main {
    public static void main(String[] args) {

        Attaquant Torgal = new Attaquant("Orc", 24, 20);
        Attaquant Leonidas = new Attaquant("Elf", 40, 5);

        Jeu.play(Torgal, Leonidas);
    }
}
