package it.bit.academy.corsopiu.repositories;

import it.bit.academy.corsopiu.entities.Course;
import it.bit.academy.corsopiu.entities.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PersonRepository extends CrudRepository<Course, String> {

    Optional<Person> findByEmail(String email);
}
