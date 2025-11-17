package TPLudothèque.src.fr.eni.poo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Emprunt {
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private Membre emprunteur;
    private Jeu jeu;


    // Constructeur

    public Emprunt() {
		super();
	}

	public Emprunt(LocalDate dateDebut, LocalDate dateFin, Jeu jeu, Membre emprunteur) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
        this.emprunteur = emprunteur;
        this.jeu = jeu;
	}




    public LocalDate getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}

	public LocalDate getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

    public Jeu getJeu() {
        return jeu;
    }

    public void setJeu(Jeu jeu) {
        this.jeu = jeu;
    }

    public Membre getMembre() {
        return emprunteur;
    }

    public void setMembre(Membre emprunteur) {
        this.emprunteur = emprunteur;
    }
}