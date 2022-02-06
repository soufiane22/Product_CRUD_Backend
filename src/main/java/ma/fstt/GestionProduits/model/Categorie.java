package ma.fstt.GestionProduits.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.util.List;

import static javax.persistence.GenerationType.AUTO;

@Document(collection = "categorie")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
//@Entity
public class Categorie {

    @Id  @GeneratedValue(strategy= GenerationType.IDENTITY)
    private String id;
    @Field
    private String designation ;
    //@DocumentReference(lazy=true)
    private List<Produit> listProduits;
}
