package uniquindio.edu.co.trabajosoftware.modelo;

import java.io.Serial;
import java.io.Serializable;

public class Pago implements Serializable {
    @Serial
    private static final long serialVersionUID = 1l;
    private String id;
    private String idReserva;
    private String fechaPago;
    private double valorPago;
    public Pago(){

    }

    public Pago(String id, String idReserva, String fechaPago, double valorPago) {
        this.id = id;
        this.idReserva = idReserva;
        this.fechaPago = fechaPago;
        this.valorPago = valorPago;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(String idReserva) {
        this.idReserva = idReserva;
    }

    public String getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }
}
