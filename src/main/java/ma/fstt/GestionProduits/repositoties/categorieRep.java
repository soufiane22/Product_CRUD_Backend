package ma.fstt.GestionProduits.repositoties;

import ma.fstt.GestionProduits.model.Categorie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface categorieRep  extends MongoRepository<Categorie,String> {
}
