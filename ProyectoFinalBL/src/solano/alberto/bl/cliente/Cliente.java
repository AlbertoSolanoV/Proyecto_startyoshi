package solano.alberto.bl.cliente;

import java.util.ArrayList;
import solano.alberto.bl.usuario.Usuario;
import solano.alberto.bl.tarjeta.Tarjeta;
import solano.alberto.bl.vehiculo.Vehiculo;
import solano.alberto.bl.direccion.Direccion;

public class Cliente extends Usuario {
    private String avatar;
    private String genero;
    private String celular;
    private ArrayList<Tarjeta> tarjetas;
    private ArrayList<Vehiculo> vehiculo;


    /**
     * @author Alberto Solano
     * Constructor por defecto
     */
    public Cliente() {
        super();
        this.avatar = null;
        this.genero = null;
        this.celular = null;
        this.tarjetas = null;
        this.vehiculo = null;
    }

    /**
     * Constructor
     *
     * @param nombre
     * @param apellidos
     * @param identificacion
     * @param fechaNacimiento
     * @param correo
     * @param clave
     * @param direccion
     */
    public Cliente(String nombre, String apellidos, String identificacion, String fechaNacimiento, String correo, String clave, Direccion direccion, String avatar, String genero, String celular) {
        super(nombre, apellidos, identificacion, fechaNacimiento, 0,correo, clave, direccion);
        this.avatar = avatar;
        this.genero = genero;
        this.celular = celular;
        this.tarjetas = new ArrayList<Tarjeta>();
        this.vehiculo = new ArrayList<Vehiculo>();
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public ArrayList<Tarjeta> getTarjetas() {
        return tarjetas;
    }

    public void setTarjetas(Tarjeta tarjetas) {
        this.tarjetas.add(tarjetas);
    }

    public ArrayList<Vehiculo> getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo.add(vehiculo);
    }
}
