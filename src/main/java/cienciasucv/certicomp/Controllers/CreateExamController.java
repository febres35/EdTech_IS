package cienciasucv.certicomp.Controllers;
import cienciasucv.certicomp.Models.*;
import cienciasucv.certicomp.Views.AdminViews.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JTextArea;

public class CreateExamController {
   public enum action {
        CREAR,
        EDITAR;
    }
    private String generateExamId() {
        int nextId = 1;
        boolean foundGap = false;
    
        // Obtener una lista ordenada de las claves del mapa
        List<String> sortedKeys = new ArrayList<>(Exam.exams.keySet());
        Collections.sort(sortedKeys);
    
        for (String examId : sortedKeys) {
            int currentIdNumber = Integer.parseInt(examId.substring(1));
            if (currentIdNumber != nextId) {
                foundGap = true;
                break;
            }
            nextId++;
        }
    
        if (foundGap) {
            return "E" + String.format("%03d", nextId);
        } else {
            return "E" + String.format("%03d", sortedKeys.size() + 1);
        }
    }


    private String generateDominiumId(String path){
        int nextId = 1;
        boolean foundGap = false;

        List<String> sortedKeys = new ArrayList<>(Domain.domains.keySet());
        Collections.sort(sortedKeys);
    
        for (String domainID : sortedKeys) {
            int currentIdNumber = Integer.parseInt(domainID.substring(1));
            if (currentIdNumber != nextId) {
                foundGap = true;
                break;
            }
            nextId++;
        }
    
        if (foundGap) {
            return "E" + String.format("%03d", nextId);
        } else {
            return "E" + String.format("%03d", sortedKeys.size() + 1);
        }
    }       
   
    public void collectDominiums(JTextArea dominios,Exam exam){
     String text = dominios.getText().trim();
     String[] lines= text.split("\\n");

     for(String line:lines){
        line=line.trim();
        Domain domain = new Domain(generateDominiumId("src/main/resources/data/domains.json"), line);
        if (Domain.domainExists(domain.getName())){
            exam.addDomain(Domain.getDomainByName(domain.getName()));
        }else{
            Domain.createNewDom(domain);
            exam.addDomain(domain.getID());
     }
    }
    }
    
    public Exam collectExamData(CreateExamPanel view,action accion,Exam examen){
        String name= view.getNameBox();
        String id;
        String instructions= view.getInstructionsArea();
        String duration=String.valueOf(view.getDurationBox());
        ArrayList<String> domains= new ArrayList<>();
        ArrayList<String> questions = new ArrayList<>();
        switch (accion) {
            case CREAR:
             id = generateExamId();
                break;
            case EDITAR:
             id = examen.getID();
                break;
            default:
            id=null;
            break;
        }
        
        return new Exam(name,id,duration,instructions,domains);
}
}
