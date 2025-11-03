package Tpgestionattribut;

public class Hero extends Character {

    public String teamName;

    public Hero(String _name, String _teamName){
        super(_name);
        this.teamName = _teamName;
    }

    @Override
    public void showInfo() {
        System.out.println("Type : Héros");
        System.out.println("Nom du personnage : " + name);
        System.out.println("Équipe : " + teamName);
        System.out.println("Attributs : ");
        for(Attribute attr : attributes){
            System.out.println("- " + attr.name +  " : " + attr.value);
        }
    }
}
