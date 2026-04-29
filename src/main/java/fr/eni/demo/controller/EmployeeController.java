package fr.eni.demo.controller;

import fr.eni.demo.bll.EmployeService;
import fr.eni.demo.bo.Employe;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor

@RestController
@RequestMapping("/eniecole")
public class EmployeeController {

    private EmployeService employeService;

    @GetMapping("/employes")
    public ResponseEntity<?> chargerTousLesEmployes(){
        List<Employe> employeList = employeService.chargerTousLesEmployes();
        if(employeList == null || employeList.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(employeList);
    }

    @GetMapping("/employe/{id}")
    public ResponseEntity<?> rechercherUnEmployee(@PathVariable("id") String idInPath){

        try{
            // Il faut parser l'id, qu'est un int vers String pour l'envoyer en "@PathVariable"
            int idEmploye = Integer.parseInt(idInPath);
            Employe employe = employeService.chargerUnEmploye(idEmploye);
            return ResponseEntity.ok(employe);

        } catch (NumberFormatException e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("L'identifiant doit être un entier.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping("/employe")
    ResponseEntity<?> ajouterEmploye(@Valid @RequestBody Employe employe){
        try{
            employeService.ajouter(employe);
            return ResponseEntity.ok(employe);
        } catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage());
        }
    }
}
