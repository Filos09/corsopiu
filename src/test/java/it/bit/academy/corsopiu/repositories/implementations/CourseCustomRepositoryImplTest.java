package it.bit.academy.corsopiu.repositories.implementations;

import it.bit.academy.corsopiu.repositories.CourseRepository;
import it.bit.academy.corsopiu.request.InfoRicercaCorsi;
import it.bit.academy.corsopiu.services.abstractions.SchedulerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CourseCustomRepositoryImplTest {

    public static final String JPQL_ALL_COURSES= "SELECT c FROM Course c WHERE c.duration BETWEEN :min AND :max";
    public static final String JPQL_COURSE_HAS_PRICE = "SELECT c FROM Course c WHERE c.price > 0 AND c.duration BETWEEN :min AND :max";
    public static final String JPQL_COURSE_HAS_NOT_PRICE = "SELECT c FROM Course c WHERE c.price = 0 AND c.duration BETWEEN :min AND :max";
    public static final String JPQL_COURS_HAS_PRICE_TITLE_LIKE = "SELECT c FROM Course c WHERE c.price > 0 AND c.title LIKE :title AND c.duration BETWEEN :min AND :max";
    public static final String JPQL_COURS_HAS_PRICE_TITLE_LIKE_IN_CATEGORY = "SELECT c FROM Course c WHERE c.price > 0 AND c.title LIKE :title AND c.category = :category AND c.duration BETWEEN :min AND :max";
    public static final String JPQL_COURS_HAS_PRICE_TITLE_LIKE_IN_CATEGORY_HAS_CERT = "SELECT c FROM Course c WHERE c.price > 0 AND c.title LIKE :title AND c.category = :category AND c.certification = true AND c.duration BETWEEN :min AND :max";
    public static final String JPQL_COURS_HAS_PRICE_TITLE_LIKE_IN_CATEGORY_HAS_CERT_HOUR = "SELECT c FROM Course c WHERE c.price > 0 AND c.title LIKE :title AND c.category = :category AND c.certification = true AND c.duration BETWEEN :min AND :max";

    @Autowired
    private CourseRepository courseRepository;
//    private SchedulerService schedulerService;


    @Test
    public void createSearchString_shouldReturnAllEntities_whenSearchPacketIsEmpty(){
        InfoRicercaCorsi p = new InfoRicercaCorsi();
        String query = courseRepository.createSearchString(p);
        assertEquals(JPQL_ALL_COURSES,query);
    }

    @Test
    public void createSearchString_shouldReturnNonFreeEntities_whenSearchPacket_requiresPayment(){
        InfoRicercaCorsi p = new InfoRicercaCorsi();
        p.setHasPrice(true);
        String query = courseRepository.createSearchString(p);
        assertEquals(JPQL_COURSE_HAS_PRICE,query);
    }

    @Test
    public void createSearchString_shouldReturnFreeEntities_whenSearchPacket_notRequiresPayment(){
        InfoRicercaCorsi p = new InfoRicercaCorsi();
        p.setHasPrice(false);
        String query = courseRepository.createSearchString(p);
        assertEquals(JPQL_COURSE_HAS_NOT_PRICE,query);
    }

    @Test
    public void createSearchString_shouldReturnAllEntities_whenSearchPacket_notSpecifiedPayment(){
        InfoRicercaCorsi p = new InfoRicercaCorsi();
        String query = courseRepository.createSearchString(p);
        assertEquals(JPQL_ALL_COURSES,query);
    }

    @Test
    public void create_search_string_should_return_non_free_entities_title_like_when_search_packet_specifies_payment_title_like(){
        InfoRicercaCorsi p = new InfoRicercaCorsi();
        p.setHasPrice(true);
        p.setTitleLike("Java");
        String query = courseRepository.createSearchString(p);
        assertEquals(JPQL_COURS_HAS_PRICE_TITLE_LIKE,query);
        Map<String,Object> params = courseRepository.getCustomSearchParams();
        assertEquals(3,params.size());
        assertEquals("%Java%",params.get(":title"));
    }

    @Test
    public void create_search_string_should_return_non_free_entities_title_like_in_category_when_search_packet_specifies_payment_title_like_category(){
        InfoRicercaCorsi p = new InfoRicercaCorsi();
        p.setHasPrice(true);
        p.setTitleLike("JavaScript");
        p.setCategory("Angular");
        String query = courseRepository.createSearchString(p);
        assertEquals(JPQL_COURS_HAS_PRICE_TITLE_LIKE_IN_CATEGORY,query);
        Map<String,Object> params = courseRepository.getCustomSearchParams();
        assertEquals(4,params.size());
        assertEquals("%JavaScript%",params.get(":title"));
        assertEquals("Angular",params.get(":category"));
    }

    @Test
    public void create_search_string_should_return_non_free_entities_title_like_in_category_with_cert_when_search_packet_specifies_payment_title_like_category_with_cert(){
        InfoRicercaCorsi p = new InfoRicercaCorsi();
        p.setHasPrice(true);
        p.setTitleLike("JavaScript");
        p.setCategory("Angular");
        p.setCert(true);
        String query = courseRepository.createSearchString(p);
        assertEquals(JPQL_COURS_HAS_PRICE_TITLE_LIKE_IN_CATEGORY_HAS_CERT,query);
        Map<String, Object> params = courseRepository.getCustomSearchParams();
        assertEquals(4,params.size());
        assertEquals("%JavaScript%",params.get(":title"));
        assertEquals("Angular",params.get(":category"));
    }

    @Test
    public void create_search_string_should_return_non_free_entities_title_like_in_category_with_cert_has_hour_range_when_search_packet_specifies_payment_title_like_category_with_cert(){
        InfoRicercaCorsi p = new InfoRicercaCorsi();
        p.setHasPrice(true);
        p.setTitleLike("JavaScript");
        p.setCategory("Angular");
        p.setCert(true);
        p.setMinDur(100);
        p.setMaxDur(600);
        String query = courseRepository.createSearchString(p);
        assertEquals(JPQL_COURS_HAS_PRICE_TITLE_LIKE_IN_CATEGORY_HAS_CERT_HOUR,query);
        Map<String,Object>params = courseRepository.getCustomSearchParams();
        assertEquals(4,params.size());
        assertEquals("%JavaScript%",params.get(":title"));
        assertEquals("Angular",params.get(":category"));
        assertEquals(100,params.get(":min"));
        assertEquals(600,params.get(":max"));
    }

}
