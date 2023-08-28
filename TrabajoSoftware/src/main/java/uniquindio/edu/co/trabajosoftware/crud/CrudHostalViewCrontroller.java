package uniquindio.edu.co.trabajosoftware.crud;

import uniquindio.edu.co.trabajosoftware.controllers.ModelFactoryController;
import uniquindio.edu.co.trabajosoftware.modelo.Hostal;

public class CrudHostalViewCrontroller {
    ModelFactoryController modelFactoryController;
    Hostal hostal;

    public CrudHostalViewCrontroller(ModelFactoryController modelFactoryController) {
        this.modelFactoryController = modelFactoryController;
        this.hostal = modelFactoryController.getHostal();
    }

    public Hostal getHostal() {
        return hostal;
    }

    public void setHostal(Hostal hostal) {
        this.hostal = hostal;
    }
}
