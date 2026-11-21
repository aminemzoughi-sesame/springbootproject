package com.sesame.demo.stereotypes;
import org.springframework.stereotype.Controller;
@Controller
public class EmpruntController {
    private final EmpruntService service;
    public EmpruntController(EmpruntService service) {
        this.service = service;
    }
    public void demander(String etudiant, String livre) {
        System.out.println("Requete recue : " + livre);
        service.emprunter(etudiant, livre);
    }
}