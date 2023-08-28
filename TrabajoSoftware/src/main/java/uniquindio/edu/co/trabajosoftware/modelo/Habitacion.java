package uniquindio.edu.co.trabajosoftware.modelo;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;

public class Habitacion implements Serializable {
    @Serial
    private static final long serialVersionUID = 1l;
    private String id;
    private boolean banioPrivado;
    private String telefono;
    private boolean internet;
    private boolean parqueadero;
    private boolean camaExtra;
    private Estado estadoHabitacion;
    private ArrayList<Reserva> reservas;
    private TipoCama tipoCama;

    public Habitacion() {
    }

    public Habitacion(String id, boolean banioPrivado, String telefono, boolean internet, boolean parqueadero, boolean camaExtra, Estado estadoHabitacion) {
        this.id = id;
        this.banioPrivado = banioPrivado;
        this.telefono = telefono;
        this.internet = internet;
        this.parqueadero = parqueadero;
        this.camaExtra = camaExtra;
        this.estadoHabitacion = estadoHabitacion;
        this.reservas = new ArrayList<>();
    }

    public TipoCama getTipoCama() {
        return tipoCama;
    }

    public void setTipoCama(TipoCama tipoCama) {
        this.tipoCama = tipoCama;
    }

    public void agregarReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isBanioPrivado() {
        return banioPrivado;
    }

    public void setBanioPrivado(boolean banioPrivado) {
        this.banioPrivado = banioPrivado;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean isInternet() {
        return internet;
    }

    public void setInternet(boolean internet) {
        this.internet = internet;
    }

    public boolean isParqueadero() {
        return parqueadero;
    }

    public void setParqueadero(boolean parqueadero) {
        this.parqueadero = parqueadero;
    }

    public boolean isCamaExtra() {
        return camaExtra;
    }

    public void setCamaExtra(boolean camaExtra) {
        this.camaExtra = camaExtra;
    }

    public Estado getEstadoHabitacion() {
        return estadoHabitacion;
    }

    public void setEstadoHabitacion(Estado estadoHabitacion) {
        this.estadoHabitacion = estadoHabitacion;
    }
}
