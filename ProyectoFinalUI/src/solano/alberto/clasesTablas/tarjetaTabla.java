package solano.alberto.clasesTablas;

public class tarjetaTabla {
    private String nombre;
    private String numero;
    private String proveedor;
    private String ccv;
    private String fechaVence;

    public tarjetaTabla(String nombre, String numero, String proveedor, String ccv, String fechaVence) {
        this.nombre = nombre;
        this.numero = numero;
        this.proveedor = proveedor;
        this.ccv = ccv;
        this.fechaVence = fechaVence;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getCcv() {
        return ccv;
    }

    public void setCcv(String ccv) {
        this.ccv = ccv;
    }

    public String getFechaVence() {
        return fechaVence;
    }

    public void setFechaVence(String fechaVence) {
        this.fechaVence = fechaVence;
    }
}
