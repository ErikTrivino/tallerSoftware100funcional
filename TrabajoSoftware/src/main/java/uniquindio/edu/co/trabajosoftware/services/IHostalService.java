package uniquindio.edu.co.trabajosoftware.services;

import uniquindio.edu.co.trabajosoftware.modelo.Cliente;
import uniquindio.edu.co.trabajosoftware.modelo.Usuario;

public interface IHostalService {
    public void crearCliente(Cliente cliente);
    public void actualizarCliente(String nombre, String telefono, String email, String direccion, Usuario usuario, String documento);
    public boolean eliminarCliente(String documento);
    public boolean verificarClienteExistenteByDocumento(String documento);
}
