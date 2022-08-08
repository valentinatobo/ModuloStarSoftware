package vista;

import javax.swing.*;
import java.io.*;
import java.sql.*;
import java.awt.Panel.*;
import java.awt.*;
import java.awt.event.*;
import presentacion.Controlador;

public class VentanaRegistro extends JFrame {

    private Controlador miControlador;
    private JTextField txtUser, txtPass;
    private JLabel lblUser, lblPass;
    private JButton btnAceptar, btnCancelar;
    String usuario, elPassword;

    public VentanaRegistro(Controlador miControlador) {
        System.out.println("VENTANA REGISTRO");
        this.miControlador = miControlador;
        
        
        Container contenedor = getContentPane();
        contenedor.setLayout(new FlowLayout());

        // crear etiqueta y cuadro de texxto del usuario
        txtUser = new JTextField(10);
        lblUser = new JLabel("Usuario: ");
        txtUser.setToolTipText("Escriba su nombre de usuario");
        contenedor.add(Box.createVerticalStrut(50));
        contenedor.add(lblUser);
        contenedor.add(txtUser);

        //crear etiqueta y cuadro de texxto del pw
        txtPass = new JPasswordField(10);
        lblPass = new JLabel("Contraseña: ");
        txtPass.setToolTipText("Escriba su contraseña");
        contenedor.add(lblPass);
        contenedor.add(txtPass);

        //Crear y agregar los botones 
        btnAceptar = new JButton("Aceptar");
        //establecer Boton aceptar por defecto
        getRootPane().setDefaultButton(btnAceptar);

        btnCancelar = new JButton("Cancelar");
        contenedor.add(btnAceptar);
        contenedor.add(btnCancelar);


        setTitle("Registro de usuarios");
        setSize(400, 150);           // Tamanio del Frame 
        setResizable(false);       // que no se le pueda cambiar el tamanio 
        //Centrar la ventana de autentificacion en la pantalla
        Dimension tamFrame = this.getSize();//para obtener las dimensiones del frame
        Dimension tamPantalla = Toolkit.getDefaultToolkit().getScreenSize();      //para obtener el tamanio de la pantalla
        setLocation((tamPantalla.width - tamFrame.width) / 2, (tamPantalla.height - tamFrame.height) / 2);  //para posicionar
        //setVisible(true);           // Hacer visible al frame 
        
        
        btnAceptar.addActionListener(this.miControlador);      // Asociar escuchador para el boton Aceptar
        btnCancelar.addActionListener(this.miControlador);
    }   // fin de constructor

    public JTextField getTxtUser() {
        return txtUser;
    }

    public void setTxtUser(JTextField txtUser) {
        this.txtUser = txtUser;
    }

    public JTextField getTxtPass() {
        return txtPass;
    }

    public void setTxtPass(JTextField txtPass) {
        this.txtPass = txtPass;
    }

    public JButton getBtnAceptar() {
        return btnAceptar;
    }

    public void setBtnAceptar(JButton btnAceptar) {
        this.btnAceptar = btnAceptar;
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }

    public void setBtnCancelar(JButton btnCancelar) {
        this.btnCancelar = btnCancelar;
    }

}
