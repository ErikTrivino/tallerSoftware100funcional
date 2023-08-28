package uniquindio.edu.co.trabajosoftware.controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import uniquindio.edu.co.trabajosoftware.crud.CrudClienteViewController;
import uniquindio.edu.co.trabajosoftware.crud.CrudRecepcionistaViewController;
import uniquindio.edu.co.trabajosoftware.exceptions.AccesoNoAutorizadoException;
import uniquindio.edu.co.trabajosoftware.modelo.Cliente;

import java.io.IOException;


public class LoginViewController {
    ModelFactoryController modelFactoryController = ModelFactoryController.getInstance();
    CrudClienteViewController crudClienteViewController = new CrudClienteViewController(modelFactoryController);
    CrudRecepcionistaViewController crudRecepcionistaViewController = new CrudRecepcionistaViewController(modelFactoryController);

    public void setModelFactoryController(ModelFactoryController modelFactoryController) {
        this.modelFactoryController = modelFactoryController;
    }

    @FXML
    private TextField txtUsuario_loginView;
    @FXML
    private TextField txtContraseña_loginView;

    @FXML
    private Button btnCancelar;

    @FXML
    void btnCancelar_loginView(ActionEvent event) {
        salir();
    }

    public void salir() {

        Stage stage = (Stage) this.btnCancelar.getScene().getWindow();
        stage.close();
    }

    public void mostrarPestaniaPrincipal(ActionEvent event){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/uniquindio/edu/co/trabajosoftware/hostalView.fxml"));


        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }
    @FXML
    void btnIngresar_loginView(ActionEvent actionEvent) throws Exception {
        String usuario=txtUsuario_loginView.getText();
        String contrasenia=txtContraseña_loginView.getText();


        if (!(usuario.equals("") && contrasenia.equals(""))){

            crudRecepcionistaViewController.verificarLoginRecepcionista(usuario,contrasenia);


            if(crudRecepcionistaViewController.isLoginRecepcionista()){
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/uniquindio/edu/co/trabajosoftware/hostalView.fxml"));


                crudRecepcionistaViewController.cambiarEstadoLoginRecepcionista();

                //System.out.println(modelFactoryController.getMarketPlace().getAdmin().isLogin());

                mostrarPestaniaPrincipal(actionEvent);


            }else{
//                if(crudVendedorViewController.verificarVendedorExistente(usuario)){

               //crudVendedorViewController.verficarLogin(usuario,contrasenia);

                    if(crudClienteViewController.verificarLoginCliente(usuario,contrasenia)){
                        Cliente clienteLogin = crudClienteViewController.obtenerCliente(usuario);

                        crudClienteViewController.asignarClienteActualModelFactory(clienteLogin);
                        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource("/uniquindio/edu/co/trabajosoftware/hostalView.fxml"));

                        Parent root = loader.load();

                        modelFactoryController.registrarAccionesSistema("El usuario " +usuario, 1, " Ingreso Login");
                        mostrarPestaniaPrincipal(actionEvent);

                    }else{
                        mostrarMensaje("Datos incorrectos", null, "Asegurese de introducir  los datos de su usuario",
                                Alert.AlertType.ERROR );
                        try {
                            throw new AccesoNoAutorizadoException("El acceso no fue autorizado");
                        }catch (AccesoNoAutorizadoException e){
                            e.printStackTrace();
                            modelFactoryController.registrarAccionesSistema(e.toString(), 3, "Ingreso Login");
                        }

                    }


            }


        }
        else {
            mostrarMensaje("Datos de acceso incompletos", null, "Asegurese de introducir todos los datos",
                    Alert.AlertType.ERROR);
            try {
                throw new AccesoNoAutorizadoException("El acceso no fue autorizado");
            }catch (AccesoNoAutorizadoException e){
                e.printStackTrace();
                modelFactoryController.registrarAccionesSistema(e.toString(), 3, "Ingreso Login");
            }

        }


    }

    private void mostrarMensaje(String titulo, String head, String content, Alert.AlertType tipo) {
        Alert alerta = new Alert(null);
        alerta.setTitle(titulo);
        alerta.setHeaderText(head);
        alerta.setContentText(content);
        alerta.setAlertType(tipo);
        alerta.show();
    }



}
