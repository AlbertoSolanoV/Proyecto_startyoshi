package solano.alberto.logic;

import solano.alberto.bl.direccion.*;
import solano.alberto.bl.pedido.PedidoDAO;
import solano.alberto.bl.servicio.Servicio;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.TreeMap;

public class gestorPedido {

    PedidoDAO objPedido = new PedidoDAO();
    DireccionDAO objDireccionDAO = new DireccionDAO();


    public String registrarPedido(String identificacion, String correo, ArrayList<TreeMap<String, String>> servicios,
                                  String provincia, String canton, String distrito, String direccion, String numeroTarjeta) throws Exception {
        try {
            int cod;
            String mensaje = "";

            Direccion objDireccion = registrarDireccion(provincia, canton, distrito, direccion);
            ArrayList<TreeMap<String, String>> listaServicio = servicios;
            cod = objPedido.registrarPedido(objDireccion, correo, identificacion, numeroTarjeta);

            for (TreeMap<String, String> servicio : listaServicio) {

                Servicio objServicio = new Servicio("cod", servicio.get("descripcion"), 0.0, servicio.get("tipo"), false);
                mensaje = objPedido.registrarPedidoServicio(cod, objServicio);
            }

            return mensaje;
        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }

    }

    public String cambioEstado(String estado, int codPedido) throws Exception {
        try{
            return objPedido.cambioEstadoPedido(estado, codPedido);


        }catch (Exception e){
            throw e;
        }
    }

    public String cambioEstadoConductorPedido(String correo, int codPedido) throws Exception {
        try{
            return objPedido.registrarPedidoConductor(codPedido, correo);


        }catch (Exception e){
            throw e;
        }
    }

    public String cambioEstadoConductor(String estado, int codPedido) throws Exception {
        try{
            return objPedido.cambioEstadoPedido(estado, codPedido);


        }catch (Exception e){
            throw e;
        }
    }

    public ArrayList<TreeMap<String, String>> imprimirPedido() throws Exception {

        try {
            ArrayList<TreeMap<String, String>> Servicios = objPedido.obtenerPedido();

            return Servicios;

        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }

    }

    public ArrayList<TreeMap<String, String>> imprimirPedidoCliente(String identificacion) throws Exception {

        try {
            ArrayList<TreeMap<String, String>> Servicios = objPedido.obtenerPedidoCliente(identificacion);

            return Servicios;

        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }

    }

    public ArrayList<TreeMap<String, String>> imprimirPedidoConductor(String identificacion) throws Exception {

        try {
            ArrayList<TreeMap<String, String>> Servicios = objPedido.obtenerPedidoConductor(identificacion);

            return Servicios;

        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }

    }

    public Direccion registrarDireccion(String provincia, String canton, String distrito, String direccionExacta) {
        try {

            Provincia objProvincia = objDireccionDAO.devolverProvinciaObj(provincia);
            Canton objCanton = objDireccionDAO.devolverCantonObj(canton, objProvincia.getCodigo());
            Distrito objDistrito = objDireccionDAO.devolverDistritoObj(distrito, objCanton.getCodigo());

            Direccion objDireccion = new Direccion(objProvincia, objCanton, objDistrito, direccionExacta);
            return objDireccion;
        } catch (Exception e) {
            return null;
        }
    }

}
