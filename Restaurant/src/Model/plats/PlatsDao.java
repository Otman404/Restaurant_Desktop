package Model.plats;

import java.util.ArrayList;

import View.EspaceAdmin;    


public interface PlatsDao {
    public void ajouterPlat(Plats plat);
    public Plats getPlatByCode(int codePlat);
    public ArrayList<Plats> getAllPlats();
    public void updatePlat(Plats plat);
    public void deletePlat(int codePlat);
}
