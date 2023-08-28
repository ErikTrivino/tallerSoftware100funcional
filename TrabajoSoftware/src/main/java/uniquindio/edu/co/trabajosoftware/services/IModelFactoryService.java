package uniquindio.edu.co.trabajosoftware.services;



import uniquindio.edu.co.trabajosoftware.modelo.Cliente;
import uniquindio.edu.co.trabajosoftware.modelo.Usuario;

import java.time.LocalDate;
import java.util.ArrayList;

public interface IModelFactoryService {

    public void crearCliente(Cliente cliente);
    public void actualizarCliente(String nombre, String telefono, String email, String direccion, Usuario usuario, String documento);
    public boolean eliminarCliente(String documento);
    public boolean verificarClienteExistenteByDocumento(String documento);

}
