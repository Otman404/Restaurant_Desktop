package Model.serveur;

import java.util.ArrayList;
import java.util.List;

import Model.plats.Plats;    


public class ServeurService {

	private List<Serveur> listServeurs;

	
	
	public ServeurService(List<Serveur> listServeurs) {
		this.listServeurs = listServeurs;
	}

	public List<Serveur> getListServeurs() {
		return listServeurs;
	}

	public void setListServeurs(List<Serveur> listServeurs) {
		this.listServeurs = listServeurs;
	}
	
	public void addServeur(Serveur serveur) {
		this.listServeurs.add(serveur);
	}
	public Serveur getServeurById(int idServ) {
		return this.listServeurs.get(idServ);
	}
	public void removeServeur(Serveur serveur) {
		this.listServeurs.remove(serveur);
	}
	public void removeServeurById(int idServ) {
		this.listServeurs.remove(idServ);
	}
	
}
