package cienciasucv.Views.StudentViews;

import javax.swing.JPanel;
import cienciasucv.Views.MainView;

public class StudentView extends MainView {

    public StudentView(String studentName){

        String[] tabTitles = {
            "Inicio", 
            "Exámenes/Cursos",
            "Mis Resultados",
            "Mi Perfil"
        };

        JPanel[] tabContentPanels = {
            new StudentHomeView(studentName, "Estudiante").getHomeContent(), 
            new ExamsListView().getExamsPanelContent(),
            new MyResultsView().getResultsPanelContent(),
            new MyProfileView().getMyProfileContent() 
        };

        createTabs(tabTitles, tabContentPanels);
        this.setVisible(true);
        this.setTitle("Estudiante | " + studentName);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    @Override
    protected void createTabs(String[] tabTitles, JPanel[] panels) {
        super.createTabs(tabTitles, panels);
    }
    
}