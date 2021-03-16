package it.bit.academy.corsopiu.services.abstractions;

import it.bit.academy.corsopiu.entities.Student;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface StudentService {

    Optional<Student> findById(long id);
}
