package fr.eni.demo.dal;

import fr.eni.demo.bo.Employe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeRepository extends JpaRepository<Employe, Integer> {

    Optional<Employe> findByImmatriculation(String immatriculation);

}
