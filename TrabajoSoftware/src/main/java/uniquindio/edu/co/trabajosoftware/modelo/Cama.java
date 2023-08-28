package uniquindio.edu.co.trabajosoftware.modelo;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;

public class Cama implements Serializable {
    @Serial
    private static final long serialVersionUID = 1l;
    private  String id;
    private TipoCama tipoCama;
    private Estado estadoCama;
    private ArrayList<Reserva> listaReserva;

    public Cama() {
    }

    public Cama(String id, TipoCama tipoCama, Estado estadoCama) {
        this.id = id;
        this.tipoCama = tipoCama;
        this.estadoCama = estadoCama;
        this.listaReserva = new ArrayList<>();
    }

    public ArrayList<Reserva> getListaReserva() {
        return listaReserva;
    }

    public void setListaReserva(ArrayList<Reserva> listaReserva) {
        this.listaReserva = listaReserva;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TipoCama getTipoCama() {
        return tipoCama;
    }

    public void setTipoCama(TipoCama tipoCama) {
        this.tipoCama = tipoCama;
    }

    public Estado getEstadoCama() {
        return estadoCama;
    }

    public void setEstadoCama(Estado estadoCama) {
        this.estadoCama = estadoCama;
    }
}

