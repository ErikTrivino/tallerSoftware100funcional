package uniquindio.edu.co.trabajosoftware.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import uniquindio.edu.co.trabajosoftware.crud.CrudCamaViewController;
import uniquindio.edu.co.trabajosoftware.crud.CrudClienteViewController;
import uniquindio.edu.co.trabajosoftware.crud.CrudHabitacionViewController;
import uniquindio.edu.co.trabajosoftware.crud.CrudRecepcionistaViewController;
import uniquindio.edu.co.trabajosoftware.exceptions.ClienteNoExiste;
import uniquindio.edu.co.trabajosoftware.exceptions.DatosNulosException;
import uniquindio.edu.co.trabajosoftware.exceptions.ErrorCargarDatos;
import uniquindio.edu.co.trabajosoftware.modelo.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;

import static javafx.scene.control.Alert.AlertType.*;

/*
*     private boolean datosValidos(String nombre, String apellido, String cedula, String usuario,
                                 String contrasenia) {

        String mensaje = "";

        if (nombre == null || nombre.equals("") || nombre.isEmpty()) {
            mensaje += "El nombre es invalido";
        }
        if (apellido == null || apellido.equals("") || apellido.isEmpty()) {
            mensaje += "El apellido es invalido";
        }
        if (cedula == null || cedula.equals("") || cedula.isEmpty()) {
            mensaje += "El documento es invalido";
        }
        if (usuario == null || usuario.equals("") || usuario.isEmpty()) {
            mensaje += "el usuario es invalido";
        }
        if (contrasenia == null || contrasenia.equals("") || contrasenia.isEmpty()) {
            mensaje += "la contrasenia es invalido";
        }
        try {
            if (modelFactoryController.verificarVendedorExistente(cedula) && vendedorSeleccionado == null) {
                mensaje += "Ya existe un vendedor con  documento";
            }
        } catch (Exception e) {
            modelFactoryController.registrarAccionesSistema(e.getMessage(), 2, "Insertar datos");
        }


        if (contrasenia.length() > 5) {
            mensaje += "la contrasenia debe tener 5 caracteres o menos";
        }
        if (mensaje.equals("")) {
            return true;
        }

        modelFactoryController.registrarAccionesSistema("Datos invalidos", 2, "Insertar datos");
        modelFactoryController.mostrarMensaje("Notificacion Vendedor", "Datos Invalidos", mensaje, Alert.AlertType.WARNING);

        return false;
    }
    private boolean mostrarMensajeConfirmacion(String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("Confirmacion");
        alerta.setContentText(mensaje);
        Optional<ButtonType> action = alerta.showAndWait();
        if (action.get() == ButtonType.OK) {
            return true;
        }
        return false;
    }*/
public class HostalViewController {

    public ComboBox<String> combo_tipoCama_GestionHabitación;
    public TableColumn <Habitacion, String>colnumeroHabTabla_gestionHabitacion;
    public TableColumn <Habitacion, String> coltipoCamaTabla_gestionHabitacion;
    public TableColumn <Habitacion, String>colTipoEsatdoTabla_gestionHabitacion;
    public ComboBox<String> estadoCama_GestionCama;
    ModelFactoryController modelFactoryController;
    CrudClienteViewController crudClienteViewController;
    CrudRecepcionistaViewController crudRecepcionistaViewController;
    CrudCamaViewController crudCamaViewController;
    CrudHabitacionViewController crudHabitacionViewController;
    ObservableList<String> estados = FXCollections.observableArrayList("Operacion", "Mantenimiento");
    ObservableList<String> tipoCamas = FXCollections.observableArrayList("Cama doble", "Camas sencillas");
    ObservableList<String> idsClientes;
    ObservableList<String> idsHabitacionesCamas;




    Cliente clienteSeleccionado;
    Habitacion habitacionSeleccionado;
    Cama camaSeleccionado;
    Reserva reservaSeleccionada;
    @FXML
    private ComboBox<String> TipoHabi_cbBox_GestionHabitación;

    @FXML
    private Button btnActualizar_GestionCama;

    @FXML
    private Button btnActualizar_GestionHabitacion;

    @FXML
    private Button btnPagar_Reserva;

    @FXML
    private Button btnReservar_Reserva;

    @FXML
    private Button btn_ActualizarCliente;

    @FXML
    private Button btn_BuscarCliente;

    @FXML
    private Button btn_regitrarCliente;

    @FXML
    private TableColumn<?, ?> camasExtrasTabla_gestionHabitacion;

    @FXML
    private TextField camasExtras_GestionHabitación;

    @FXML
    private TableColumn<?, ?> cantPersonasTabla_Reserva;

    @FXML
    private TextField cantPersonas_Reserva;


    @FXML
    private TableColumn<?, ?> disponibilidadTabla_gestionHabitacion;



    @FXML
    private TextField documento_GestionHabitación;

    @FXML
    private TableColumn<Cama, String> estadoCamaTabla_GestionCama;

   

    @FXML
    private TableColumn<?, ?> fechaFinTabla_Reserva;

    @FXML
    private DatePicker fechaFin_Reserva;

    @FXML
    private TableColumn<?, ?> fechaInicioTabla_Reserva;

    @FXML
    private DatePicker fechaInicio_Reserva;

    @FXML
    private TableColumn<?, ?> fechaReservaTabla_Reserva;

    @FXML
    private DatePicker fechaReserva_Reserva;

    @FXML
    private TableColumn<Cama, String> idCamaTabla_GestionCama;

    @FXML
    private TextField idCama_GestionCama;

    @FXML
    private TableColumn<?, ?> idClienteTabla_Reserva;

    @FXML
    private ComboBox<String> idClientecbBox_Reserva;

    @FXML
    private TableColumn<?, ?> idHabitacionTabla_Reserva;

    @FXML
    private ComboBox<String> idHabitacionbBox_Reserva;

    @FXML
    private TableColumn<Reserva, String> idReservaTabla_Reserva;

    @FXML
    private TextField idReserva_Reserva;




    @FXML
    private TextField numeroHabitacion_GestionHabitación;

    @FXML
    private TableColumn<?, ?> precioTabla_Reserva;

    @FXML
    private TextField precio_Reserva;

    @FXML
    private TableView<Cama> tabla_GestionCama;

    @FXML
    private TableView<Habitacion> tabla_GestionHabitación;





    @FXML
    private TableView<Reserva> tabla_Reservas;


    @FXML
    private ChoiceBox<String> tipoCamaCbBox_GestionCama;

    @FXML
    private TableColumn<Cama, String> tipoCamaTabla_GestionCama;

    @FXML
    private TableColumn<?, ?> tipoHabitacionTabla_gestionHabitacion;

    @FXML
    private TextField txt_contraseñaRegistroCliente;

    @FXML
    private TextField txt_correoRegistroCliente;

    @FXML
    private TextField txt_direccionRegistroCliente;

    @FXML
    private TextField txt_documentoRegistroCliente;

    @FXML
    private TextField txt_nombreRegistroCliente;

    @FXML
    private TextField txt_telefonoRegistroCliente;

    @FXML
    private TextField txt_usuarioRegistroCliente;

    @FXML
    private TableView<Cliente> tabla_Registro_clientes;
    @FXML
    private TableColumn<Cliente, String> documentoTabla_registroCliente;
    @FXML
    private TableColumn<Cliente, String> nombreTabla_registroCliente;

    @FXML
    private TableColumn<Cliente, String> direccionTabla_registroCliente;
    @FXML
    private TableColumn<Cliente, String> correoTabla_registroCliente;
    @FXML
    private TableColumn<Cliente, String> telefonoTabla_registroCliente;
    private ObservableList<Cliente> listadoClientes = FXCollections.observableArrayList();
    private ObservableList<Habitacion> listadoHabitaciones = FXCollections.observableArrayList();
    private ObservableList<Cama> listadoCamas = FXCollections.observableArrayList();
    private ObservableList<Reserva> listadoReserva = FXCollections.observableArrayList();


    @FXML
    void initialize(){
        modelFactoryController = ModelFactoryController.getInstance();
        crudClienteViewController = new CrudClienteViewController(modelFactoryController);
        crudRecepcionistaViewController = new CrudRecepcionistaViewController(modelFactoryController);
        crudCamaViewController = new CrudCamaViewController(modelFactoryController);
        crudHabitacionViewController = new CrudHabitacionViewController(modelFactoryController);
        idsClientes =  FXCollections.observableArrayList(obtenerIdClientes());
        idsHabitacionesCamas = FXCollections.observableArrayList(obtenerIdsHabitacionesCamas());
        this.documentoTabla_registroCliente.setCellValueFactory(new PropertyValueFactory<>("documento"));
        this.nombreTabla_registroCliente.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        this.correoTabla_registroCliente.setCellValueFactory(new PropertyValueFactory<>("email"));
        this.telefonoTabla_registroCliente.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        this.direccionTabla_registroCliente.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        tabla_Registro_clientes.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            //mostraInformacionvendedor(vendedorSeleccionado, usuarioSeleccionado);
            clienteSeleccionado = newSelection;
            mostraInformacionCliente(clienteSeleccionado);

        });
        this.colnumeroHabTabla_gestionHabitacion.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.colTipoEsatdoTabla_gestionHabitacion.setCellValueFactory(new PropertyValueFactory<>("estadoHabitacion"));
        this.coltipoCamaTabla_gestionHabitacion.setCellValueFactory(new PropertyValueFactory<>("tipoCama"));

        tabla_GestionHabitación.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            habitacionSeleccionado = newSelection;
            mostrarInfoHabitacion(habitacionSeleccionado);
        });

        tabla_GestionCama.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            camaSeleccionado = newSelection;
            mostrarInfoCama(camaSeleccionado);
        });
        this.idCamaTabla_GestionCama.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.tipoCamaTabla_GestionCama.setCellValueFactory(new PropertyValueFactory<>("tipoCama"));
        this.estadoCamaTabla_GestionCama.setCellValueFactory(new PropertyValueFactory<>("estadoCama"));



        tabla_Reservas.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            reservaSeleccionada = newSelection;
            mostrarInfoReserva(reservaSeleccionada);
        });

        this.idReservaTabla_Reserva.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.cantPersonasTabla_Reserva.setCellValueFactory(new PropertyValueFactory<>("cantidadPersonas"));
        this.idClienteTabla_Reserva.setCellValueFactory(new PropertyValueFactory<>("idCliente"));
        this.idHabitacionTabla_Reserva.setCellValueFactory(new PropertyValueFactory<>("idHabitacion"));
        this.fechaReservaTabla_Reserva.setCellValueFactory(new PropertyValueFactory<>("fechaReserva"));
        this.fechaInicioTabla_Reserva.setCellValueFactory(new PropertyValueFactory<>("fechaInicioReserva"));
        this.fechaFinTabla_Reserva.setCellValueFactory(new PropertyValueFactory<>("fechaFinReserva"));
        this.precioTabla_Reserva.setCellValueFactory(new PropertyValueFactory<>("precioReserva"));

        cargarListaCama();
        cargarListaHabitacion();
        cargarListadoClientes();
        cargarListaReservas();

    }

    private ArrayList<String> obtenerIdsHabitacionesCamas() {
        return modelFactoryController.obtenerIdsHabitacionesCamas();
    }

    private ArrayList<String> obtenerIdClientes() {
        return modelFactoryController.obtenerIdClientes();
    }
    private void cargarListaReservas() {
        listadoReserva.clear();
        tabla_Reservas.getItems().clear();
        tabla_Reservas.setItems(obtenerResercar());
    }

    private ObservableList<Reserva> obtenerResercar() {
        listadoReserva.addAll(modelFactoryController.obtenerReservas());
        return listadoReserva;
    }

    private void mostrarInfoReserva(Reserva reservaSeleccionada) {
        if(reservaSeleccionada != null){
            DateTimeFormatter formateador = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            idReserva_Reserva.setText(reservaSeleccionada.getId());
            cantPersonas_Reserva.setText(String.valueOf(reservaSeleccionada.getCantidadPersonas()));
            String idCliente = "1";
            String idHabitacion = "3";
            fechaReserva_Reserva.setValue(LocalDate.parse(reservaSeleccionada.getFechaReserva(), formateador));
            fechaInicio_Reserva.setValue(LocalDate.parse(reservaSeleccionada.getFechaInicioReserva(), formateador));
            fechaFin_Reserva.setValue(LocalDate.parse(reservaSeleccionada.getFechaFinReserva(), formateador));
            precio_Reserva.setText(Double.toString(reservaSeleccionada.getPrecioReserva()));


        }else{
            try {
                throw new DatosNulosException("Cama no existe");

            }catch (Exception e){
                modelFactoryController.registrarAccionesSistema(e.toString(), 2, "Datos nulos");
            }
        }
    }

    private void cargarListaCama() {
        listadoCamas.clear();
        tabla_GestionCama.getItems().clear();
        tabla_GestionCama.setItems(obtenerCamas());
    }

    private ObservableList<Cama> obtenerCamas() {
        listadoCamas.addAll(crudCamaViewController.obtenerListaCamas());
        return listadoCamas;
    }

    private void mostrarInfoCama(Cama camaSeleccionado) {
        if(camaSeleccionado != null){
            idCama_GestionCama.setText(camaSeleccionado.getId());
            estadoCama_GestionCama.setValue(transformarValorCombox(camaSeleccionado.getEstadoCama()));
            tipoCamaCbBox_GestionCama.setValue(transformarValorComboxTipoCama(camaSeleccionado.getTipoCama()));
        }else{
            try {
                throw new DatosNulosException("Cama no existe");

            }catch (Exception e){
                modelFactoryController.registrarAccionesSistema(e.toString(), 2, "Datos nulos");
            }
        }
    }

    private void cargarListaHabitacion() {
        listadoClientes.clear();
        tabla_GestionHabitación.getItems().clear();
        tabla_GestionHabitación.setItems(obtenerHabitaciones());

    }

    private ObservableList<Habitacion> obtenerHabitaciones() {
        listadoHabitaciones.addAll(crudHabitacionViewController.obtenerListaHabitaciones());
        return listadoHabitaciones;
    }

    private void mostrarInfoHabitacion(Habitacion habitacionSeleccionado) {
        if(habitacionSeleccionado != null){
            numeroHabitacion_GestionHabitación.setText(habitacionSeleccionado.getId());
            TipoHabi_cbBox_GestionHabitación.setValue(transformarValorCombox(habitacionSeleccionado.getEstadoHabitacion()));
            combo_tipoCama_GestionHabitación.setValue(transformarValorComboxTipoCama(habitacionSeleccionado.getTipoCama()));
        }else{
            try {
                throw new DatosNulosException("Habitacion no existe");

            }catch (Exception e){
                modelFactoryController.registrarAccionesSistema(e.toString(), 2, "Datos nulos");
            }
        }
    }

    private String transformarValorComboxTipoCama(TipoCama tipoCama) {
        switch (tipoCama){
            case CAMASDOBLES:
                return "Canas dobles";

            case CAMASINDIVIDUALES:
                return "Camas individuales";
            default:
                try {
                    throw new ErrorCargarDatos("Datos incorrectos");

                }catch (Exception e){
                    modelFactoryController.registrarAccionesSistema(e.toString(), 2, "Datos nulos");
                }
        }
        return "";
    }

    private String transformarValorCombox(Estado estadoHabitacion) {
        switch (estadoHabitacion){
            case MANTENIMIENTO:
                return "Mantenimiento";

            case OPERACION:
                return "Operacion";

            default:
                try {
                    throw new ErrorCargarDatos("Datos incorrectos");

                }catch (Exception e){
                    modelFactoryController.registrarAccionesSistema(e.toString(), 2, "Datos nulos");
                }
        }
        return "";
    }

    public void registrarCliente_TabCliente(ActionEvent actionEvent) {
        regitrarCliente();
    }

    private void regitrarCliente() {
        String nombre = txt_nombreRegistroCliente.getText();
        String documento = txt_documentoRegistroCliente.getText();
        String correo = txt_correoRegistroCliente.getText();
        String telefono = txt_telefonoRegistroCliente.getText();
        String direccion = txt_direccionRegistroCliente.getText();
        String usuario = txt_usuarioRegistroCliente.getText();
        String contrasenia = txt_contraseñaRegistroCliente.getText();

        if(datosValidos(nombre, direccion, contrasenia, correo, documento, telefono, usuario)){

            crudClienteViewController.crearCliente(new Cliente(nombre, documento, telefono, correo, direccion, new Usuario(usuario, contrasenia)));
            limpiarDatosTablaClientes();
            cargarListadoClientes();
        }else {
            try {
                throw new DatosNulosException("Datos nulos al agregar cliente");

            }catch (Exception e){
                modelFactoryController.registrarAccionesSistema(e.toString(), 2, "Datos nulos");
            }
        }
    }



    public void actualizarCliente_TabCliente(ActionEvent actionEvent) {
        actualizarCliente();
    }

    private void actualizarCliente() {
        String nombre = txt_nombreRegistroCliente.getText();
        String documento = txt_documentoRegistroCliente.getText();
        String correo = txt_correoRegistroCliente.getText();
        String telefono = txt_telefonoRegistroCliente.getText();
        String direccion = txt_direccionRegistroCliente.getText();
        String usuario = txt_usuarioRegistroCliente.getText();
        String contrasenia = txt_contraseñaRegistroCliente.getText();

        if (clienteSeleccionado != null) {
            if (datosValidos(nombre, direccion, contrasenia, correo, documento, telefono, usuario)) {


                //modelFactoryController.actualizarVendedor(nombre, apellido, cedula, usuario, contrasenia);
                crudClienteViewController.actualizarCliente(nombre, telefono, correo, direccion, new Usuario(usuario, contrasenia), clienteSeleccionado.getDocumento());
                //crudVendedorViewController.salvarDatos();

                //crudVendedorViewController.salvarDatos();
                modelFactoryController.mostrarMensaje("Notificacion Cliente", "Cliente Actualizado", "El cliente ha sido actualizado",
                        INFORMATION);

                modelFactoryController.registrarAccionesSistema("El cliente " + nombre + " actualizado", 1, "Actualizar cliente");
                limpiarDatosTablaClientes();
                cargarListadoClientes();
                tabla_Registro_clientes.refresh();

            } else {
                try {
                    throw new DatosNulosException("Datos nulos al agregar cliente");

                } catch (Exception e) {
                    modelFactoryController.registrarAccionesSistema(e.toString(), 2, "Datos nulos");
                }
            }
        } else {
            modelFactoryController.registrarAccionesSistema("El cliente no fue seleccionado", 2, "Seleccionar cliente");
            modelFactoryController.mostrarMensaje("Notificacion vendedor", "cliente no seleccionado",
                    "n", WARNING);

        }

    }
    private void cargarListadoClientes() {
        listadoClientes.clear();
        tabla_Registro_clientes.getItems().clear();
        tabla_Registro_clientes.setItems(obtenerClientes());

    }


    private ObservableList<Cliente> obtenerClientes() {
        listadoClientes.addAll(crudClienteViewController.obtenerClientes());
        return listadoClientes;
    }

    private void limpiarDatosTablaClientes() {
         txt_nombreRegistroCliente.setText("");
         txt_documentoRegistroCliente.setText("");
         txt_correoRegistroCliente.setText("");
         txt_telefonoRegistroCliente.setText("");
         txt_direccionRegistroCliente.setText("");
         txt_usuarioRegistroCliente.setText("");
         txt_contraseñaRegistroCliente.setText("");

    }

    private boolean datosValidos(String nombre, String direccion, String contrasenia, String correo, String documento, String telefono, String usuario) {
        String mensaje = "";

        if (nombre == null || nombre.equals("") || nombre.isEmpty()) {
            mensaje += "El nombre es invalido";
        }
        if (direccion == null || direccion.equals("") || direccion.isEmpty()) {
            mensaje += "La direccion es invalida";
        }
        if (contrasenia == null || contrasenia.equals("") || contrasenia.isEmpty()) {
            mensaje += "El contrasenia es invalido";
        }
        if(correo == null || correo.equals("") || correo.isEmpty()){
            mensaje+= "La correo es invalida";
        }

        if (documento == null || documento.equals("") || documento.isEmpty()) {
            mensaje += "La documento es invalida";
        }
        if (telefono == null || telefono.equals("") || telefono.isEmpty()) {
            mensaje += "La telefo  es invalido";
        }
        if (usuario == null || usuario.equals("") || usuario.isEmpty()) {
            mensaje += "El usuario  es invalido";
        }
        if (modelFactoryController.verificarClienteExistenteByDocumento(documento)) {
            mensaje += "Ya existe un cliente  con ese documento";



            modelFactoryController.registrarAccionesSistema("Cliente ya existe ", 2, "Datos nulos");
        }
        if (mensaje.equals("")) {
            return true;
        }
        modelFactoryController.mostrarMensaje("Notificacion Producto", "Datos Invalidos", mensaje, WARNING);

        return false;
    }

    public void buscarCliente_TabCliente(ActionEvent actionEvent) {
        buscarCliente();
    }

    private void buscarCliente() {
        String documento = txt_documentoRegistroCliente.getText();

        if(documento != null && documento != ""){
            Cliente cliente = crudClienteViewController.obtenerCLienteByDocumento(documento);
            if(cliente == null){
                try {
                    throw new ClienteNoExiste("Cliente no existe");

                } catch (Exception e) {
                    modelFactoryController.registrarAccionesSistema(e.toString(), 2, "Cliente no existe");
                }
            }else{

                mostraInformacionCliente(cliente);
            }
        }

    }
    private void mostraInformacionCliente(Cliente cliente) {

        if (cliente != null) {
            txt_nombreRegistroCliente.setText(cliente.getNombre());
            txt_documentoRegistroCliente.setText(cliente.getDocumento());
            txt_correoRegistroCliente.setText(cliente.getEmail());
            txt_telefonoRegistroCliente.setText(cliente.getTelefono());
            txt_direccionRegistroCliente.setText(cliente.getDireccion());
            txt_usuarioRegistroCliente.setText(cliente.getUsuario().getNombreUsuario());

            txt_contraseñaRegistroCliente.setText(cliente.getUsuario().getContrasenia());
        }else{
            //errror
            try {
                throw new DatosNulosException("Cliente no existe");

            }catch (Exception e){
                modelFactoryController.registrarAccionesSistema(e.toString(), 2, "Datos nulos");
            }
        }
    }

    public void listaEstado(Event event) {
        llenarCombo(TipoHabi_cbBox_GestionHabitación, estados);

    }
    public void listadoTipoCama(Event event) {
        llenarComboTipoCama(combo_tipoCama_GestionHabitación, tipoCamas);
    }
    public void listadoIdHabiCmas(){
        llenarComboCamasHabi(idHabitacionbBox_Reserva, idsHabitacionesCamas);

    }

    private void llenarComboCamasHabi(ComboBox<String> idHabitacionbBox_reserva, ObservableList<String> idsHabitacionesCamas) {
        idHabitacionbBox_reserva.setItems(idsHabitacionesCamas);
    }

    public void listadoIdsClientes(){
        llenarComboIdsClientes(idClientecbBox_Reserva, idsClientes);
    }

    private void llenarComboIdsClientes(ComboBox<String> idClientecbBox_reserva, ObservableList<String> idsClientes) {
        idClientecbBox_Reserva.setItems(idsClientes);
    }

    private void llenarComboTipoCama(ComboBox<String> combo_tipoCama_gestionHabitación, ObservableList<String> tipoCamas) {
        combo_tipoCama_gestionHabitación.setItems(tipoCamas);
        tipoCamaCbBox_GestionCama.setItems(tipoCamas);
    }

    private void llenarCombo(ComboBox<String> tipoHabi_cbBox_gestionHabitación, ObservableList<String> estados) {
        tipoHabi_cbBox_gestionHabitación.setItems(estados);
        estadoCama_GestionCama.setItems(estados);
    }


    public void actualizar_TabGestionHabitacion(ActionEvent actionEvent) {
        if(habitacionSeleccionado != null){
            String numeroHabitacion = numeroHabitacion_GestionHabitación.getText();
            //String disponible = numeroHabitacion_GestionHabitación.getText();
            Estado tipoEstado = determinarEstado(TipoHabi_cbBox_GestionHabitación.getValue());
            TipoCama tipoCama = determinarTipoCama(combo_tipoCama_GestionHabitación.getValue());

            crudHabitacionViewController.cambiarEstadoHabitacion(numeroHabitacion, tipoEstado, tipoCama);
            cargarListaHabitacion();
            limpiarDatosTablaHabitacion();
        }
    }
    public void actualizar_Cama(ActionEvent actionEvent) {
        if(camaSeleccionado != null){
            String numeroHabitacion = idCama_GestionCama.getText();
            //String disponible = numeroHabitacion_GestionHabitación.getText();
            Estado tipoEstado = determinarEstado(estadoCama_GestionCama.getValue());
            TipoCama tipoCama = determinarTipoCama(tipoCamaCbBox_GestionCama.getValue());
            crudCamaViewController.cambiarEstadoCama(numeroHabitacion, tipoEstado, tipoCama);
            cargarListaCama();
            limpiarDatosTablaCama();
        }
    }
    private void limpiarDatosTablaCama() {
        idCama_GestionCama.setText("");
        estadoCama_GestionCama.setValue("");
        tipoCamaCbBox_GestionCama.setValue("");
    }


    private void limpiarDatosTablaHabitacion() {
        numeroHabitacion_GestionHabitación.setText("");
        TipoHabi_cbBox_GestionHabitación.setValue("");
        combo_tipoCama_GestionHabitación.setValue("");
    }

    private TipoCama determinarTipoCama(String tipoCama) {
        switch (tipoCama){
            case "Cama doble":
                return  TipoCama.CAMASDOBLES;


            case"Camas sencillas":
                return TipoCama.CAMASINDIVIDUALES;

            default:
                try {
                    throw new ErrorCargarDatos("Datos incorrectos");

                }catch (Exception e){
                    modelFactoryController.registrarAccionesSistema(e.toString(), 2, "Datos nulos");
                }

        }

        return null;
    }

    private Estado determinarEstado(String tipoEstado) {
        switch (tipoEstado){
            case "Operacion":
                return Estado.OPERACION;


            case"Mantenimiento":
                return Estado.MANTENIMIENTO;


            default:
                try {
                    throw new ErrorCargarDatos("Datos incorrectos");

                }catch (Exception e){
                    modelFactoryController.registrarAccionesSistema(e.toString(), 2, "Datos nulos");
                }

        }

        return null;
    }

    public void reservar_TabReserva(ActionEvent actionEvent) {
        String idReserva = idReserva_Reserva.getText();
        String cantidadPersonas = cantPersonas_Reserva.getText();
        String idCliente = idClientecbBox_Reserva.getValue();
        String idHabitacion = idHabitacionbBox_Reserva.getValue();
        LocalDate fechaReserva = fechaReserva_Reserva.getValue();
        LocalDate fehcaInicio = fechaInicio_Reserva.getValue();
        LocalDate fechaFin =  fechaFin_Reserva.getValue();
        String precioReserva = precio_Reserva.getText();

        if(datosValidosReserva(idReserva, cantidadPersonas, idCliente, idHabitacion, fechaReserva, fehcaInicio, fechaFin, precioReserva)){
            modelFactoryController.crearReserva(idReserva, cantidadPersonas, idCliente, idHabitacion, fechaReserva, fehcaInicio, fechaFin, precioReserva);
        }
        limpiarDatosReserva();
        cargarListaReservas();



    }

    private void limpiarDatosReserva() {
         idReserva_Reserva.setText("");
        cantPersonas_Reserva.setText("");
        idClientecbBox_Reserva.setValue("");
        idHabitacionbBox_Reserva.setValue("");
        fechaReserva_Reserva.setValue(null);
        fechaInicio_Reserva.setValue(null);
        fechaFin_Reserva.setValue(null);
        precio_Reserva.setText("");
    }

    private boolean datosValidosReserva(String idReserva, String cantidadPersonas, String idCliente, String idHabitacion, LocalDate fechaReserva, LocalDate fehcaInicio, LocalDate fechaFin, String precioReserva) {
        String mensaje = "";

        if (idReserva == null || idReserva.equals("") || idReserva.isEmpty()) {
            mensaje += "El nombre es invalido";
        }
        if (cantidadPersonas == null || cantidadPersonas.equals("") || cantidadPersonas.isEmpty()) {
            mensaje += "La direccion es invalida";
        }
        if (idCliente == null || idCliente.equals("") || idCliente.isEmpty()) {
            mensaje += "El contrasenia es invalido";
        }
        if(idHabitacion == null || idHabitacion.equals("") || idHabitacion.isEmpty()){
            mensaje+= "La correo es invalida";
        }

        if (fechaReserva == null ) {
            mensaje += "La documento es invalida";
        }
        if (fechaFin == null ) {
            mensaje += "La telefo  es invalido";
        }
        if (fechaFin == null) {
            mensaje += "El usuario  es invalido";
        }

        if (mensaje.equals("")) {
            return true;
        }
        modelFactoryController.mostrarMensaje("Notificacion Producto", "Datos Invalidos", mensaje, WARNING);

        return false;
    }

    public void pagar_TabReserva(ActionEvent actionEvent) {
        showPaymentOptionsDialog();
    }

    private void showPaymentOptionsDialog() {
        Dialog<ButtonType> paymentOptionsDialog = new Dialog<>();
        paymentOptionsDialog.initModality(Modality.APPLICATION_MODAL);
        paymentOptionsDialog.setTitle("Opciones de Pago");
        paymentOptionsDialog.setHeaderText("Selecciona una opción de pago:");

        ButtonType cashButton = new ButtonType("Pagar en Efectivo", ButtonType.OK.getButtonData());
        ButtonType cardButton = new ButtonType("Pagar con Tarjeta", ButtonType.OK.getButtonData());

        paymentOptionsDialog.getDialogPane().getButtonTypes().addAll(cashButton, cardButton);

        paymentOptionsDialog.showAndWait().ifPresent(response -> {
            if (response == cashButton) {
                showAlert("Pago en efectivo seleccionado, pago exitoso", AlertType.INFORMATION);
                // Aquí puedes agregar la lógica para el pago en efectivo
            } else if (response == cardButton) {
                showAlert("Pago con tarjeta seleccionado,pago exitoso.", AlertType.INFORMATION);
                // Aquí puedes agregar la lógica para el pago con tarjeta
            }
        });
    }
    private void showAlert(String message, AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle("Mensaje");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


    public void actualizar_TabReserva(ActionEvent actionEvent) {
    }


    public void limpiarCamposClientes(ActionEvent actionEvent) {
        limpiarDatosTablaClientes();
    }

    public void limpiarCamposReserva(ActionEvent actionEvent) {
        limpiarDatosReserva();
    }
}
