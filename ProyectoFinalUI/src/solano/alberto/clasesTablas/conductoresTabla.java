package solano.alberto.clasesTablas;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class conductoresTabla {
    private SimpleStringProperty  nombre;
    private SimpleStringProperty  apellidos;
    private SimpleStringProperty  identificacion;
    private SimpleStringProperty  fecha_nacimiento;
    private SimpleStringProperty  edad;
    private SimpleStringProperty  correo;
    private SimpleStringProperty  clave;
    private SimpleStringProperty  estado;
    private SimpleStringProperty  avatar;
    private SimpleStringProperty  Provincia;
    private SimpleStringProperty Canton;
    private SimpleStringProperty  Distrito;
    private SimpleStringProperty  direccion_exacta;


    public conductoresTabla(String nombre, String apellidos, String identificacion, String fecha_nacimiento, String edad, String correo,
                            String clave, String estado, String avatar, String provincia, String canton, String distrito, String direccion_exacta) {
        this.nombre = new SimpleStringProperty(nombre);;
        this.apellidos =  new SimpleStringProperty(apellidos);
        this.identificacion = new SimpleStringProperty(identificacion);
        this.fecha_nacimiento = new SimpleStringProperty(fecha_nacimiento);
        this.edad = new SimpleStringProperty(edad);
        this.correo = new SimpleStringProperty(correo);
        this.clave = new SimpleStringProperty(clave);
        this.estado = new SimpleStringProperty(estado);
        this.avatar = new SimpleStringProperty(avatar);
        Provincia = new SimpleStringProperty(provincia);
        Canton = new SimpleStringProperty(canton);
        Distrito = new SimpleStringProperty(distrito);
        this.direccion_exacta = new SimpleStringProperty(direccion_exacta);
    }

    public String getNombre() {
        return nombre.get();
    }

    public SimpleStringProperty nombreProperty() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    public String getApellidos() {
        return apellidos.get();
    }

    public SimpleStringProperty apellidosProperty() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos.set(apellidos);
    }

    public String getIdentificacion() {
        return identificacion.get();
    }

    public SimpleStringProperty identificacionProperty() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion.set(identificacion);
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento.get();
    }

    public SimpleStringProperty fecha_nacimientoProperty() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento.set(fecha_nacimiento);
    }

    public String getEdad() {
        return edad.get();
    }

    public SimpleStringProperty edadProperty() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad.set(edad);
    }

    public String getCorreo() {
        return correo.get();
    }

    public SimpleStringProperty correoProperty() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo.set(correo);
    }

    public String getClave() {
        return clave.get();
    }

    public SimpleStringProperty claveProperty() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave.set(clave);
    }

    public String getEstado() {
        return estado.get();
    }

    public SimpleStringProperty estadoProperty() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado.set(estado);
    }

    public String getAvatar() {
        return avatar.get();
    }

    public SimpleStringProperty avatarProperty() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar.set(avatar);
    }

    public String getProvincia() {
        return Provincia.get();
    }

    public SimpleStringProperty provinciaProperty() {
        return Provincia;
    }

    public void setProvincia(String provincia) {
        this.Provincia.set(provincia);
    }

    public String getCanton() {
        return Canton.get();
    }

    public SimpleStringProperty cantonProperty() {
        return Canton;
    }

    public void setCanton(String canton) {
        this.Canton.set(canton);
    }

    public String getDistrito() {
        return Distrito.get();
    }

    public SimpleStringProperty distritoProperty() {
        return Distrito;
    }

    public void setDistrito(String distrito) {
        this.Distrito.set(distrito);
    }

    public String getDireccion_exacta() {
        return direccion_exacta.get();
    }

    public SimpleStringProperty direccion_exactaProperty() {
        return direccion_exacta;
    }

    public void setDireccion_exacta(String direccion_exacta) {
        this.direccion_exacta.set(direccion_exacta);
    }
}
