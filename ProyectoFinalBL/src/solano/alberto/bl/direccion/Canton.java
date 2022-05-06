package solano.alberto.bl.direccion;

public class Canton {
    private String codigo;
    private String nombre;
    private String codProvincia;

    public Canton() {
        this.codigo = null;
        this.nombre = null;
        this.codProvincia = null;
    }

    public Canton(String codigo, String nombre, String codProvincia) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.codProvincia = codProvincia;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodProvincia() {
        return codProvincia;
    }

    public void setCodProvincia(String codProvincia) {
        this.codProvincia = codProvincia;
    }
}
