package cienciasucv.certicomp.Controllers.Abstract;

import java.util.ArrayList;

public abstract class FormsController {

    public void register(ArrayList<String> data) {
        collectData(data);
        if (validateData(data)) {
            submitData(data);
        } else {
            
        }
    }

    protected abstract void collectData(ArrayList<String> data);

    protected abstract boolean validateData(ArrayList<String> data);

    protected abstract void submitData(ArrayList<String> data);
}