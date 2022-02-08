package ma.fstt.GestionProduits.services;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.fstt.GestionProduits.model.Produit;
import ma.fstt.GestionProduits.repositoties.produitRep;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

import static org.springframework.data.domain.PageRequest.of;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class produitServiceImli implements produitService  {

    // save produit
    private final produitRep produitRep;
    @Override
    public Produit save(Produit produit) {
        log.info("saving client:{}", produit.getId());
        return produitRep.save(produit);
    }

    // liste des produit
    @Override
    public Collection<Produit> list(int limit) {
            log.info("fetching list produit ");
            return  produitRep.findAll(of(0,limit)).toList();


    }

    @Override
    public Collection<Produit> getALL() {
        log.info("fetching all products ");
        return produitRep.findAll();
    }

    @Override
    public Produit get(String id) {
        log.info("fetching product by id: {} ",id);
        return produitRep.findById(String.valueOf(id)).get();

    }

    @Override
    public Produit update(Produit client) {
        return null;
    }

    @Override
    public Boolean delete(String id) {
        log.info("delete product by id: {} ",id);
        produitRep.deleteById(id);
        return true;
    }

    @Override
    public Collection<Produit> getProduitsByCategory(String idCat) {
        Collection<Produit> list_producys = produitRep.findProduitByIdCat(idCat);
        return list_producys;
    }
}
