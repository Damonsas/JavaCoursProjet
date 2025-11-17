package Medecin.eni.quelmedecin.bo;

/**
 * Classe modélisant un médecin généraliste
 *
 * @author ENI
 * @version 2.0
 */
public class MedecinGeneraliste extends Medecin{

	//ATTRIBUTS D'INSTANCE
    private Creneau[] creneaux;

    //ATTRIBUTS DE CLASSE
	private static int tarif = 25;

	//CONSTANTES DE CLASSE
	public static final int MAX_CRENEAUX = 15;

	//CONSTRUCTEURS
	/**
	 * Constructeur : crée une instance de type MedecinGeneraliste
	 *
	 * @param nom - nom du médecin
	 * @param prenom - prénom du médecin
	 * @param numeroDeTelephone - numéro de téléphone
	 * @param adresse - adresse postale du medecin
	 */
	public MedecinGeneraliste(String nom, String prenom, String numeroDeTelephone, Adresse adresse) {
		super(nom, prenom, numeroDeTelephone, adresse);
	}

	//AUTRES METHODES
	/**
	 * Affiche sur la console sous la forme :
	 * NOM Prénom
	 * Téléphone : XXXXXXXXXX
	 * Tarif : XX€
	 * Adresse : Complément
	 * XXbis rue XXXXXXXXX
	 * 00000 XXXXXXXXXXXXX
	 * Créneaux :
	 * 00:00 - 00:00 (XX minutes)
	 */
	public void afficher() {
		System.out.printf("%s %s%nTéléphone : %s%nTarif : %d€%nAdresse :%n", this.getNom(), this.getPrenom(),
				this.getNumeroDeTelephone(), MedecinGeneraliste.tarif);
		if (getAdresse() != null) {
			this.getAdresse().afficher();
		}
		System.out.println("Créneaux :");
		for (int i = 0; i < this.creneaux.length; i++)
			if (this.creneaux[i] != null)
				this.creneaux[i].afficher();
	}

	/**
	 * @param creneauAAjouter
	 */
	void ajouterCreneau(Creneau creneauAAjouter) {
		if (this != creneauAAjouter.getMedecin()) {
			System.err.println("Ce créneau ne peut être associé à ce médecin car il est déjà associé à un autre");
		} else {
			int pos = 0;
			while (pos < this.creneaux.length && this.creneaux[pos] != null)
				pos++;
			if (pos == this.creneaux.length)
				System.err.println("Trop de créneaux sont affectés à ce médecin");
			else
				this.creneaux[pos] = creneauAAjouter;
		}
	}

	//ACCESSEURS ET MUTATEURS



	/**
	 * Getter pour tarif.
	 * @return le tarif de la consultation
	 * @see MedecinGeneraliste#setTarif(int)
	 */
	public static int getTarif() {
		return MedecinGeneraliste.tarif;
	}

	/**
	 * Setter pour tarif.
	 * @param tarif - le tarif de la consultation
	 * @see MedecinGeneraliste#getTarif()
	 */
	public static void setTarif(int tarif) {
		MedecinGeneraliste.tarif = tarif;
	}}

	/**
	 * Getter pour adresse
	 * @return l'adresse du medecin
	 * @see MedecinGeneraliste#setAdresse(Adresse)
	 */

