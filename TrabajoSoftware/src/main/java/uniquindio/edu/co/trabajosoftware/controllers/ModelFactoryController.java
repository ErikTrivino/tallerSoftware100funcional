package uniquindio.edu.co.trabajosoftware.controllers;

import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import uniquindio.edu.co.trabajosoftware.exceptions.ClienteNoExiste;
import uniquindio.edu.co.trabajosoftware.modelo.*;
import uniquindio.edu.co.trabajosoftware.persistence.Persistencia;
import uniquindio.edu.co.trabajosoftware.services.IModelFactoryService;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ModelFactoryController implements IModelFactoryService {
    Hostal hostal;
    Cliente clienteActual;
    Thread hiloServicio1_guardarResourceXml;
    Thread hiloServicio2_guardarRegistroLog;
    String mensaje;
    int nivel;
    String accion;

    public Hostal getHostal() {
        return hostal;
    }

    public void setHostal(Hostal hostal) {
        this.hostal = hostal;
    }

    @Override
    public void crearCliente(Cliente cliente) {
        getHostal().getListaClientes().add(cliente);
    }

    @Override
    public void actualizarCliente(String nombre, String telefono, String email, String direccion, Usuario usuario, String documento) {
        getHostal().actualizarCliente(nombre, telefono, email, direccion, usuario,  documento);
    }

    @Override
    public boolean eliminarCliente(String documento) {
        return false;
    }

    @Override
    public boolean verificarClienteExistenteByDocumento(String documento) {
        return false;
    }

    public void asignarClienteActualModelFactory(Cliente clienteLogin) {
        clienteActual = clienteLogin;
    }

    public Cliente obtenerCliete(String usuario) throws ClienteNoExiste {
        if(getHostal().obtenerClienteLogin(usuario) != null){
            return getHostal().obtenerClienteLogin(usuario);
        }else{
            try {
                throw new ClienteNoExiste("El cliente no existe;");
            }catch (Exception e){
                registrarAccionesSistema(e.getMessage(), 2, "Obtener cliente");
            }
            return null;
        }

    }

    public void verificarLoginRecepcionista(String usuario, String contrasenia) {
        if(getHostal().verificarLoginRecepcionista(usuario, contrasenia)){

            getHostal().getRecepcionista().setLogin(true);
        }else{

            getHostal().getRecepcionista().setLogin(false);
        }
    }

    public boolean isLoginRecepcionista() {
        return getHostal().getRecepcionista().isLogin();
    }

    public void cambiarLoginRecepcionista() {
        if(getHostal().getRecepcionista().isLogin()){
            getHostal().getRecepcionista().setLogin(false);
        }else{
            getHostal().getRecepcionista().setLogin(true);
        }
    }

    public ArrayList<Habitacion> obtenerListaHabitaciones() {
        return getHostal().getListaHabitacion();
    }

    public void cambiarEstadoHabitacion(String idHabitacion, Estado estadoNuevo, TipoCama tipoCama) {
        getHostal().cambiarEstadoHabitacion(idHabitacion, estadoNuevo, tipoCama);
    }

    public ArrayList<Cama> obtenerListaCamas() {
        return getHostal().getListaCamas();
    }

    public void cambiarEstadoCama(String idCama, Estado estadoNuevo, TipoCama tipoCama) {
        getHostal().cambiarEstadoCama(idCama, estadoNuevo, tipoCama);
    }

    public void cambiarTipoCama(String idHabitacion, TipoCama tipoCama) {
        getHostal().cambiarTipoCama(idHabitacion, tipoCama);
    }

    public ArrayList<Cliente> obtenerlistaClientes() {
        return  getHostal().getListaClientes();
    }

    public Cliente obtenerCLienteByDocumento(String documento) {
        return getHostal().obtenerCLienteByDocumento(documento);
    }

    public void crearReserva(String idReserva, String cantidadPersonas, String idCliente, String idHabitacion, LocalDate fechaReserva, LocalDate fehcaInicio, LocalDate fechaFin, String precioReserva) {
        getHostal().crearReserva(idReserva, cantidadPersonas, idCliente, idHabitacion, fechaReserva, fehcaInicio, fechaFin, precioReserva);
    }

    public ArrayList<Reserva> obtenerReservas() {
        return getHostal().obtenerReservas();
    }

    public ArrayList<String> obtenerIdClientes() {
        ArrayList<String> ids = new ArrayList<>();
        for (Cliente c:getHostal().getListaClientes()
             ) {
            ids.add(c.getDocumento());
        }
        return ids;
    }

    public ArrayList<String> obtenerIdsHabitacionesCamas() {
        ArrayList<String> ids = new ArrayList<>();

        for (Cama c:getHostal().getListaCamas()
        ) {
            ids.add(c.getId());
        }
        for (Habitacion c:getHostal().getListaHabitacion()
        ) {
            ids.add(c.getId());
        }

        return ids;
    }


    private static class SingletonHolder {
        // El constructor de Singleton puede ser llamado desde aquí al ser protected
        private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
    }
    public static ModelFactoryController getInstance() {
        return SingletonHolder.eINSTANCE;
    }
    public ModelFactoryController() {

        inicializarDatos();
        //4. Guardar y Cargar el recurso serializable XML
	     guardarResourceXML();
        //cargarResourceXML();

        //Siempre se debe verificar si la raiz del recurso es null

        if(hostal == null){
            inicializarDatos();
            guardarResourceXML();
        }
        //registrarAccionesSistema("Datos cargados", 1, "Cargar datos");
        //inicializarDatos();
    }
    public void guardarRespaldosArchivos(){
        Persistencia.copiarArchivoRespaldoXml();

    }
    public void guardarDatosArchivos() throws IOException {


        Persistencia.guardarRecursoMarketplaceXML(hostal);


    }
    public void inicializarDatos() {

        hostal = new Hostal();

        for(int i= 0; i<19;i++){
            Cama cama = new Cama(String.valueOf(i+1), TipoCama.CAMASDOBLES, Estado.OPERACION);
            hostal.getListaCamas().add(cama);
        }

        for(int i= 20; i<39;i++){
            Habitacion habitacion = new Habitacion(String.valueOf(i+1), true, "312", true, true, true, Estado.OPERACION);
            habitacion.setTipoCama(TipoCama.CAMASINDIVIDUALES);
            hostal.getListaHabitacion().add(habitacion);
        }
        Cliente cliente = new Cliente("Erik", "111", "312", "er@", "vereda", new Usuario("111", "111"));
        hostal.getListaClientes().add(cliente);


        registrarAccionesSistema("incio sesion", 1, "inicializar Datos");



    }

    private void cargarResourceXML(){
        hostal = Persistencia.cargarRecursoMarketplaceXML();
    }
    private void guardarResourceXML() {
        Persistencia.guardarRecursoMarketplaceXML(hostal);

    }

    public void registrarAccionesSistema(String mensaje, int nivel, String accion) {
        Persistencia.guardaRegistroLog(mensaje, nivel, accion);
    }

    public boolean verificarLogin(String usuario, String contrasenia) {
        return this.getHostal().verificarLogin(usuario, contrasenia);
    }
    public Cliente loginCliente(String nombre) throws ClienteNoExiste {
        return this.getHostal().obtenerClienteLogin(nombre);
    }
    public Cliente loginRecepcionista(String nombre)  {
        return this.getHostal().obtenerRecepcionista(nombre);
    }


    void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {

        Alert alerta = new Alert(alertType);
        alerta.setTitle(titulo);
        alerta.setHeaderText(header);
        alerta.setContentText(contenido);
        alerta.showAndWait();

    }




}
