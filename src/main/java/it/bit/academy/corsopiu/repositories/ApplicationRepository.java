package it.bit.academy.corsopiu.repositories;

import it.bit.academy.corsopiu.entities.Application;
import it.bit.academy.corsopiu.entities.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface ApplicationRepository extends CrudRepository<Application, Long> {

    Collection<Application> findByEditionId(long id);

}
