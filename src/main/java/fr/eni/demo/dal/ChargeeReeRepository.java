package fr.eni.demo.dal;

import fr.eni.demo.bo.ChargeRee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChargeeReeRepository extends JpaRepository<ChargeRee, Integer> {
}
