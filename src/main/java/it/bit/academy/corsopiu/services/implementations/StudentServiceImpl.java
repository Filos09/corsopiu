package it.bit.academy.corsopiu.services.implementations;

import it.bit.academy.corsopiu.entities.Student;
import it.bit.academy.corsopiu.repositories.StudentRepository;
import it.bit.academy.corsopiu.services.abstractions.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Optional<Student> findById(long id) {

        return studentRepository.findById(id);
    }
}
