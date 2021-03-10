package it.bit.academy.corsopiu.repositories;

import it.bit.academy.corsopiu.entities.CourseEdition;
import it.bit.academy.corsopiu.entities.Module;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface ModuleRepository extends CrudRepository<Module, Long> {

    Collection<Module> findByEditionId(long id);
}
