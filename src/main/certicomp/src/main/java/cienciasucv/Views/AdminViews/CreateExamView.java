package cienciasucv.Views.AdminViews;
import javax.swing.*;

public class CreateExamView extends JFrame{
    private static CreateExamView instance= null;
    private CreateExamPanel panel;
    private CreateExamView(){
        panel = new CreateExamPanel();
        this.setBounds(80, 20, 640, 800);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("Administrador|Crear Examen");
        this.add(panel);
    }

    public static CreateExamView getCreateExamView(){
        if(instance==null){
            instance = new CreateExamView();
        }
        instance.setVisible(true);
        return instance; 
    }
   
    public static void destroyInstance(){
        if (instance !=null){
            instance.dispose();
            instance=null;
        }
    }
    @Override
    public void dispose(){
        panel.restartAll();
        super.dispose();
    }
}