package it.bit.academy.corsopiu.repositories;

import it.bit.academy.corsopiu.entities.CourseEdition;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;


public interface EditionRepository extends CrudRepository<CourseEdition,Long> {

//    Collection<CourseEdition> findTop3ByCourseIdOrderByIdDesc(long id);
Collection<CourseEdition> findAllByCourseIdOrderByIdDesc(long id);
//
    Collection<CourseEdition> findAllById(long id);

    @Query(value = "SELECT * FROM thinksharp.course_edition;", nativeQuery = true)
    Collection<CourseEdition> getEditions();
}
