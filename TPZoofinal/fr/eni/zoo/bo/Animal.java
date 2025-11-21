package TPZoofinal.fr.eni.zoo.bo;

public class Animal {
	private int id;
	private String nom;
	private Boolean sexe; //faux male ; vrai femelle
	private int age;
	private TypeAnimal type;
	
	public Animal() {
		super();
	}

	public Animal(String nom, Boolean sexe, int age, TypeAnimal type) {
		super();
		this.nom = nom;
		this.sexe = sexe;
		this.age = age;
		this.type = type;
	}

	public Animal(int id, String nom, Boolean sexe, int age, TypeAnimal type) {
		super();
		this.id = id;
		this.nom = nom;
		this.sexe = sexe;
		this.age = age;
		this.type = type;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Boolean getSexe() {
		return sexe;
	}

	public void setSexe(Boolean sexe) {
		this.sexe = sexe;
	}

	public TypeAnimal getType() {
		return type;
	}

	public void setType(TypeAnimal type) {
		this.type = type;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Animal [id=" + id + ", nom=" + nom + ", sexe=" + sexe + ", age=" + age + ", type=" + type + "]";
	}
}
