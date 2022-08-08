package presentacion;

import dao.UsuarioDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import vista.VentanaLogin;
import vista.VentanaRegistro;

public class Controlador implements ActionListener {

    private VentanaLogin vLogin;
    
    private VentanaRegistro vRegistro;

    private Modelo modelo;

    private UsuarioDao usuarioD;

    public Controlador() {
        vLogin = new VentanaLogin(this);
        vLogin.setDefaultCloseOperation(vLogin.EXIT_ON_CLOSE);

        vRegistro = new VentanaRegistro(this);
        vRegistro.setVisible(true);
        vRegistro.setDefaultCloseOperation(vLogin.EXIT_ON_CLOSE);
        
        
        modelo = new Modelo();
        usuarioD = new UsuarioDao(modelo);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        //LOGIN
        if (e.getSource() == vLogin.getBtnAceptar()) {
            if (vLogin.getTxtUser().getText().length() > 0 && vLogin.getTxtPass().getText().length() > 0) {
                // Si el usuario si fue validado correctamente
                if (validarUsuario(vLogin.getTxtUser().getText(), vLogin.getTxtPass().getText())) {
                    // Codigo para mostrar la ventana principal
                    System.out.println("USUARIO VALIDADO");
                } else {
                    System.out.println("ME LA PELAS");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Debe escribir nombre de usuario y contraseña.\n"
                        + "NO puede dejar ningun campo vacio");
            }
        } else if (e.getSource() == vLogin.getBtnCancelar()) {
            JOptionPane.showMessageDialog(null, "Has dado en cancelar");
            
        } 
        
        //REGISTRO
        else if (e.getSource() == vRegistro.getBtnAceptar()) {
            if (vRegistro.getTxtUser().getText().length() > 0 && vRegistro.getTxtPass().getText().length() > 0) {
                // Si el usuario si fue validado correctamente
                if (registrarUsuario(vRegistro.getTxtUser().getText(), vRegistro.getTxtPass().getText())) {
                    // Codigo para mostrar la ventana principal
                    System.out.println("USUARIO REGISTRADO");
                } else {
                    System.out.println("ME LA PELAS CON REGISTRO");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Debe escribir nombre de usuario y contraseña.\n"
                        + "NO puede dejar ningun campo vacio");
            }
        } else if (e.getSource() == vRegistro.getBtnCancelar()) {
            JOptionPane.showMessageDialog(null, "Has dado en cancelar");
            
        }

    }

    private boolean validarUsuario(String nombre, String contra) {
        return usuarioD.validar(nombre, contra);
    }
    
    private boolean registrarUsuario(String nombre, String contra){
        return usuarioD.insertar(nombre, contra);
    }

}
