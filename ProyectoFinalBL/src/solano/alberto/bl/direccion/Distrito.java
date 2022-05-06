package solano.alberto.bl.direccion;

public class Distrito {
    private String codigo;
    private String nombre;
    private String codCanton;

    public Distrito() {
        this.codigo = null;
        this.nombre = null;
        this.codCanton = null;
    }

    public Distrito(String codigo, String nombre, String codCanton) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.codCanton = codCanton;
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

    public String getCodCanton() {
        return codCanton;
    }

    public void setCodCanton(String codCanton) {
        this.codCanton = codCanton;
    }
}
