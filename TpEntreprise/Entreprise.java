package JavaProjet.TpEntreprise;

import java.util.ArrayList;

public class Entreprise {
    public String name;
    public ArrayList<Adresse> adresses = new ArrayList<>();;

    public Entreprise(String name){
        this.name = name;

    }

    ArrayList<Employes> employes = new ArrayList<>();

    public void addEmployes(Employes employe){
        employes.add(employe);
    }

    public void displayEntreprise(){
        System.out.println("les employés de l'entreprise :" +name + "et son adresse" + adresses);
            for (Employes employe : employes){
                employe.displayInfo();
            }
    }



    public void addAdresse(Adresse adresse){
        adresses.add(adresse);
    }
}
