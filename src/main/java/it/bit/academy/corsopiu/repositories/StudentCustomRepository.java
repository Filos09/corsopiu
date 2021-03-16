package it.bit.academy.corsopiu.repositories;

import it.bit.academy.corsopiu.entities.Student;
import it.bit.academy.corsopiu.models.StudentSearchInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Map;

public interface StudentCustomRepository  {

    List<Student>customSearch(StudentSearchInfo studentSearchInfo);
    String createSearchString(StudentSearchInfo studentSearchInfo);
    Map<String,Object> getCustomSearchParams();
}
