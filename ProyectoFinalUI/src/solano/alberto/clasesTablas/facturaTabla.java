package solano.alberto.clasesTablas;

public class facturaTabla {
    private String codigo;
    private String fechaCreacion;
    private String total;

    public facturaTabla(String codigo, String fechaCreacion, String total) {
        this.codigo = codigo;
        this.fechaCreacion = fechaCreacion;
        this.total = total;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
