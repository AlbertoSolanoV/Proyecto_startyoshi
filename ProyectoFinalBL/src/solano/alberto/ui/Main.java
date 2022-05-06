package solano.alberto.ui;

import solano.alberto.logic.gestorPedido;
import solano.alberto.logic.gestorTarjetas;
import solano.alberto.logic.gestorUsuarios;

import java.util.ArrayList;
import java.util.TreeMap;


public class Main {

    public static void main(String[] args) throws Exception {

        gestorUsuarios objGestor = new gestorUsuarios();
        gestorTarjetas objGestorT = new gestorTarjetas();

      /*  ArrayList<TreeMap<String, String>> listaPrrovincias = objGestor.imprimirProvincias();

        for (TreeMap<String, String> Provincia : listaPrrovincias) {
            System.out.println(Provincia.get("Codigo"));
            System.out.println(Provincia.get("Nombre"));
        }*/


     /* ArrayList<TreeMap<String, String>> listaConductores = objGestor.imprimirConductores();

        for (TreeMap<String, String> Conductor : listaConductores) {
            System.out.println(Conductor.get("Nombre"));
            System.out.println(Conductor.get("Apellidos"));
            System.out.println(Conductor.get("Avatar"));
            System.out.println(Conductor.get("Identificacion"));
            System.out.println(Conductor.get("Correo"));
            System.out.println(Conductor.get("Clave"));
            System.out.println(Conductor.get("FechaNacimiento"));
            System.out.println(Conductor.get("Edad"));
            System.out.println(Conductor.get("Provincia"));
            System.out.println(Conductor.get("Canton"));
            System.out.println(Conductor.get("Distrito"));
            System.out.println(Conductor.get("Direccion Exacta"));
        }*/

/*String mensajeConductor = objGestor.registrarConductor("Juan","Villalta", "123456789","2000-05-25","juan@correo.com","123",
            "Alajuela","San Ramón", "SANTIAGO", "100mts norte San jose", true, "avatar.jpg");

        System.out.println(mensajeConductor);*/

      /* String mensajeCliente = objGestor.registrarCliente("Alberto","solano Villalta", "118210900","2001-08-31","albertoCliente@correo.com","123"
               ,"Alajuela","San Ramón", "SANTIAGO","100mts norte", "avatar.jpg", "M", "87918947");

       System.out.println(mensajeCliente);*/
    /* String mensajeCliente = objGestor.registrarAdministrador("AlbertoAdmin2","solano VillaltaAdmin2", "1182109021","2001-08-31","albertoAdmin2@correo.com","123"
                ,"Alajuela","San Ramón", "SANTIAGO", "100mts norteAdmin");

      System.out.println(mensajeCliente);*/

       /*String mensajeCliente = objGestorT.registrarTarjeta("albertoCliente@correo.com", "118210900","4013896292373758","Nurbika Johansen","2025-05-01"
                ,"402");

        System.out.println(mensajeCliente);*/

       /*  ArrayList<TreeMap<String, String>> listaTarjetas = objGestorT.imprimirTarjetas("118210900");

        for (TreeMap<String, String> Tarjeta : listaTarjetas) {
            System.out.println(Tarjeta.get("Numero"));
            System.out.println(Tarjeta.get("Nombre"));
            System.out.println(Tarjeta.get("Proveedor"));
            System.out.println(Tarjeta.get("FechaVence"));
            System.out.println(Tarjeta.get("CCV"));
        }*/

       /* gestorPedido objPedido = new gestorPedido();
        ArrayList<TreeMap<String, String>> servicios = new ArrayList<TreeMap<String, String>>();
        TreeMap<String, String> mapa = new TreeMap<String, String>();

        mapa.put("descripcion", "Se cambia 1 llanta del vehiculo");
        mapa.put("tipo", "Cambio de Llantas Vehiculo");

        servicios.add(mapa);

        objPedido.registrarPedido("118210941", "alberto@correo.com",servicios,"Cartago", "Cartago", "DULCE NOMBRE", "100mts norte", "4019698219812999");
*/

        /*gestorPedido objPedido = new gestorPedido();
        objPedido.imprimirPedido();*/
    }
}
