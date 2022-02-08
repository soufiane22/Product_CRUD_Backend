package ma.fstt.GestionProduits.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;
import static javax.persistence.GenerationType.IDENTITY;

@Document(collection = "produit")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
//@Entity
public class Produit {
    @Id
   @GeneratedValue(strategy = AUTO)
    private String id;
    @Field
    private String label;
    @Field
    private double pu;

    @Field
    private String idCat;




    public Produit(String label, double i) {
        this.label = label;
        this.pu = i;
    }
}
