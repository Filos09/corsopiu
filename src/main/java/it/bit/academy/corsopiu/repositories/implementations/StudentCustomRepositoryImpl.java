package it.bit.academy.corsopiu.repositories.implementations;

import it.bit.academy.corsopiu.entities.Course;
import it.bit.academy.corsopiu.entities.Student;
import it.bit.academy.corsopiu.models.StudentSearchInfo;
import it.bit.academy.corsopiu.repositories.StudentCustomRepository;
import it.bit.academy.corsopiu.request.InfoRicercaCorsi;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentCustomRepositoryImpl implements StudentCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    private Map<String, Object> customSearchParams = new HashMap<>();

    @Override
    public List<Student> customSearch(StudentSearchInfo studentSearchInfo) {
        String query = createSearchString(studentSearchInfo);
        TypedQuery<Student> customQuery = entityManager.createQuery(query, Student.class);
        if(studentSearchInfo.getLimit() != 0){
            customQuery.setMaxResults(studentSearchInfo.getLimit());
        }
        customSearchParams.entrySet().forEach(kv -> customQuery.setParameter(kv.getKey(), kv.getValue()));
//        customSearchParams.entrySet().forEach(kv -> System.out.println(kv.getKey() + kv.getValue()));

        return customQuery.getResultList();
    }


    public String createSearchString(StudentSearchInfo studentSearchInfo) {

        customSearchParams.clear();
        String base = "SELECT s FROM Student s";
        boolean hasWhere = false;

        if(studentSearchInfo.getNameLike() != null && studentSearchInfo.getNameLike() != ""){
            customSearchParams.put("firstName","%"+studentSearchInfo.getNameLike()+"%");
            base += " WHERE s.firstName LIKE :firstName";
            hasWhere = true;
        }

        if(studentSearchInfo.getSurnameLike() != null && studentSearchInfo.getSurnameLike() != ""){
            customSearchParams.put("lastName","%"+studentSearchInfo.getSurnameLike()+"%");
            if(hasWhere){
                base += " OR s.lastName LIKE :lastName";
            } else {
                base +=" WHERE s.lastName LIKE :lastName";
                hasWhere = true;
            }
        }

        if(studentSearchInfo.getEmailLike() != null && studentSearchInfo.getEmailLike() != ""){
            customSearchParams.put("email","%"+studentSearchInfo.getEmailLike()+"%");
            if(hasWhere){
                base += " OR s.email LIKE :email";
            } else {
                base +=" WHERE s.email LIKE :email";
                hasWhere = true;
            }
        }

        return base;
    }

    @Override
    public Map<String, Object> getCustomSearchParams() {
        return customSearchParams;
    }
}
