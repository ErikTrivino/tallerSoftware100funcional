package uniquindio.edu.co.trabajosoftware.modelo;

import java.io.Serial;
import java.io.Serializable;

public class Cliente extends Persona implements Serializable {
    @Serial
    private static final long serialVersionUID = 1l;
    private Usuario usuario;

    public Cliente(String nombre, String documento, String telefono, String email, String direccion) {
        super(nombre, documento, telefono, email, direccion);
    }

    public Cliente(String nombre, String documento, String telefono, String email, String direccion, Usuario usuario) {
        super(nombre, documento, telefono, email, direccion);
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "usuario=" + usuario +
                '}';
    }
}
