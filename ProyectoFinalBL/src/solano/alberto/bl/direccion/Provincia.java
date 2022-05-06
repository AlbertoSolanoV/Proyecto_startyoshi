package solano.alberto.bl.direccion;

public class Provincia {
    private String nombre;
    private String codigo;
    public Provincia() {
        this.nombre = null;
        this.codigo = null;
    }

    public Provincia(String codigo,String nombre) {
        this.nombre = nombre;
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
