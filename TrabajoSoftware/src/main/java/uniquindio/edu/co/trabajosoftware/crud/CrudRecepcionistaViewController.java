package uniquindio.edu.co.trabajosoftware.crud;

import uniquindio.edu.co.trabajosoftware.controllers.ModelFactoryController;
import uniquindio.edu.co.trabajosoftware.modelo.Cliente;
import uniquindio.edu.co.trabajosoftware.modelo.Hostal;

public class CrudRecepcionistaViewController {
    ModelFactoryController modelFactoryController;
    Hostal hostal;
    public CrudRecepcionistaViewController(ModelFactoryController modelFactoryController) {
        this.modelFactoryController = modelFactoryController;
        this.hostal = modelFactoryController.getHostal();
    }

    public void verificarLoginRecepcionista(String usuario, String contrasenia) {
        modelFactoryController.verificarLoginRecepcionista(usuario, contrasenia);

    }

    public boolean isLoginRecepcionista() {
        return modelFactoryController.isLoginRecepcionista();
    }

    public void cambiarEstadoLoginRecepcionista() {
        modelFactoryController.cambiarLoginRecepcionista();
    }
}
