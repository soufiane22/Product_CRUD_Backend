package ma.fstt.GestionProduits.repositoties;

import ma.fstt.GestionProduits.model.Categorie;
import ma.fstt.GestionProduits.model.Produit;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface produitRep extends MongoRepository<Produit,String> {
}
