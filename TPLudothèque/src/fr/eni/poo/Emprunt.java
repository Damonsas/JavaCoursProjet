package TPLudothèque.src.fr.eni.poo;

import java.time.LocalDate;

public class Emprunt {
    private LocalDate dateDebut;
    private LocalDate dateFin;
    
    // Constructeur

    public Emprunt() {
		super();
	}

	public Emprunt(LocalDate dateDebut, LocalDate dateFin) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
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
}