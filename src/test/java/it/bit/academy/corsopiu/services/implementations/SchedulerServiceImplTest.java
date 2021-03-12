package it.bit.academy.corsopiu.services.implementations;

import it.bit.academy.corsopiu.request.InfoRicercaCorsi;
import it.bit.academy.corsopiu.services.abstractions.SchedulerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class SchedulerServiceImplTest {
    public static final String JPQL_ALL_COURSES= "SELECT c FROM Course c";
    public static final String JPQL_COURSE_HAS_PRICE = "SELECT c FROM Course c WHERE c.price > 0";

    @Autowired
    private SchedulerService schedulerService;

    @Test
    public void createSearchString_shouldReturnAllEntities_whenSearchPacketIsEmpty(){
        InfoRicercaCorsi p = new InfoRicercaCorsi();
        String query = schedulerService.createSearchString(p);
        assertEquals(JPQL_ALL_COURSES,query);
    }

    @Test
    public void createSearchString_shouldReturnAllEntities_whenSearchPacket_requiresPayment(){
        InfoRicercaCorsi p = new InfoRicercaCorsi();
        p.setHasPrice(true);
        String query = schedulerService.createSearchString(p);
        assertEquals(JPQL_COURSE_HAS_PRICE,query);
    }

}


/*
TEST UNIT
TEST DRIVEN DEVELOPMENT

 */