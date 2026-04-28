package fr.eni.demo.controller;

import fr.eni.demo.bll.EmployeService;
import fr.eni.demo.bo.Employe;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
