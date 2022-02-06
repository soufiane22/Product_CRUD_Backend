package ma.fstt.GestionProduits.controler;


import com.mongodb.client.model.Collation;
import lombok.RequiredArgsConstructor;
import ma.fstt.GestionProduits.model.Categorie;
import ma.fstt.GestionProduits.model.Produit;
import ma.fstt.GestionProduits.model.Response;
import ma.fstt.GestionProduits.repositoties.categorieRep;
import ma.fstt.GestionProduits.services.categoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class categoryControler {

    @Autowired
    categorieRep categorieRep;
    private final categoryService categoryService;

    @CrossOrigin(origins = "*")
    @GetMapping("/list/{limit}")
    public ResponseEntity<Response> getCategory(@PathVariable("limit") int limit) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data1(categoryService.list(limit))
                        .message("categories retrieve")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getCategoryById(@PathVariable("id") String id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("gategory", categoryService.get(id)))
                        .message("category retrieve")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/getall")
    public ResponseEntity<Collection> getAllCategory() {
        return ResponseEntity.ok(
            categoryService.getALL()
        );
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/save")
    public ResponseEntity<Response> SaveCategory(@RequestBody Categorie category) {

        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("category", categoryService.save(category)))
                        .message("category craeted")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> DeleteCategory(@PathVariable("id") String id) {

        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("category deleted",categoryService.delete(id)))
                        .message("category is deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}
