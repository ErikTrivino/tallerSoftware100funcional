package uniquindio.edu.co.trabajosoftware.crud;

import javafx.collections.ObservableList;
import uniquindio.edu.co.trabajosoftware.controllers.ModelFactoryController;
import uniquindio.edu.co.trabajosoftware.exceptions.ClienteNoExiste;
import uniquindio.edu.co.trabajosoftware.modelo.Cliente;
import uniquindio.edu.co.trabajosoftware.modelo.Hostal;
import uniquindio.edu.co.trabajosoftware.modelo.Usuario;

import java.util.ArrayList;

public class CrudClienteViewController {
    ModelFactoryController modelFactoryController;
    Hostal hostal;
    public CrudClienteViewController(ModelFactoryController modelFactoryController) {
        this.modelFactoryController = modelFactoryController;
        this.hostal = modelFactoryController.getHostal();
    }
    public void crearCliente(Cliente cliente){

        modelFactoryController.crearCliente(cliente);
    }

    public void actualizarCliente(String nombre, String telefono, String email, String direccion, Usuario usuario, String documento){
        modelFactoryController.actualizarCliente(nombre, telefono, email, direccion, usuario, documento);
    }
    public void asignarClienteActualModelFactory(Cliente clienteLogin) {
        modelFactoryController.asignarClienteActualModelFactory(clienteLogin);
    }
    public Cliente obtenerCLienteByDocumento(String documento){
     return modelFactoryController.obtenerCLienteByDocumento(documento);
    }


    public Cliente obtenerCliente(String usuario) throws ClienteNoExiste {
        return modelFactoryController.obtenerCliete(usuario);
    }

    public boolean verificarLoginCliente(String usuario, String contrasenia) {
        return modelFactoryController.verificarLogin(usuario, contrasenia);
    }

    public ArrayList<Cliente> obtenerClientes() {
        return modelFactoryController.obtenerlistaClientes();
    }
}
