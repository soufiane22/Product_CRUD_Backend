package ma.fstt.GestionProduits;

import lombok.RequiredArgsConstructor;
import ma.fstt.GestionProduits.model.Produit;
import ma.fstt.GestionProduits.repositoties.produitRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })

public class GestionProduitsApplication implements CommandLineRunner {

	private  produitRep produitRep;

	@Autowired
	public void Application(produitRep produitRep){
		this.produitRep= produitRep;
	}

	public static void main(String[] args) {
		SpringApplication.run(GestionProduitsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Produit pr1 = new Produit("test34443",44);
		Produit pr2 = new Produit("aaaaa",44);
         //this.produitRep.insert(pr1);
		//this.produitRep.insert(pr2);

	}
}
