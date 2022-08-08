package presentacion;

import java.sql.*;
import models.Usuario;

public class Modelo {

    public Connection conectar() {
        String url = "jdbc:mysql://b5tz9fwfwwymzx1spxfk-mysql.services.clever-cloud.com:3306/b5tz9fwfwwymzx1spxfk";
        String user = "ufz2xtzhl1mpghks";
        String pass = "8J5PSV1NofwenZLTVq8K";
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, user, pass);
            System.out.println("Conectado!");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return con;
    }

    public boolean validarUsuario(Usuario u) {
        try {
            Connection conexion = conectar();
            Statement instruccionSQL = conexion.createStatement();
            ResultSet resultadosConsulta = instruccionSQL.executeQuery("SELECT * FROM Usuarios WHERE Usuario='" + u.getNombre() + "' AND Contraseña='" + u.getContra() + "'");

            if (resultadosConsulta.next()) { // si es valido el primer reg. hay una fila, tons el usuario y su pw existen
                return true;        //usuario validado correctamente
            } else {
                return false;        //usuario validado incorrectamente
            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
        return false;
    }

    public boolean insertarUsuario(Usuario usuario) {
        PreparedStatement miStatement = null;
        try {
            Connection conexion = conectar();

            String sql = "INSERT INTO Usuarios (Usuario, Contraseña) VALUES(?,?)";

            miStatement = conexion.prepareStatement(sql);

            miStatement.setString(1, usuario.getNombre());
            miStatement.setString(2, usuario.getContra());
            
            miStatement.execute();
            
            return true;

        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
        return false;
    }

}
