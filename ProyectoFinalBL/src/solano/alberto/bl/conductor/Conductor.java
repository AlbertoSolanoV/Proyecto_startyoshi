package solano.alberto.bl.conductor;


import solano.alberto.bl.direccion.Direccion;
import solano.alberto.bl.usuario.Usuario;

public class Conductor extends  Usuario{
    private String avatar;
    private boolean estado;


    /**
     * @author Alberto Solano
     * Constructor por defecto
     */
    public Conductor() {
        super();
        this.estado = false;
    }

    /**
     * Constructor de la clase

     * Constructor
     *
     * @param nombre
     * @param apellidos
     * @param identificacion
     * @param fechaNacimiento
     * @param edad
     * @param correo
     * @param clave
     * @param direccion
     * @param estado boolean, del estado del conductor
     * @param avatar boolean, del estado del conductor
     */
    public Conductor(String nombre, String apellidos, String identificacion, String fechaNacimiento, int edad, String correo, String clave, Direccion direccion, boolean estado, String avatar) {
        super(nombre, apellidos, identificacion, fechaNacimiento, edad, correo, clave, direccion);
        this.estado = estado;
        this.avatar = avatar;
    }

    /**
     * Metodo "get" para saber el estado
     *
     * @return boolean, del estado
     */
    public boolean isEstado() {
        return estado;
    }

    /**
     * Metodo set para estado
     *
     * @param estado boolean, del estado
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     * Metodo toString de la clase
     *
     * @return String, con la info de la clase
     */
    @Override
    public String toString() {
        return "Conductor{" +
                "avatar='" + avatar + '\'' +
                ", estado=" + estado +
                '}';
    }
}
