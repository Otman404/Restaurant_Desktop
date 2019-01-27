package Model.categories;

public class Categorie {

	private String codeCateg;
	private String libelle;
	
	
	public Categorie(String codeCateg, String libelle) {
		this.codeCateg = codeCateg;
		this.libelle = libelle;
	}
	public String getCodeCateg() {
		return codeCateg;
	}
	public void setCodeCateg(String codeCateg) {
		this.codeCateg = codeCateg;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	
	
}
