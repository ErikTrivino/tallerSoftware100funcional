package uniquindio.edu.co.trabajosoftware.modelo;

import uniquindio.edu.co.trabajosoftware.services.IHostalService;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Optional;

public class Hostal implements IHostalService,Serializable {
    @Serial
    private static final long serialVersionUID = 1l;

    private ArrayList<Habitacion> listaHabitacion;
    private ArrayList<Cama> listaCamas;
    private ArrayList<Cliente> listaClientes;
    Recepcionista recepcionista;


    public Hostal() {
        listaCamas = new ArrayList<>();
        listaHabitacion = new ArrayList<>();
        listaClientes = new ArrayList<>();
        recepcionista = new Recepcionista("Franco", "1234", "3022", "fra@gmail.com", "cancun", new Usuario("1234", "1234"));

    }

    public ArrayList<Cama> getListaCamas() {
        return listaCamas;
    }

    public void setListaCamas(ArrayList<Cama> listaCamas) {
        this.listaCamas = listaCamas;
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public ArrayList<Habitacion> getListaHabitacion() {
        return listaHabitacion;
    }

    public void setListaHabitacion(ArrayList<Habitacion> listaHabitacion) {
        this.listaHabitacion = listaHabitacion;
    }

    public Recepcionista getRecepcionista() {
        return recepcionista;
    }

    public void setRecepcionista(Recepcionista recepcionista) {
        this.recepcionista = recepcionista;
    }



    public boolean verificarLogin(String usuario, String contrasenia) {
        Optional<Cliente> cliente = listaClientes.stream().filter(x -> x.getUsuario().getNombreUsuario().equals(usuario) && x.getUsuario().getContrasenia().equals(contrasenia)).findFirst();
        if(cliente.isPresent()){
            return true;
        }else {
            return false;
        }

    }

    public Cliente obtenerClienteLogin(String usuario) {
        Optional<Cliente> cliente = listaClientes.stream().filter(x -> x.getUsuario().getNombreUsuario().equals(usuario)).findFirst();

        if(cliente.isPresent()){
            return cliente.get();
        }else{
            return null;
        }

    }

    public Cliente obtenerRecepcionista(String nombre) {
        return null;
    }

    public boolean verificarLoginRecepcionista(String usuario, String contrasenia) {

        if(recepcionista.getUsuario().getNombreUsuario().equals(usuario) && recepcionista.getUsuario().getContrasenia().equals(contrasenia)){
            return true;
        }else {

            return false;
        }
    }

    public void cambiarEstadoHabitacion(String idHabitacion, Estado estadoNuevo, TipoCama tipoCama) {
       Habitacion h =  listaHabitacion.stream().filter(x -> x.getId().equals(idHabitacion)).findFirst().get();
       h.setEstadoHabitacion(estadoNuevo);
       h.setTipoCama(tipoCama);

    }

    public void cambiarEstadoCama(String idCama, Estado estadoNuevo, TipoCama tipoCama) {
       Cama c =  listaCamas.stream().filter(x -> x.getId().equals(idCama)).findFirst().get();
       c.setEstadoCama(estadoNuevo);
       c.setTipoCama(tipoCama);
    }

    public void cambiarTipoCama(String idHabitacion, TipoCama tipoCama) {
        listaCamas.stream().filter(x -> x.getId().equals(idHabitacion)).findFirst().get().setTipoCama(tipoCama);
    }

    @Override
    public void crearCliente(Cliente cliente) {
        listaClientes.add(cliente);
    }

    @Override
    public void actualizarCliente(String nombre, String telefono, String email, String direccion, Usuario usuario, String documento) {
        Cliente cliente = new Cliente(nombre, documento, telefono, email, direccion, usuario);
        int pos = buscarCliente(documento);
        listaClientes.remove(pos);
        listaClientes.add(cliente);

    }

    @Override
    public boolean eliminarCliente(String documento) {
        return false;
    }

    @Override
    public boolean verificarClienteExistenteByDocumento(String documento) {
        return false;
    }
    public  int buscarCliente( String documentoBuscado) {
        for (int i = 0; i < listaClientes.size(); i++) {
            Cliente cliente = listaClientes.get(i);
            if (cliente.getDocumento().equals(documentoBuscado)) {
                return i; // Retorna la posición del cliente encontrado
            }
        }
        return -1; // Retorna -1 si el cliente no fue encontrado
    }

    public Cliente obtenerCLienteByDocumento(String documento) {
        int pos = buscarCliente(documento);
        if(pos == -1){
            return null;
        }
        return listaClientes.get(pos);
    }

    public void crearReserva(String idReserva, String cantidadPersonas, String idCliente, String idHabitacion, LocalDate fechaReserva, LocalDate fehcaInicio, LocalDate fechaFin, String precioReserva) {
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        int posHa =buscarPorId(idHabitacion);
        int posCama = buscarPorIdCama(idHabitacion);
        if(posHa != -1){
            Habitacion h = listaHabitacion.get(posHa);
            h.getReservas().add(new Reserva(idReserva,fechaReserva.format(formateador), fehcaInicio.format(formateador), fechaFin.format(formateador), Integer.parseInt(cantidadPersonas), idCliente, idHabitacion, Double.parseDouble(precioReserva)));
        }else {

            Cama c = listaCamas.get(posCama);
            c.getListaReserva().add(new Reserva(idReserva,fechaReserva.format(formateador), fehcaInicio.format(formateador), fechaFin.format(formateador), Integer.parseInt(cantidadPersonas), idCliente, idHabitacion, Double.parseDouble(precioReserva)));
        }
    }

    private int buscarPorIdCama(String idHabitacion) {
        for (int i = 0; i < listaCamas.size(); i++) {
            if (listaCamas.get(i).getId().equals(idHabitacion)) {
                return i; // Devuelve la posición si se encuentra el ID
            }
        }
        return -1; // Devuelve -1 si no se encontró el ID

    }

    public  int buscarPorId( String idBuscado) {
        for (int i = 0; i < listaHabitacion.size(); i++) {
            if (listaHabitacion.get(i).getId().equals(idBuscado)) {
                return i; // Devuelve la posición si se encuentra el ID
            }
        }
        return -1; // Devuelve -1 si no se encontró el ID
    }

    public ArrayList<Reserva> obtenerReservas() {
        ArrayList<Reserva> r = new ArrayList<>();
        for (Cama c:listaCamas
             ) {
            r.addAll(c.getListaReserva());
        }
        for (Habitacion h:listaHabitacion
             ) {
            r.addAll(h.getReservas());
        }
        return r;
    }
}
