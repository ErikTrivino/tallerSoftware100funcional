package uniquindio.edu.co.trabajosoftware.crud;

import uniquindio.edu.co.trabajosoftware.controllers.ModelFactoryController;
import uniquindio.edu.co.trabajosoftware.modelo.*;

import java.util.ArrayList;

public class CrudCamaViewController {
    ModelFactoryController modelFactoryController;
    Hostal hostal;

    public CrudCamaViewController(ModelFactoryController modelFactoryController) {
        this.modelFactoryController = modelFactoryController;
        this.hostal = modelFactoryController.getHostal();
    }
    public ArrayList<Cama> obtenerListaCamas(){
        return modelFactoryController.obtenerListaCamas();
    }
    public void cambiarEstadoCama(String idCama, Estado estadoNuevo, TipoCama tipoCama){
        modelFactoryController.cambiarEstadoCama(idCama, estadoNuevo, tipoCama);
    }



    public Hostal getHostal() {
        return hostal;
    }

    public void setHostal(Hostal hostal) {
        this.hostal = hostal;
    }
}
