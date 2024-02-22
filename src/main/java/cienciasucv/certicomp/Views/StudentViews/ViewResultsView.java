package cienciasucv.certicomp.Views.StudentViews;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import cienciasucv.certicomp.Views.LogoFactory;
import cienciasucv.certicomp.Views.LogoSize;

public class ViewResultsView {

    private JFrame frame;

    ViewResultsView(){
        
        frame = new JFrame("Estudiante | Resultados ");

        JPanel container = new JPanel();
        JPanel logoPanel = new JPanel();
        
        logoPanel.add(LogoFactory.getLogo(LogoSize.SMALL));

        JTextArea textArea = new JTextArea(25, 30);
        textArea.setText("Resultados \n Área de Resultados");
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textArea);
        
        container.add(logoPanel);
        container.add(scrollPane);

        frame.add(container);
        frame.setSize(450, 600);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
    
}
