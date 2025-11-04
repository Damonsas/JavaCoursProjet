package Medecin;

import java.time.LocalDate;

public class Client extends InfoPerso{
   char genre;
   long secu;
   LocalDate date;
   String commentaire;

   public Client(String nom, String prenom, String tel, char genre, long secu, LocalDate date, String commentaire){
       super(nom, prenom, tel);
       this.genre = genre;
       this.secu = secu;
       this.date = date;
       this.commentaire = commentaire;
   }

    public void afficher() {
    }

    public Object getPrenom() {
        return null;
    }
}
