package Model.categories;

import java.util.ArrayList;

import Model.plats.Plats;


public interface CategorieDao {
    public void ajouterCateg(Categorie plat);
    public Categorie getCategByCode(String codeCateg);
    public ArrayList<Categorie> getAllCategs();
    public void updateCateg(Categorie categ);
    public void deleteCateg(String codeCateg);
}
