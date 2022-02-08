package ma.fstt.GestionProduits.repositoties;

import ma.fstt.GestionProduits.model.Categorie;
import ma.fstt.GestionProduits.model.Produit;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface produitRep extends MongoRepository<Produit,String> {

    List<Produit> findProduitByIdCat(String idCat);
}
