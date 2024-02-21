package cienciasucv.certicomp.Views.AdminViews;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import cienciasucv.certicomp.Controllers.CreateExamController;
import cienciasucv.certicomp.Models.Exam;

public class EditExamView extends CreateExamView {
    EditExamView(Exam examen){
    super();
    final Exam Examen=examen;
    final CreateExamPanel panel=this.panel;
    panel.botonCrear.setText("EDITAR");
    panel.botonCrear.removeActionListener(panel.botonCrear.getActionListeners()[0]);
    panel.NameBox.setText(examen.getName());
    panel.DurationBox.setText(examen.getDuration());
    for(String linea: examen.getDomainList()){
        panel.DominiumArea.append(linea+ "\n");
    }
    panel.InstructionsArea.setText(examen.fetchInstructions());
    
    panel.botonCrear.addActionListener((ActionListener) new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae){
            if(CreateExamPanel.camposLlenos()==false){
            JOptionPane.showMessageDialog(null, "DEBE LLENAR TODOS LOS CAMPOS"); 
            }else{
            if(Integer.parseInt(CreateExamPanel.DurationBox.getText())<30){
            JOptionPane.showMessageDialog(null, "LA DURACION DEBE SER MAYOR A 30 MINUTOS");
            }else{
            CreateExamController controller = new CreateExamController();//añade esta instruccion aqui
            Exam newExam= controller.collectExamData(panel,CreateExamController.action.EDITAR,Examen);
            controller.collectDominiums(panel.DominiumArea,newExam);
            Exam.editExam(Examen.getID(),newExam);
            CreateExamPanel.restartAll();
            EditExamView.this.dispose();
            return;
        }
            }
        }
    });
    }

}
            
        
    

