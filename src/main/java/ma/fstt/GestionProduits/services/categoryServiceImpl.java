package ma.fstt.GestionProduits.services;



import jdk.jfr.Category;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.fstt.GestionProduits.model.Categorie;
import ma.fstt.GestionProduits.repositoties.categorieRep;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j

public class categoryServiceImpl implements categoryService {
    private final categorieRep categorieRep;

    @Override
    public Categorie save(Categorie category) {
        log.info("saving category:{}", category.getId());
        return categorieRep.save(category);
    }

    @Override
    public Collection<Categorie> list(int limit) {
        return categorieRep.findAll(Pageable.ofSize(limit)).toList();
    }

    @Override
    public Collection<Categorie> getALL() {
        log.info("fetching all categories ");
        return categorieRep.findAll();
    }

    @Override
    public Categorie get(String id) {
        return categorieRep.findById(String.valueOf(id)).get();
    }

    @Override
    public Categorie update(Categorie category) {
        return null;
    }

    @Override
    public Boolean delete(String id) {
        log.info("delete category by id: {} ",id);
        categorieRep.deleteById(id);
        return true;
    }


}