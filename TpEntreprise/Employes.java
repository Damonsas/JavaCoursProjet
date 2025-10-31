package JavaProjet.TpEntreprise;

public class Employes {
    public String firstname;
    public int age;

    public Employes(String firstname, int age){
        this.firstname = firstname;
        this.age = age;
    }

    public void displayInfo(){
        System.out.println(firstname + age);
    }
}
