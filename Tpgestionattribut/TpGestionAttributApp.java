package Tpgestionattribut;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class TpGestionAttributApp {

    public static void main(String[] args) {

        Hero hero = new Hero("Aria", "Légion du Nord");


        // MAINTENANT: Grace à mes propres fonctions:
        hero.addAttribute("Métier", "Archère");
        hero.addAttribute("Niveau", "5");
        hero.addAttribute("Energie", "120");

        //hero.showInfo();

        //  MONSTRE
        Monster monster = new Monster("Goblin", "Gobelin des cavernes");

        monster.addAttribute("Taille", "Petite");
        monster.addAttribute("Dangerosité", "2");
        monster.addAttribute("Habitat", "Grotte");

        //monster.showInfo();

        // PS : Un exemple de polymorphisme
        // Polymorphisme = Plus de souplesse dans le code
        // Mettre le monstre et le héro dans une liste
        ArrayList<Character> characters = new ArrayList<Character>();

        characters.add(hero);
        characters.add(monster);

        // Afficher tout les personnages
        // -- Parcourir tout les personnages (hero et monstre inclus)
        for (Character character : characters){
            // Appeler show info
            character.showInfo();
        }
    }
}
