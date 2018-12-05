package lambda;

public class Etudiant {

	private String nom;
	private String prenom;
	private double moyenne;
	
	
	
	public Etudiant() {
		super();
	}
	public Etudiant(String nom, String prenom, double moyenne) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.moyenne = moyenne;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	@Override
	public String toString() {
		return "Etudiant [nom=" + nom + ", prenom=" + prenom + ", moyenne=" + moyenne + "]";
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public double getMoyenne() {
		return moyenne;
	}
	public void setMoyenne(float moyenne) {
		this.moyenne = moyenne;
	}

	public String	getMention() {
		return (getMoyenne() < 10 )? "recalé" : (getMoyenne()<12)? "passable": (getMoyenne()< 14)? "bien" : "très bien";
	}
	
}
