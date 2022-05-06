package solano.alberto.bl.usuario;

import solano.alberto.bl.direccion.Canton;
import solano.alberto.bl.direccion.Distrito;
import solano.alberto.bl.direccion.Provincia;
import solano.alberto.bl.direccion.Direccion;

import java.sql.*;

public class UsuarioDAO {

    private Connection inicializarBaseDatos() throws Exception {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = null;
            String strConneccion = "jdbc:sqlserver://DESKTOP-FMDDBT7:1433;DatabaseName=proyectoProgra;user=sa;password=1234;";
            conn = DriverManager.getConnection(strConneccion);
            return conn;
        } catch (Exception e) {
            throw new Exception("Error en inicializar la conexion con la base de datos" + e);
        }
    }

    public String registrarAdministrador(Usuario objUsuario) throws Exception {
        try {
            Connection conn = inicializarBaseDatos();
            Direccion objDireccion = objUsuario.getDireccion();
            Provincia objProvincia = objUsuario.getDireccion().getProvincia();
            Canton objCanton = objUsuario.getDireccion().getCanton();
            Distrito objDistrito = objUsuario.getDireccion().getDistrito();


            CallableStatement palmacenado = conn.prepareCall("{call sp_registrar_administrador(?,?,?,?,?,?,?,?,?,?)}");

            palmacenado.setString(1, objProvincia.getNombre());
            palmacenado.setString(2, objCanton.getNombre());
            palmacenado.setString(3, objDistrito.getNombre());
            palmacenado.setString(4, objDireccion.getDireccionExacta());
            palmacenado.setString(5, objUsuario.getNombre());
            palmacenado.setString(6, objUsuario.getApellidos());
            palmacenado.setString(7, objUsuario.getIdentificacion());
            palmacenado.setString(8, objUsuario.getCorreo());
            palmacenado.setString(9, objUsuario.getClave());
            palmacenado.registerOutParameter(10, Types.VARCHAR);


            palmacenado.execute();
            String mensaje = palmacenado.getString(10);
            palmacenado.close();
            conn.close();
            return mensaje;
        } catch (Exception e) {
            throw new Exception("Error en registrar Cliente " + e);
        }
    }


    public String existeAdmin() throws Exception {

        try {
            Connection conn = inicializarBaseDatos();
            String mensaje = "";
            CallableStatement palmacenado = conn.prepareCall("{call sp_existe_admin(?)}");


            palmacenado.registerOutParameter(1, Types.VARCHAR);


            palmacenado.execute();

            if (palmacenado.getString(1).equals("0")) {
                mensaje = "No existe";
            } else {
                mensaje = "Existe";
            }

            palmacenado.close();
            conn.close();
            return mensaje;
        } catch (Exception e) {
            throw new Exception("Error en registrar Cliente " + e);
        }
    }

    public String validacionUsuarioLogin(String correo, String clave) throws Exception {

        try {
            Connection conn = inicializarBaseDatos();
            String mensaje = "";
            CallableStatement palmacenado = conn.prepareCall("{call login_user(?,?,?)}");

            palmacenado.setString(1, correo);
            palmacenado.setString(2, clave);
            palmacenado.registerOutParameter(3, Types.VARCHAR);


            palmacenado.execute();
            mensaje = palmacenado.getString(3);

            palmacenado.close();
            conn.close();
            return mensaje;
        } catch (Exception e) {
            throw new Exception("Error en registrar Cliente " + e);
        }
    }


}
