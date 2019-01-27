package Model.categories;

import java.util.ArrayList;
import java.util.List;

import Model.plats.Plats;


public class CategorieService {

	private List<Categorie> listCateg;

	
	
	
	public CategorieService(List<Categorie> listCateg) {
		this.listCateg = listCateg;
	}

	public List<Categorie> getListCateg() {
		return listCateg;
	}

	public void setListCateg(List<Categorie> listCateg) {
		this.listCateg = listCateg;
	}
	public Categorie getCategByCode(String codeCateg) {
		for(Categorie c : listCateg)
			if(c.getCodeCateg() == codeCateg)
				return c;
		return null;
	}
	public void addCateg(Categorie categ) {
		this.listCateg.add(categ);
	}
	public void removeCateg(Categorie categ) {
		this.listCateg.remove(categ);
	}
	public void removeCategByCode(String codeCateg) {
		for(Categorie c : listCateg)
			if(c.getCodeCateg() == codeCateg)
				this.listCateg.remove(c);
	}
	
}
