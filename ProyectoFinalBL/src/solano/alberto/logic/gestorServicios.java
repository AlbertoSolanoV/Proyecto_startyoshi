package solano.alberto.logic;

import solano.alberto.bl.direccion.Provincia;
import solano.alberto.bl.servicio.Servicio;
import solano.alberto.bl.servicio.ServicioDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.TreeMap;

public class gestorServicios {

    ServicioDAO objServicioDAO = new ServicioDAO();

    public String registrarServicio(String tipo, String descripcion, double precioBase, double precioLitro, boolean estado) throws Exception {
        try {
            String mensaje = "";
            Servicio objServicio = new Servicio("COD", descripcion, precioBase, tipo, estado, precioLitro);
            mensaje = objServicioDAO.registrarServicio(objServicio);

            return mensaje;
        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }

    }

    public String modificarServicio(String tipo, String descripcion, boolean estado) throws Exception {
        try {
            String mensaje = "";
            mensaje = objServicioDAO.modificarServicio(tipo, descripcion, estado);

            return mensaje;
        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }

    }

    public ArrayList<TreeMap<String, String>> imprimirServicios() throws Exception {

        try {
            ArrayList<TreeMap<String, String>> Servicios = new ArrayList<TreeMap<String, String>>();
            ArrayList<Servicio> listaServicios = objServicioDAO.obtenerServicios();

            for (Servicio objServicio : listaServicios) {
                TreeMap<String, String> mapa = new TreeMap<String, String>();

                mapa.put("Codigo", objServicio.getCodigo());
                mapa.put("Nombre", objServicio.getDescripcion());
                mapa.put("Tipo", objServicio.getTipo());
                mapa.put("PrecioBase", String.valueOf(objServicio.getPrecioBase()));
                mapa.put("PrecioLitro", String.valueOf(objServicio.getPrecioLitro()));
                mapa.put("Estado", String.valueOf(objServicio.isEstado()));

                Servicios.add(mapa);
            }

            return Servicios;

        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }

    }
    public ArrayList<TreeMap<String, String>> imprimirServiciosActivo() throws Exception {

        try {
            ArrayList<TreeMap<String, String>> Servicios = new ArrayList<TreeMap<String, String>>();
            ArrayList<Servicio> listaServicios = objServicioDAO.obtenerServiciosActivo();

            for (Servicio objServicio : listaServicios) {
                TreeMap<String, String> mapa = new TreeMap<String, String>();

                mapa.put("Codigo", objServicio.getCodigo());
                mapa.put("Nombre", objServicio.getDescripcion());
                mapa.put("Tipo", objServicio.getTipo());
                mapa.put("PrecioBase", String.valueOf(objServicio.getPrecioBase()));
                mapa.put("PrecioLitro", String.valueOf(objServicio.getPrecioLitro()));
                mapa.put("Estado", String.valueOf(objServicio.isEstado()));

                Servicios.add(mapa);
            }

            return Servicios;

        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }

    }
    public ArrayList<TreeMap<String, String>> imprimirServiciosTipos() throws Exception {

        try {
            ArrayList<TreeMap<String, String>> Servicios = new ArrayList<TreeMap<String, String>>();
            ArrayList<Servicio> listaServicios = objServicioDAO.obtenerServicios();

            for (Servicio objServicio : listaServicios) {
                TreeMap<String, String> mapa = new TreeMap<String, String>();
                mapa.put("Tipo", objServicio.getTipo());

                Servicios.add(mapa);
            }

            return Servicios;

        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }

    }

}
