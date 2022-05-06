package solano.alberto.logic;

import solano.alberto.bl.tarjeta.Tarjeta;
import solano.alberto.bl.vehiculo.Carro;
import solano.alberto.bl.vehiculo.Moto;
import solano.alberto.bl.vehiculo.VehiculoDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.TreeMap;

public class gestorVehiculos {

    VehiculoDAO objVehiculoDAO = new VehiculoDAO();

    public String registrarCarro(String correo, String id, String placa, String marca, String color, String tipo) throws Exception {
        try {
            String mensaje = "";
            Carro objCarro = new Carro(placa, marca, color, tipo);
            mensaje = objVehiculoDAO.registrarAutomovil(objCarro, correo, id);

            return mensaje;
        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }

    }

    public String registrarMoto(String correo, String id, String placa, String marca, String tipo) throws Exception {
        try {
            String mensaje = "";
            Moto objMoto = new Moto(placa, marca, tipo);
            mensaje = objVehiculoDAO.registrarMoto(objMoto, correo, id);

            return mensaje;
        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }

    }


    public ArrayList<TreeMap<String, String>> imprimirTipoCarro() throws Exception {

        try {
            ArrayList<TreeMap<String, String>> Carros = new ArrayList<TreeMap<String, String>>();
            ArrayList<Carro> listaCarrosTipo = objVehiculoDAO.obtenerTipoAutomovil();

            for (Carro objCarro : listaCarrosTipo) {
                TreeMap<String, String> mapa = new TreeMap<String, String>();

                mapa.put("Tipo", objCarro.getTipo());


                Carros.add(mapa);
            }

            return Carros;

        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }

    }

    public ArrayList<TreeMap<String, String>> imprimirTipoMoto() throws Exception {
        try {
            ArrayList<TreeMap<String, String>> Motos = new ArrayList<TreeMap<String, String>>();
            ArrayList<Moto> listaMotosTipo = objVehiculoDAO.obtenerTipoMoto();

            for (Moto objMoto : listaMotosTipo) {
                TreeMap<String, String> mapa = new TreeMap<String, String>();

                mapa.put("Tipo", objMoto.getTipo());
                Motos.add(mapa);
            }

            return Motos;

        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }

    }

    public ArrayList<TreeMap<String, String>> imprimirCarro(String id) throws Exception {

        try {
            ArrayList<TreeMap<String, String>> Carros = new ArrayList<TreeMap<String, String>>();
            ArrayList<Carro> listaCarrosTipo = objVehiculoDAO.obtenerCarro(id);

            for (Carro objCarro : listaCarrosTipo) {
                TreeMap<String, String> mapa = new TreeMap<String, String>();
                mapa.put("Placa", objCarro.getPlaca());
                mapa.put("Marca", objCarro.getMarca());
                mapa.put("Color", objCarro.getColor());
                mapa.put("Tipo", objCarro.getTipo());


                Carros.add(mapa);
            }

            return Carros;

        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }

    }

    public ArrayList<TreeMap<String, String>> imprimirMoto(String id) throws Exception {
        try {
            ArrayList<TreeMap<String, String>> Motos = new ArrayList<TreeMap<String, String>>();
            ArrayList<Moto> listaMotosTipo = objVehiculoDAO.obtenerMoto(id);

            for (Moto objMoto : listaMotosTipo) {
                TreeMap<String, String> mapa = new TreeMap<String, String>();
                mapa.put("Placa", objMoto.getPlaca());
                mapa.put("Marca", objMoto.getMarca());
                mapa.put("Tipo", objMoto.getTipo());
                Motos.add(mapa);
            }

            return Motos;

        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }

    }

    public String eliminarCarro(String placa) throws Exception {
        try{

            return objVehiculoDAO.eliminarCarro(placa);
        }catch (Exception e){
            throw e;
        }
    }
    public String eliminarMoto(String placa) throws Exception {
        try{

            return objVehiculoDAO.eliminarMoto(placa);
        }catch (Exception e){
            throw e;
        }
    }
}
