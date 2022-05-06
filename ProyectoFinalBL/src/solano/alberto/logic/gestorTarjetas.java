package solano.alberto.logic;

import solano.alberto.bl.servicio.Servicio;
import solano.alberto.bl.tarjeta.Tarjeta;
import solano.alberto.bl.tarjeta.TarjetaDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.TreeMap;

public class gestorTarjetas {

    TarjetaDAO objTarjetaDAO = new TarjetaDAO();

    public String registrarTarjeta(String correo, String id, String numero, String nombre, String fechaVence, String ccv) throws Exception {
        try {
            String mensaje = "";
            Tarjeta objTarjeta = new Tarjeta(nombre, numero, null, fechaVence, ccv);
            mensaje = objTarjetaDAO.registrarTarjeta(objTarjeta, correo, id);

            return mensaje;
        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }

    }

    public String eliminarTarjeta(String numero) throws Exception {
        try {
            String mensaje = "";
            mensaje = objTarjetaDAO.eliminarTarjeta(numero);

            return mensaje;
        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }

    }

    public ArrayList<TreeMap<String, String>> imprimirTarjetas(String id) throws Exception {

        try {
            ArrayList<TreeMap<String, String>> Tarjetas = new ArrayList<TreeMap<String, String>>();
            ArrayList<Tarjeta> listaTarjeta = objTarjetaDAO.obtenerTarjetas(id);

            for (Tarjeta objTarjeta : listaTarjeta) {
                TreeMap<String, String> mapa = new TreeMap<String, String>();

                mapa.put("Numero", objTarjeta.getNumeroTarjeta());
                mapa.put("Nombre", objTarjeta.getNombreTarjeta());
                mapa.put("Proveedor", objTarjeta.getProveedor());
                mapa.put("FechaVence", objTarjeta.getVencimiento());
                mapa.put("CCV", objTarjeta.getCcv());

                Tarjetas.add(mapa);
            }

            return Tarjetas;

        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }

    }




}
