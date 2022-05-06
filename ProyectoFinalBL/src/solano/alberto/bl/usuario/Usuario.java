package solano.alberto.bl.usuario;

import solano.alberto.bl.direccion.Direccion;

public class Usuario {

    private String nombre;
    private String apellidos;
    private String identificacion;
    private String fechaNacimiento;
    private int edad;
    private String correo;
    private String clave;
    private Direccion direccion;


    /**
     * @author Alberto Solano
     * Constructor por defecto
     */
    public Usuario() {
        this.nombre = null;
        this.apellidos = null;
        this.identificacion = null;
        this.fechaNacimiento = null;
        this.edad = 0;
        this.correo = null;
        this.clave = null;
        this.direccion = null;
    }

    /**
     * Constructor
     * @param nombre
     * @param apellidos
     * @param identificacion
     * @param fechaNacimiento
     * @param edad
     * @param correo
     * @param clave
     * @param direccion
     */
    public Usuario(String nombre, String apellidos, String identificacion, String fechaNacimiento, int edad, String correo, String clave, Direccion direccion) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.identificacion = identificacion;
        this.fechaNacimiento = fechaNacimiento;
        this.edad = edad;
        this.correo = correo;
        this.clave = clave;
        this.direccion = direccion;
    }

    /**
     * Metodo get para el nombre del usuario
     * @return String, del nombre del usuario
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo set para el nombre del usuario
     * @param nombre String, del nombre de usuario
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo get para apellido
     * @return String, de apellidos del usuario
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Metodo set para el apellido
     * @param apellidos String, de apellido del usuario
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * Metodo get de la identificacion
     * @return  String, de la identificacion
     */
    public String getIdentificacion() {
        return identificacion;
    }

    /**
     * Metodo set para la identificacion
     * @param identificacion String, de la identificacion del cliente
     */
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    /**
     * Metodo get para la fecha de nacimiento
     * @return String, de la fecha de nacimiento (dd/mm/aa)
     */
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Metodo set para la fecha de nacimiento
     * @param fechaNacimiento String, de la fecha de nacimiento (dd/mm/aa)
     */
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Metodo get para la edad del usuario
     * @return int, con la edad del usuario
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Metodo set para la edad del usuario
     * @param edad int, con la edad del usaurio
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }


    /**
     * Metodo get para el correo
     * @return String, con el correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Metodo set del correo
     * @param correo String, del correo del usuario
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Metodo get de la clave del usuario
     * @return String, de la clave del usuario
     */
    public String getClave() {
        return clave;
    }

    /**
     * Metodo set de la clave del usuario
     * @param clave  String, de la clave del usuario
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

    /**
     * Metodo get de la direccion del usuario
     * @return Direccion, del usuario
     */
    public Direccion getDireccion() {
        return direccion;
    }

    /**
     * Metodo set para la direccion
     * @param direccion Direccion, del usuario
     */
    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }



    /**
     * Metodo toString de la clase
     * @return String, con la informacion de la clase
     */
    @Override
    public String toString() {
        return "Usuario{" +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", identificacion='" + identificacion + '\'' +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                ", edad=" + edad +
                ", correo='" + correo + '\'' +
                ", clave='" + clave + '\'' +
                ", direccion=" + direccion +
                '}';
    }
}
