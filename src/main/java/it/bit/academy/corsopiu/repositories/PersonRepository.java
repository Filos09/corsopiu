package it.bit.academy.corsopiu.repositories;

import it.bit.academy.corsopiu.dtos.ApplicationPersonDto;
import it.bit.academy.corsopiu.entities.Course;
import it.bit.academy.corsopiu.entities.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.Optional;

public interface PersonRepository extends CrudRepository<Person, Long> {

    Optional<Person> findByEmail(String email);

    @Query(value = "select p.id as person_id , a.id as appliation_id , p.first_name, p.last_name, p.email, a.application_state as 'status', a.application_date , a.comments from application as a , person as p where a.student_id = p.id and a.edition_id = ?1", nativeQuery = true)
    Collection<ApplicationPersonDto>fuggivia(long id);


}
