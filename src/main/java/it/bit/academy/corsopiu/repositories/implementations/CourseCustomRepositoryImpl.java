package it.bit.academy.corsopiu.repositories.implementations;

import it.bit.academy.corsopiu.entities.Course;
import it.bit.academy.corsopiu.repositories.CourseCustomRepository;
import it.bit.academy.corsopiu.request.InfoRicercaCorsi;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseCustomRepositoryImpl implements CourseCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    private Map<String,Object> customSearchParams = new HashMap<>();

    @Override
    public List<Course> customSearch(InfoRicercaCorsi infoRicercaCorsi) {
        String query = createSearchString(infoRicercaCorsi);
        TypedQuery<Course> customQuery = entityManager.createQuery(query,Course.class);
        customSearchParams.entrySet().forEach(kv -> customQuery.setParameter(kv.getKey(),kv.getValue()));
        return customQuery.getResultList();
    }




    public String createSearchString(InfoRicercaCorsi infoRicercaCorsi){
        customSearchParams.clear();
        String base = "SELECT c FROM Course c";
        boolean hasWhere = false;

        if(infoRicercaCorsi.getHasPrice() != null && infoRicercaCorsi.getHasPrice() == true){
            base += " WHERE c.price > 0";
            hasWhere = true;
        } else if(infoRicercaCorsi.getHasPrice() != null && infoRicercaCorsi.getHasPrice() == false){
            base += " WHERE c.price = 0";
            hasWhere = true;
        }

        if (infoRicercaCorsi.getTitleLike() != null ){
            customSearchParams.put(":title","%"+infoRicercaCorsi.getTitleLike()+"%");
            if(hasWhere){
                base += " AND c.title LIKE :title";
            } else {
                base += " WHERE c.title LIKE :title";
                hasWhere = true;
            }
        }

        if(infoRicercaCorsi.getCategory() != null){
            customSearchParams.put(":category",infoRicercaCorsi.getCategory());
            if(hasWhere){
                base += " AND c.category = :category";
            } else {
                base += " WHERE c.category = :category";
                hasWhere = true;
            }
        }

        if(infoRicercaCorsi.getCert() != null && infoRicercaCorsi.getCert() == true){
            if(hasWhere) {
                base += " AND c.certification = true";
            } else {
                base += " WHERE c.certification = true";
            }
        } else if (infoRicercaCorsi.getCert() != null && infoRicercaCorsi.getCert() == false){
            if(hasWhere){
                base += " AND c.certification = false";
            }else {
                base += " WHERE c.certification = false";
            }

        }

        customSearchParams.put(":min",infoRicercaCorsi.getMinDur());
        customSearchParams.put(":max",infoRicercaCorsi.getMaxDur());
        if(hasWhere){

            base += " AND c.duration BETWEEN :min AND :max";
        }else {
            base += " WHERE c.duration BETWEEN :min AND :max";
        }

        return base;
    }

    @Override
    public Map<String, Object> getCustomSearchParams() {
        return customSearchParams;
    }
}
