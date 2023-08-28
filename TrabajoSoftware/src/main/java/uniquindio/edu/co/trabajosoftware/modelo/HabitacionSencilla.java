package uniquindio.edu.co.trabajosoftware.modelo;

import java.io.Serial;
import java.io.Serializable;

public class HabitacionSencilla extends Habitacion implements Serializable {
    @Serial
    private static final long serialVersionUID = 1l;

    public HabitacionSencilla(){

    }
    public HabitacionSencilla(String id, boolean banioPrivado, String telefono, boolean internet, boolean parqueadero, boolean camaExtra, Estado estadoHabitacion) {
        super(id, banioPrivado, telefono, internet, parqueadero, camaExtra, estadoHabitacion);
    }


}
