package cienciasucv.Views.AdminViews;

import javax.swing.JPanel;

import cienciasucv.Views.MainView;

public class AdminView extends MainView {

    public AdminView(String adminName){
        
        String[] tabTitles = {
            "Inicio", 
            "Gestión de Exámenes",
            "Gestión de Cursos", 
            "Gestión de Usuarios", 
            "Mi Perfil"
        };
        
        JPanel[] tabContentPanels = {
            new AdminHomeView(adminName, "Administrador").getHomeContent(), 
            new ExamsManagementView().getExamsPanelContent(),
            new CourseManagementView().getCoursesPanelContent(),
            new UsersManagementView().getUsersPanelContent(), 
            new MyProfileView().getMyProfileContent()
        };

        createTabs(tabTitles, tabContentPanels);
        this.setVisible(true);
        this.setTitle("Admin | " + adminName);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
    @Override
    protected void createTabs(String[] tabTitles, JPanel[] panels) {
        super.createTabs(tabTitles, panels);
    }

}