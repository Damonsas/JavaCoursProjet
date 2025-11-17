package Medecin.eni.quelmedecin.bo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.function.IntFunction;

/**
 * Classe modélisant un patient
 * 
 * @author ENI
 * @version 2.0
 */
public class Patient extends ArrayList<Patient> {
	
	//ATTRIBUTS D'INSTANCE
	private String nom;
	private String prenom;
	private String numeroDeTelephone;
	private char sexe;
	private long numSecu;
	private LocalDate dateNaissance;
	private String commentaires;
	//association unidirectionnelle
	//navigation vers Adresse 0..1
	private Adresse adresse;

	//CONSTRUCTEURS
	/**
	 * Constructeur : crée une instance de type Patient
	 * 
	 * @param nom - nom du patient
	 * @param prenom - prénom du patient
	 * @param numeroDeTelephone - numéro de téléphone du patient
	 * @param sexe - sexe du patient : 'F' pour Féminin ou 'M' pour Masculin
	 * @param numSecu - numéro de sécurité sociale du patient
	 * @param dateNaissance - date de naissance du patient
	 * @param commentaires - commentaires associé à ce patient (allergie, antécédents médicaux…)
	 * @param adresse - adresse postale du patient
	 */
	public Patient(String nom, String prenom, String numeroDeTelephone, char sexe, long numSecu,
			LocalDate dateNaissance, String commentaires, Adresse adresse) {
		this.setNom(nom.toUpperCase());
		this.setPrenom(prenom);
		this.setNumeroDeTelephone(numeroDeTelephone);
		this.setSexe(sexe);
		this.setNumSecu(numSecu);
		this.setDateNaissance(dateNaissance);
		this.setCommentaires(commentaires);
		this.setAdresse(adresse);
	}

	//AUTRES METHODES
	/**
	 * Affiche sur la console sous la forme :
	 * NOM Prénom
	 * Téléphone : XXXXXXXXXX
	 * Sexe : Féminin ou Masculin
	 * Numéro de Sécurité sociale XXXXXXXXXXXXXXX
	 * Date de naissance : XX mois XXXX
	 * Commentaires : XXXXXXXXXXXXXXX ou [aucun commentaire]
	 * Adresse : Complément
	 * XXbis rue XXXXXXXXX
	 * 00000 XXXXXXXXXXXXX
	 */
	public void afficher() {
		System.out.printf(
				"%s %s%nTéléphone : %s%nSexe : %s%nNuméro de Sécurité sociale : %d%nDate de naissance : %s%nCommentaires : %s%nAdresse :%n",
				this.getNom(), this.getPrenom(), this.getNumeroDeTelephone(), this.getSexe() == 'F' ? "Féminin" : "Masculin",
				this.getNumSecu(), this.getDateNaissance().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)),
				this.commentaires != null ? this.getCommentaires() : "[aucun commentaire]");
				if (this.adresse != null) {
					this.getAdresse().afficher();
				}
	}
	
	//ACCESSEURS ET MUTATEURS
	/**
	 * Getter pour nom
	 * @return le nom du patient
	 * @see Patient#setNom(String)
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Setter pour nom
	 * @param nom - le nom du patient
	 * @see Patient#getNom()
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Getter pour prenom
	 * @return le prenom du patient
	 * @see Patient#setPrenom(String)
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * Setter pour prenom
	 * @param prenom -  le prenom du patient
	 * @see Patient#getPrenom()
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * Getter pour numeroDeTelephone
	 * @return le numero de telephone du patient
	 * @see Patient#setNumeroDeTelephone(String)
	 */
	public String getNumeroDeTelephone() {
		return numeroDeTelephone;
	}

	/**
	 * Setter pour numeroDeTelephone
	 * @param numeroDeTelephone - le numero de telephone du patient
	 * @see Patient#getNumeroDeTelephone()
	 */
	public void setNumeroDeTelephone(String numeroDeTelephone) {
		this.numeroDeTelephone = numeroDeTelephone;
	}

	/**
	 * Getter pour sexe
	 * @return le sexe du patient : 'F' pour Féminin ou 'M' pour Masculin
	 * @see Patient#setSexe(char)
	 */
	public char getSexe() {
		return sexe;
	}

	/**
	 * Setter pour sexe
	 * @param sexe - le sexe du patient : 'F' pour Féminin ou 'M' pour Masculin
	 * @see Patient#getSexe()
	 */
	public void setSexe(char sexe) {
		this.sexe = sexe;
	}

	/**
	 * Getter pour numSecu
	 * @return the numero de secu du patient
	 * @see Patient#setNumSecu(long)
	 */
	public long getNumSecu() {
		return numSecu;
	}

	/**
	 * Setter pour numSecu
	 * @param numSecu - le numero de secu du patient
	 * @see Patient#getNumSecu()
	 */
	public void setNumSecu(long numSecu) {
		this.numSecu = numSecu;
	}

	/**
	 * Getter pour dateNaissance
	 * @return la date de naissance du patient
	 * @see Patient#setDateNaissance(LocalDate)
	 */
	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	/**
	 * Setter pour dateNaissance
	 * @param dateNaissance t- la date de naissance du patient
	 * @see Patient#getNumSecu()
	 */
	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	/**
	 * Getter pour commentaires
	 * @return les commentaires sur le patient
	 * @see Patient#setCommentaires(String)
	 */
	public String getCommentaires() {
		return commentaires;
	}

	/**
	 * Setter pour commentaires
	 * @param commentaires - les commentaires sur le patient
	 * @see Patient#getCommentaires()
	 */
	public void setCommentaires(String commentaires) {
		this.commentaires = commentaires;
	}
	
	/**
	 * Getter pour adresse
	 * @return l'adresse du medecin
	 * @see MedecinGeneraliste#setAdresse(Adresse)
	 */
	public Adresse getAdresse() {
		return adresse;
	}

	/**
	 * Setter pour adresse
	 * @param adresse - l'adresse du medecin
	 * @see MedecinGeneraliste#getAdresse()
	 */
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

    @Override
    public <T> T[] toArray(IntFunction<T[]> generator) {
        return super.toArray(generator);
    }
}
