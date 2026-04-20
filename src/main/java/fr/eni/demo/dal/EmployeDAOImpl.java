package fr.eni.demo.dal;

import fr.eni.demo.bo.Employe;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class EmployeDAOImpl implements EmployeDAO{

    private List<Employe> listeEmploye = new ArrayList<>();

    @Override
    public void create(Employe e) {
        listeEmploye.add(e);
    }

    @Override
    public Optional<Employe> read(Integer id) {
        return listeEmploye.stream().filter(e->e.getId().equals(id)).findFirst();
    }

    @Override
    public Optional<Employe> findByImmatriculation(String immatriculation) {
        return listeEmploye.stream().filter(e -> e.getImmatriculation().equals(immatriculation)).findFirst();
    }

    @Override
    public List<Employe> findAll() {
        return listeEmploye;
    }

    @Override
    public void update(Employe e) {
        Optional<Employe>   optionalEmploye = read(e.getId());
        if(optionalEmploye.isPresent()){
            Employe emp = optionalEmploye.get();
            emp.setEmail(e.getEmail());
            emp.setNom(e.getNom());
            emp.setPrenom(e.getPrenom());
            emp.setNumDom(e.getNumDom());
            emp.setNumPortable(e.getNumPortable());
            emp.setImmatriculation(e.getImmatriculation());

        }


    }

    @Override
    public void delete(Employe e) {

    }
}
