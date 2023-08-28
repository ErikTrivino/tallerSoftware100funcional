package uniquindio.edu.co.trabajosoftware.modelo;

import java.io.Serial;
import java.io.Serializable;

public class Reserva implements Serializable {
    @Serial
    private static final long serialVersionUID = 1l;
    private  String id;
    private String fechaReserva;
    private String fechaInicioReserva;
    private String fechaFinReserva;
    private int cantidadPersonas;
    private String idCliente;
    private String idHabitacion;
    private double precioReserva;

    private Pago pago;

    public Reserva() {
    }

    public Reserva(String id, String fechaReserva, String fechaInicioReserva, String fechaFinReserva, int cantidadPersonas, String idCliente, String idHabitacion, double precioReserva) {
        this.id = id;
        this.fechaReserva = fechaReserva;
        this.fechaInicioReserva = fechaInicioReserva;
        this.fechaFinReserva = fechaFinReserva;
        this.cantidadPersonas = cantidadPersonas;
        this.idCliente = idCliente;
        this.idHabitacion = idHabitacion;
        this.precioReserva = precioReserva;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(String fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public String getFechaInicioReserva() {
        return fechaInicioReserva;
    }

    public void setFechaInicioReserva(String fechaInicioReserva) {
        this.fechaInicioReserva = fechaInicioReserva;
    }

    public String getFechaFinReserva() {
        return fechaFinReserva;
    }

    public void setFechaFinReserva(String fechaFinReserva) {
        this.fechaFinReserva = fechaFinReserva;
    }

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(int cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(String idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public double getPrecioReserva() {
        return precioReserva;
    }

    public void setPrecioReserva(double precioReserva) {
        this.precioReserva = precioReserva;
    }
}
