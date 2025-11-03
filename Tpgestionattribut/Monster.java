package Tpgestionattribut;

public class Monster extends Character {

    public String species ;

    public Monster(String _name, String _species){
        super(_name);
        this.species  = _species;
    }

    @Override
    public void showInfo() {
        System.out.println("Type : Monster");
        System.out.println("Nom du personnage : " + name);
        System.out.println("Espèce : " + species);
        System.out.println("Attributs : ");
        for(Attribute attr : attributes){
            System.out.println("- " + attr.name +  " : " + attr.value);
        }
    }
}
