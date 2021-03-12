package it.bit.academy.corsopiu.repositories;

import it.bit.academy.corsopiu.entities.Course;
import it.bit.academy.corsopiu.request.InfoRicercaCorsi;

import java.util.List;
import java.util.Map;

public interface CourseCustomRepository {

    List<Course> customSearch(InfoRicercaCorsi infoRicercaCorsi);
    String createSearchString(InfoRicercaCorsi infoRicercaCorsi);
    Map<String,Object> getCustomSearchParams ();
}
