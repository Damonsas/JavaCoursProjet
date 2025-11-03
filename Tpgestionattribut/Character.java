package Tpgestionattribut;

import java.util.ArrayList;

public class Character {

    public String name;
    public ArrayList<Attribute> attributes;

    public Character(String _name){
        this.name = _name;
        attributes = new ArrayList<Attribute>();
    }

    public void addAttribute(Attribute a){
        attributes.add(a);
    }

    public void addAttribute(String _name, String _value){
        Attribute a1 = new Attribute(_name, _value);
        // SOLUTION 1
        // J'appel une autre méthode
        // Uniquement parceque dans mon cas je remarque que
        // attributes.add(a); je l'avais deux fois alors qu'il est déjà
        // dans ma fonction à MOI  addAttribute(Attribute a)
        addAttribute(a1);
        // SOLUTION 2
        // OU JE FAIS CA (mais redondant car ce code est deja ecrit dans  addAttribute(Attribute a):
        // attributes.add(a1);
    }

    public void showInfo(){
        System.out.println("Nom du personnage : " + name);
        System.out.println("Attributs : ");
        for(Attribute attr : attributes){
            System.out.println("- " + attr.name +  " : " + attr.value);
        }
    }
}
