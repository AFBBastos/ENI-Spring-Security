package fr.eni.demo.bo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
public class TestEmploye {

    @Test
    public void test_employe(){
        Employe e = Employe.builder()
                .nom("NomTest")
                .prenom("PrenomTest")
                .build();

        log.info(e.toString());

        Assertions.assertNotNull(e);
        assertThat(e.getNom()).isEqualTo("NomTest");

    }


}
