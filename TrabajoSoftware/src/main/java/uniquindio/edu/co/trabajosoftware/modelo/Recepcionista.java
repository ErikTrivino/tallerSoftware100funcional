package uniquindio.edu.co.trabajosoftware.modelo;

import java.io.Serial;
import java.io.Serializable;

public class Recepcionista extends Persona implements Serializable {
    @Serial
    private static final long serialVersionUID = 1l;

    private Usuario usuario;
    private boolean login;
    public Recepcionista(){

    }

    public Recepcionista(String nombre, String documento, String telefono, String email, String direccion, Usuario usuario) {
        super(nombre, documento, telefono, email, direccion);
        this.usuario = usuario;
    }

    public boolean isLogin() {
        return login;
    }

    public void setLogin(boolean login) {
        this.login = login;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
