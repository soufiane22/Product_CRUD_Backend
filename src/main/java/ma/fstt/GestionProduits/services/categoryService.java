package ma.fstt.GestionProduits.services;


import ma.fstt.GestionProduits.model.Categorie;
import ma.fstt.GestionProduits.model.Produit;

import java.util.Collection;

public interface categoryService {

    Categorie save(Categorie category);


    Collection<Categorie> list(int limit);

    Collection<Categorie> getALL();

    Categorie get(String id);

    Categorie update(Categorie category);

    Boolean delete(String id);
}
