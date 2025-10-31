package JavaProjet.TpEntreprise;

public class Main {
    public static void main(String[]args){
        Entreprise Orange = new Entreprise("Orange");
        Entreprise GogoDev = new Entreprise("GoGoDev");
        Entreprise NextDigital = new Entreprise("NextDigital");

        Employes Natacha = new Employes("natacha Grieeman", 25);
        Employes Jeanluc = new Employes("Jean-luc Dupont", 37);
        Employes Stephane = new Employes("Stephane Brechet", 29);
        Employes Sasha = new Employes("Sasha Lemoine", 24);

        Adresse Nantes = new Adresse("nantes", "44000");

        Orange.addEmployes(Natacha);
        Orange.addAdresse(Nantes);
        Orange.displayEntreprise();

        GogoDev.displayEntreprise();

        NextDigital.displayEntreprise();
    }

}
