package fr.eni.demo.bll;

import fr.eni.demo.bo.Employe;
import fr.eni.demo.dal.EmployeRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Slf4j
public class TestEmployeService {

    @Autowired
    private EmployeService employeService;

    @MockitoBean
    private EmployeRepository employeRepository;

    @Test
    void test_employeNull(){

        Assertions.assertThrows(RuntimeException.class,
                ()-> employeService.ajouter(null));

    }

    @Test
    void test_ajout_employe_immat_existe(){

        String immatriculation = "TEST01";
        Employe employe01 = Employe.builder()
                .email("email@email.fr")
                .nom("NomTest")
                .prenom("PrenomTest")
                .immatriculation(immatriculation)
                .build();

//        Mockito.when(
//                employeRepository.findByImmatriculation(immatriculation))
//                .thenReturn(Optional.of(employe01));

        RuntimeException e = Assertions.assertThrows(RuntimeException.class,
                ()-> employeService.ajouter(employe01));

        Assertions.assertEquals("L'immatriculation doit être unique", e.getMessage());
    }

    @Test
    void test_chargerTousLesEmployes_nonVide(){
        String immatriculation1 = "TEST02";

        Employe employe01 = Employe.builder()
                .email("email@email.fr")
                .nom("NomTest")
                .prenom("PrenomTest")
                .immatriculation(immatriculation1)
                .build();

        String immatriculation2 = "TEST02";

        Employe employe02 = Employe.builder()
                .email("email@email.fr")
                .nom("NomTest")
                .prenom("PrenomTest")
                .immatriculation(immatriculation2)
                .build();

        List<Employe>listeEmploye = new ArrayList<>();
        listeEmploye.add(employe01);
        listeEmploye.add(employe02);

        Mockito.when(employeRepository.findAll()).thenReturn(listeEmploye);

        List<Employe> employeList = employeService.chargerTousLesEmployes();

        org.assertj.core.api.Assertions.assertThat(employeList).hasSize(2);

        log.info(employeList.toString());

    }






}
