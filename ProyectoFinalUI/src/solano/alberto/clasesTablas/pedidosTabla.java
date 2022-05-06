package solano.alberto.clasesTablas;

public class pedidosTabla {
    private String codigo;
    private String descrpcion;
    private String fechaCreacion;
    private String estado;
    private String provincia;
    private String canton;
    private String distrito;

    public pedidosTabla(String codigo,String descrpcion, String fechaCreacion, String estado, String provincia, String canton, String distrito) {
        this.codigo = codigo;
        this.descrpcion = descrpcion;
        this.fechaCreacion = fechaCreacion;
        this.estado = estado;
        this.provincia = provincia;
        this.canton = canton;
        this.distrito = distrito;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescrpcion() {
        return descrpcion;
    }

    public void setDescrpcion(String descrpcion) {
        this.descrpcion = descrpcion;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }
}
