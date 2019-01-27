package Model;

import java.util.ArrayList;
import java.util.List;    

public class PlatService {

	private List<Plats> listPlat;

	public PlatService(List<Plats> listPlat) {
		this.listPlat = listPlat;
	}

	public PlatService(){
        this.listPlat = new ArrayList<Plats>();
    }
	public List<Plats> getListPlat() {
		return listPlat;
	}
	public Plats getPlatById(int id) {
		return this.listPlat.get(id);
	}
	public void setListPlat(List<Plats> listPlat) {
		this.listPlat = listPlat;
	}
	
	public void addPlat(Plats p) {
		this.listPlat.add(p);
	}
	public void removePlat(Plats p) {
		this.listPlat.remove(p);
	}
	public void removePlatById(int id) {
		this.listPlat.remove(id);
	}
	
}
