package ma.fstt.GestionProduits.controler;


import lombok.RequiredArgsConstructor;
import ma.fstt.GestionProduits.model.Produit;
import ma.fstt.GestionProduits.model.Response;
import ma.fstt.GestionProduits.repositoties.produitRep;
import ma.fstt.GestionProduits.services.produitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/produit")
@RequiredArgsConstructor
public class produitControler {
    @Autowired
    produitRep produitRep;
    private final produitService produitService;

    @CrossOrigin(origins = "*")
    @GetMapping("/list/{limit}")
    public ResponseEntity<Response> getProduit(@PathVariable("limit") int limit) {

        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data1( produitService.list(limit))
                        .message("produits retrieve")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getProduitById(@PathVariable("id") String id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("products", produitService.get(id)))
                        .message("product retrieve")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/getall")
    public ResponseEntity<Collection> getAllProduct() {
        return  ResponseEntity.ok( produitService.getALL());
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/getlist/{id_cat}")
    public ResponseEntity<Collection> getProducts(@PathVariable("id_cat") String id_cat) {
        return  ResponseEntity.ok( produitService.getProduitsByCategory(id_cat));
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/save")
    public ResponseEntity<Response> SaveProduit(@RequestBody Produit produit) {

        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("client",produitService.save(produit)))
                        .message("produit craeted")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> DeleteProduit(@PathVariable("id") String id) {

        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("product deleted",produitService.delete(id)))
                        .message("product is deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @CrossOrigin(origins = "*")
    @PutMapping("/update/{id}")
   // @RequestMapping(method = RequestMethod.PATCH)
    public ResponseEntity<Response> UpdateProduit(@PathVariable("id") String id , @RequestBody Produit produit) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("product updated",produitService.update(id , produit)))
                        .message("product is updated")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }
}
