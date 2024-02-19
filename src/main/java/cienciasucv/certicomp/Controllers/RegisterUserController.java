package cienciasucv.certicomp.Controllers;

import java.util.ArrayList;

import cienciasucv.certicomp.Controllers.Abstract.FormsController;

public class RegisterUserController extends FormsController{



    public void collectUserDataInput(ArrayList<String> data) {

        System.out.println("Received data");
        this.register(data);
    }

    @Override
    protected void collectData(ArrayList<String> data) {

        for(String element : data){

            System.out.println(element);

        }
        
    }

    @Override
    protected boolean validateData(ArrayList<String> data) {
        
        throw new UnsupportedOperationException("Unimplemented method 'validateData'");
    }

    @Override
    protected void submitData(ArrayList<String> data) {
        
        throw new UnsupportedOperationException("Unimplemented method 'submitData'");
    }
    
}
