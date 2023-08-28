package uniquindio.edu.co.trabajosoftware.crud;

import uniquindio.edu.co.trabajosoftware.controllers.ModelFactoryController;
import uniquindio.edu.co.trabajosoftware.modelo.Estado;
import uniquindio.edu.co.trabajosoftware.modelo.Habitacion;
import uniquindio.edu.co.trabajosoftware.modelo.Hostal;
import uniquindio.edu.co.trabajosoftware.modelo.TipoCama;

import java.util.ArrayList;

public class CrudHabitacionViewController {
    ModelFactoryController modelFactoryController;
    Hostal hostal;

    public CrudHabitacionViewController(ModelFactoryController modelFactoryController) {
        this.modelFactoryController = modelFactoryController;
        this.hostal = modelFactoryController.getHostal();
    }
    public ArrayList<Habitacion> obtenerListaHabitaciones(){
        return modelFactoryController.obtenerListaHabitaciones();
    }
    public void cambiarEstadoHabitacion(String idHabitacion, Estado estadoNuevo, TipoCama tipoCama){
        modelFactoryController.cambiarEstadoHabitacion(idHabitacion, estadoNuevo, tipoCama);
    }
    public void cambiarTipoCama(String idHabitacion, TipoCama tipoCama){
        modelFactoryController.cambiarTipoCama(idHabitacion, tipoCama);
    }



    public Hostal getHostal() {
        return hostal;
    }

    public void setHostal(Hostal hostal) {
        this.hostal = hostal;
    }
}
