package Model.serveur;

import java.util.ArrayList;

import Model.categories.Categorie;

public interface ServeurDao {

		public void ajouterServeur(Serveur serveur);
	    public Serveur getServeurByid(int idServ);
	    public ArrayList<Serveur> getAllServeurs();
	    public void updateServeur(Serveur serveur);
	    public void deleteServeur(int idServ);
	
}
