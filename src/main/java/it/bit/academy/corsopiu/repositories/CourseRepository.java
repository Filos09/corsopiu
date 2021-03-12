package it.bit.academy.corsopiu.repositories;

import it.bit.academy.corsopiu.entities.Course;
import it.bit.academy.corsopiu.entities.CourseEdition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface CourseRepository extends JpaRepository<Course, Long>, CourseCustomRepository {

    @Query(value = "SELECT * FROM thinksharp.course_edition;", nativeQuery = true)
    Collection<CourseEdition> getEditions();


}
